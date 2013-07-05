package com.hicomb.rest;

import junit.framework.TestCase;

import org.apache.log4j.PropertyConfigurator;

public abstract class RestBaseTestCase extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		PropertyConfigurator.configure("src/test/resources/com/hicomb/rest/properties/log4j.properties");
	}
	
}
