/**
 * Copyright (c) 2011-2012 Zauber S.A. <http://www.zaubersoftware.com/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zaubersoftware.gnip4j.api.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * TODO Descripcion de la clase. Los comentarios van en castellano.
 *
 *
 * @author Martin Silva
 * @since Feb 15, 2012
 */
public class GeoDeserializer extends StdDeserializer<Geo> {
	private static final long serialVersionUID = -4968396936087643364L;

	/** Creates the GeoDeserializer. */
    public GeoDeserializer(final Class<Geo> clazz) {
        super(clazz);
    }

    @Override
    public Geo deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        final JsonNode tree = jp.readValueAsTree();

        final JsonNode coordinates = tree.get("coordinates");
        final JsonNode type = tree.get("type");
        final JsonNode objectType = tree.get("objectType");

        final Geo geo = new Geo();
        geo.setType(type.asText());

        if(Geometries.valueOf(type.asText()) == Geometries.Polygon) {
            geo.setCoordinates(this.createPolygon(coordinates));
        } else {
            geo.setCoordinates(this.createPoint(coordinates, objectType != null && "place".equals(objectType.asText())));
        }

        return geo;
    }

    /** @return a point */
    private Point createPoint(final JsonNode coordinates, boolean geoJson) throws IOException {
        final Point ret;
        if(coordinates.isArray()) {
        	// The deprecated "geo" entity uses lat,lng while places and and polygon points use lng,lat. 
        	if (!geoJson)
        		ret = new Point(coordinates.get(0).asDouble(), coordinates.get(1).asDouble());
        	else
        		ret = new Point(coordinates.get(1).asDouble(), coordinates.get(0).asDouble());
        } else {
            ret = new Point(coordinates.get("latitude").asDouble(), 
                    coordinates.get("longitude").asDouble());
        }
        return ret;
    }

    /** @return a polygon */
    private Polygon createPolygon(final JsonNode coordinates) throws IOException {
        final List<Point> points = new ArrayList<Point>();
        final Iterator<JsonNode> elements;
        if(coordinates.has("points")) {
            elements = coordinates.get("points").iterator();
        } else {
            final JsonNode values = coordinates.get(0);
            elements = values.elements();
        }
        while(elements.hasNext()) {
            final JsonNode next = elements.next();
            points.add(createPoint(next, true));
        }
        return new Polygon(points);
    }

}
