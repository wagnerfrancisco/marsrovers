package com.mezaroba;

import static org.junit.Assert.*;
import org.junit.Test;

import com.mezaroba.Location;
import com.mezaroba.Plateau;

public class PlateauTest {

	@Test
	public void shouldInstantiatePlateauWithPositiveCoordinates() {
		Location upperRightCoordinate = new Location(1, 2);
		Plateau plateau = Plateau.fromUpperRightCoordinate(upperRightCoordinate);
		
		assertEquals(2, plateau.getNumberOfColumns());
		assertEquals(3, plateau.getNumberOfLines());
	}
	
	@Test
	public void shouldInstantiatePlateauWithCoordinateZero() {
		Location upperRightCoordinate = new Location(0, 0);
		Plateau plateau = Plateau.fromUpperRightCoordinate(upperRightCoordinate);
		
		assertEquals(1, plateau.getNumberOfColumns());
		assertEquals(1, plateau.getNumberOfLines());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfUpperRightCoordinate_x_IsNegative() {
		Location upperRightCoordinate = new Location(-1, 0);
		Plateau.fromUpperRightCoordinate(upperRightCoordinate);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfUpperRightCoordinate_y_IsNegative() {		
		Location upperRightCoordinate = new Location(0, -1);
		Plateau.fromUpperRightCoordinate(upperRightCoordinate);
	}
	
	@Test
	public void shouldReturnTrueIfLocationIsInsideThePlateau() {
		Location upperRightCoordinate = new Location(1, 1);
		Plateau plateau = Plateau.fromUpperRightCoordinate(upperRightCoordinate);
		
		Location zeroZero = new Location(0, 0);
		Location zeroOne = new Location(0, 1);
		Location oneZero = new Location(1, 0);
		Location oneOne = new Location(1, 1);
		
		assertTrue(plateau.hasLocation(zeroZero));
		assertTrue(plateau.hasLocation(zeroOne));
		assertTrue(plateau.hasLocation(oneZero));
		assertTrue(plateau.hasLocation(oneOne));
	}
	
	@Test
	public void shouldReturnFalseIfLocationIsOutOfThePlateau() {
		Location upperRightCoordinate = new Location(1, 1);
		Plateau plateau = Plateau.fromUpperRightCoordinate(upperRightCoordinate);
		
		Location zeroTwo = new Location(0, 2);
		Location twoZero = new Location(2, 0);
		
		assertFalse(plateau.hasLocation(zeroTwo));
		assertFalse(plateau.hasLocation(twoZero));
	}
}
