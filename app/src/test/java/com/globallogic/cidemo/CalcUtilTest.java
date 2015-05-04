package com.globallogic.cidemo;

import org.junit.Test;

import junit.framework.Assert;

public class CalcUtilTest {

	@Test
	public void testAdd() {
		int value1 = 2;
		int value2 = 3;
		
		Assert.assertEquals(5, CalcUtil.get().add(value1, value2));
	}
	
	@Test
	public void testMult() {
		int value1 = 2;
		int value2 = 3;
		
		Assert.assertEquals(6, CalcUtil.get().mult(value1, value2));
	}
}
