package com.thoughtworks;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlateauTest {

	@Test
	public void shouldInstantiatePlateauWithPositiveCoordinates() {
		Plateau plateau = new Plateau(1, 2);
		
		assertEquals(2, plateau.getNumberOfColumns());
		assertEquals(3, plateau.getNumberOfLines());
	}
	
	@Test
	public void shouldInstantiatePlateauWithCoordinateZero() {
		Plateau plateau = new Plateau(0, 0);
		
		assertEquals(1, plateau.getNumberOfColumns());
		assertEquals(1, plateau.getNumberOfLines());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfUpperRightCoordinate_x_IsNegative() {		
		new Plateau(-1, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfUpperRightCoordinate_y_IsNegative() {		
		new Plateau(0, -1);
	}
}
