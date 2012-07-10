package com.thoughtworks;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoverControllerTest {

	@Test
	public void shouldProduceValidOutput() {
		String input = "5 5\n1 2 N\nLMR";
		String expectedOutput = "0 2 N";
		
		String result = (new RoverController(input)).getOutput();
		assertEquals(expectedOutput, result);
	}
	
	@Test
	public void shouldProduceValidOutput_2() {
		String input = "5 5\n1 2 N\nLMLMLMLMM";
		String expectedOutput = "1 3 N";
		
		String result = (new RoverController(input)).getOutput();
		assertEquals(expectedOutput, result);
	}
	
	@Test
	public void shouldProduceValidOutput_3() {
		String input = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";
		String expectedOutput = "1 3 N\n5 1 E";
		
		String result = (new RoverController(input)).getOutput();
		assertEquals(expectedOutput, result);
	}
}