package com.thoughtworks;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputProcessorTest {

	private static final String validInput = "5 5\n1 2 N\nLMLMLMLMM";
	
	private static final String upperRightCoordinateWithLetters_x = "A 5\n1 2 N\nLMLMLMLMM";
	private static final String upperRightCoordinateWithLetters_y = "1 B\n1 2 N\nLMLMLMLMM";
	private static final String threeNumbersInTheFirstLine = "1 2 3\n1 2 N\nLMLMLMLMM";
	private static final String oneNumberInTheFirstLine = "1\n1 2 N\nLMLMLMLMM";
	
	@Test
	public void shouldAcceptValidInput() {
		new InputProcessor(validInput);
	}
	
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
	public void shouldAllowOnlyTwoNumbersInTheFirstLine_threeNumbers() {
		new InputProcessor(threeNumbersInTheFirstLine);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldAllowOnlyTwoNumbersInTheFirstLine_oneNumber() {
		new InputProcessor(oneNumberInTheFirstLine);
	}
}
