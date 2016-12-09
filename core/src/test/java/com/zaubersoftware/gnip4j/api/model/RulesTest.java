package com.zaubersoftware.gnip4j.api.model;

import org.junit.Assert;
import org.junit.Test;

public class RulesTest {
	@Test
	public void testEquality() {
		Rule rule1 = new Rule("value");
		Rule rule2 = new Rule("value", "tag1");
		Rule rule3 = new Rule("value", "tag2");
		
		Rule rule4 = new Rule("another value");
		
		Assert.assertTrue(rule1.equals(rule2));
		Assert.assertTrue(rule2.equals(rule3));
		Assert.assertFalse(rule1.equals(rule4));
		Assert.assertFalse(rule2.equals(rule4));
		Assert.assertFalse(rule3.equals(rule4));
		
		Assert.assertEquals(rule1.hashCode(), rule2.hashCode());
		Assert.assertEquals(rule2.hashCode(), rule3.hashCode());
		Assert.assertNotEquals(rule1.hashCode(), rule4.hashCode());
		Assert.assertNotEquals(rule2.hashCode(), rule4.hashCode());
		Assert.assertNotEquals(rule3.hashCode(), rule4.hashCode());
	}
	
	@Test
	public void testCase() {
		Rule rule1 = new Rule("value");
		Rule rule2 = new Rule("VaLue");
		Rule rule3 = new Rule("VALUE");
		
		Assert.assertTrue(rule1.equals(rule2));
		Assert.assertTrue(rule2.equals(rule3));
		
		Assert.assertEquals(rule1.hashCode(), rule2.hashCode());
		Assert.assertEquals(rule2.hashCode(), rule3.hashCode());
	}
	
	@Test
	public void testRules() {
		Rules rules = new Rules();
		
		Rule rule1 = new Rule("value1");
		Rule rule2 = new Rule("value2");
		
		rules.getRules().add(rule1);
		Assert.assertEquals(1, rules.getRules().size());
		Assert.assertTrue(rules.contains("value1"));
		Assert.assertTrue(rules.contains(rule1));
		
		rules.getRules().add(rule2);
		Assert.assertEquals(2, rules.getRules().size());
		Assert.assertTrue(rules.contains("value2"));
		Assert.assertTrue(rules.contains(rule2));
		
		Assert.assertEquals(rule1, rules.getRules().iterator().next());
	}
}