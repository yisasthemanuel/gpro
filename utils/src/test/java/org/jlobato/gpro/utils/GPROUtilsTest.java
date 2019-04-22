package org.jlobato.gpro.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GPROUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIDManagerFromLink() {
		assertEquals("113612", GPROUtils.getIDManagerFromLink("ManagerProfile.asp?IDM=113612"));
	}
	
	@Test
	public void testCategoryAndGroup() {
		String group = "M-1";
		assertEquals("M", GPROUtils.getCategoryCode(group));
		assertEquals("1", GPROUtils.getGroupId(group));
		
		group = "Elite";
		assertEquals("E", GPROUtils.getCategoryCode(group));
		assertNull(GPROUtils.getGroupId(group));
	}
	
	@Test
	public void testDriverEnergy() {
		//Test driver energy
		String driverEnergyExample = "98% > 90%";
		assertEquals(98, GPROUtils.getDriverEnergyAtStart(driverEnergyExample));
		assertEquals(90, GPROUtils.getDriverEnergyAtEnd(driverEnergyExample));
	}

}
