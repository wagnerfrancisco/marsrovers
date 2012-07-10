package com.thoughtworks;

import static org.junit.Assert.*;
import org.junit.Test;

public class InputProcessorTest {

	private static final String validInput = "5 5\n1 2 N\nLMR";
	
	private static final String upperRightCoordinateWithLetters_x = "A 5\n1 2 N\nLMLMLMLMM";
	private static final String upperRightCoordinateWithLetters_y = "1 B\n1 2 N\nLMLMLMLMM";
	private static final String threeNumbersInTheUpperRightCoordinate = "1 2 3\n1 2 N\nLMLMLMLMM";
	private static final String oneNumberInTheUpperRightCoordinate = "1\n1 2 N\nLMLMLMLMM";	
	
	private static final String invalidNavigationRequest = "5 5\n1 2 N\nPMLMLMLMM";
		
	@Test
	public void shouldCreatePlateau() {
		Plateau plateau = new InputProcessor(validInput).createPlateau();
		assertEquals(6, plateau.getNumberOfColumns());
		assertEquals(6, plateau.getNumberOfLines());
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldAcceptOnlyNumbersInTheFirstLine_x() {
		new InputProcessor(upperRightCoordinateWithLetters_x);
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldAcceptOnlyNumbersInTheFirstLine_y() {
		new InputProcessor(upperRightCoordinateWithLetters_y);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowMoreThanTwoNumbersInTheFirstLine() {
		new InputProcessor(threeNumbersInTheUpperRightCoordinate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowLessThanTwoNumbersInTheFirstLine() {
		new InputProcessor(oneNumberInTheUpperRightCoordinate);
	}
	
	@Test
	public void shouldProduceRoverInfo() {
		RoverInfo[] infos = new InputProcessor(validInput).getRoversInfo();
		assertEquals(1, infos.length);
		
		RoverInfo first = infos[0];
		assertEquals(new Location(1, 2), first.getInitialLocation());
		assertEquals(Orientation.N, first.getOrientation());
		
		NavigationInstruction[] expected = {
				NavigationInstruction.L,
				NavigationInstruction.M,
				NavigationInstruction.R
		};
		
		assertArrayEquals(expected, first.getInstructions());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowInvalidNavigationInstruction() {
		new InputProcessor(invalidNavigationRequest);
	}
}
