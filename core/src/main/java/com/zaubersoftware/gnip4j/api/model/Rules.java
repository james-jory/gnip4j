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
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 */
@JsonAutoDetect
public final class Rules implements Serializable {
    private static final long serialVersionUID = 1L;
    private Set<Rule> rules;

    public Rules() {
    }
    
    public Rules(Collection<Rule> rules) {
    	this.rules = new LinkedHashSet<Rule>(rules);
    }
    
    /**
     * Gets the value of the rule property.
     *
     * <p>
     * This accessor method returns a reference to the live set,
     * not a snapshot. Therefore any modification you make to the
     * returned set will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rule property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRules().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the set
     * {@link Rule }
     *
     *
     */
    public Set<Rule> getRules() {
        if (rules == null) {
            rules = new LinkedHashSet<Rule>();
        }
        return rules;
    }

    /**
     * Returns true if a rule with the specified value exists in this
     * Rules collection.
     * 
     * @param value Rule value to check
     * @return true if a Rule with same value exists in this Rules collection
     */
    public boolean contains(String value) {
    	return rules != null ? rules.contains(new Rule(value)) : false;
    }

    /**
     * Returns true if a rule exists in this Rules collection.
     * 
     * @param rule Rule to check
     * @return true if a Rule with the same value as the Rule's value exists in this Rules collection
     */
    public boolean contains(Rule rule) {
    	return rules != null && rule != null ? rules.contains(rule) : false;
    }
}
