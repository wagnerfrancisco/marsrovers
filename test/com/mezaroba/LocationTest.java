package com.mezaroba;

import static org.junit.Assert.*;
import org.junit.Test;

import com.mezaroba.Location;

public class LocationTest {
	
	@Test
	public void shouldInstantiateValidLocations() {
		assertNotNull(new Location(0, 0));
		assertNotNull(new Location(0, 1));
		assertNotNull(new Location(1, 0));
		assertNotNull(new Location(1, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotInstantiateLocationWithNegativeX() {
		new Location(-1, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotInstantiateLocationWithNegativeY() {
		new Location(0, -1);
	}
	
	@Test
	public void testEqualsReflexivity() {
		Location one = new Location(0, 1);				
		assertEquals(one, one);
	}
	
	@Test
	public void testEqualsSimmetry() {
		Location one = new Location(0, 1);
		Location two = new Location(0, 1);		
		assertEquals(one, two);
		assertEquals(two, one);
	}
	
	@Test
	public void equalsShouldReturnFalseIfLocationsAreDifferent() {
		Location one = new Location(0, 1);
		Location two = new Location(0, 0);		
		assertFalse(one.equals(two));
	}
	
	@Test
	public void hashCodeShouldBeEqualForEqualObjects() {
		Location one = new Location(0, 1);
		Location two = new Location(0, 1);
		
		assertEquals(one.hashCode(), two.hashCode());
	}
}
