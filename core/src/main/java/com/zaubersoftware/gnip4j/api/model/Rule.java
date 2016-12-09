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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 */
@JsonAutoDetect
public final class Rule implements Serializable {
    private static final long serialVersionUID = -6252436995868989738L;
    private String value;
    private String tag;

    public Rule() {
    }

    public Rule(String value) {
    	this(value, null);
    }

    public Rule(String value, String tag) {
    	this.value = value;
    	this.tag = tag;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    
    public void setTag(final String value) {
        tag = value;
    }
    
    @Override
    public boolean equals(final java.lang.Object obj) {
        boolean ret = false;
        
        if(this == obj) {
            ret = true;
        } else if(obj instanceof Rule) {
            final Rule r = (Rule)obj;
            
            // The tag is irrelevant for equality. Only compare the 
            // value (case-insensitive).
            ret = equalsIgnoreCase(value, r.value); 
        }
        return ret;
    }

    @Override
    public int hashCode() {
    	return value != null ? value.toLowerCase().hashCode() : 0;
    }
    
    private static boolean equalsIgnoreCase(final String s1, final String s2) {
        boolean ret = false;
        if(s1 == null && s2 == null) {
            ret = true;
        } else if(s1 == null || s2 == null) {
            ret = false;
        } else {
            ret = s1.equalsIgnoreCase(s2);
        }
        return ret;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if(tag != null) {
            sb.append(tag);
        }
        if(sb.length() != 0) {
            sb.append(' ');
        }
        sb.append(value);
        return sb.toString();
    }
}
