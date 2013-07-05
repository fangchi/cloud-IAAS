package com.hicomb.bmc.bladelogic.rest.common;

import junit.framework.TestCase;

public class BladeLogicCommonConstTestCase extends TestCase {
	
	public static final void testConst() {
		assertEquals("/type/PropertySetClasses/SystemObject/{type}/", BladeLogicCommonConst.BLADELOGIC_QUERY_SYSTEMOBJECTS_URL);
	}
}
