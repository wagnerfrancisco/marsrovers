package com.thoughtworks;

public class InputProcessor {
	
	private Plateau plateau;
	
	public InputProcessor(String input) {
		String[] lines = input.split("\n");
		
		String firstLine = lines[0];
		String tokens[] = firstLine.trim().split(" ");
		
		if (tokens.length != 2) {
			throw new IllegalArgumentException("first line must have only two numbers");
		}
		
		int x = Integer.parseInt(tokens[0]);
		int y = Integer.parseInt(tokens[1]);
		
		plateau = new Plateau(x, y);
	}
	
	public Plateau createPlateau() {
		return plateau;
	}
}
