package com.mezaroba;

import static org.junit.Assert.*;
import org.junit.Test;

import com.mezaroba.Orientation;

public class OrientationTest {

	@Test
	public void shouldReturnOrientationOnTheLeft() {
		assertEquals(Orientation.W, Orientation.onTheLeftOf(Orientation.N));
		assertEquals(Orientation.N, Orientation.onTheLeftOf(Orientation.E));
		assertEquals(Orientation.E, Orientation.onTheLeftOf(Orientation.S));
		assertEquals(Orientation.S, Orientation.onTheLeftOf(Orientation.W));
	}
	
	@Test
	public void shouldReturnOrientationOnTheRight() {
		assertEquals(Orientation.E, Orientation.onTheRightOf(Orientation.N));
		assertEquals(Orientation.S, Orientation.onTheRightOf(Orientation.E));
		assertEquals(Orientation.W, Orientation.onTheRightOf(Orientation.S));
		assertEquals(Orientation.N, Orientation.onTheRightOf(Orientation.W));
	}
}
