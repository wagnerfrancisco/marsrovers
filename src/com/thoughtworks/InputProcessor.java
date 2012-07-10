package com.thoughtworks;

import java.util.Arrays;

public class InputProcessor {
	
	private Plateau plateau;
	private RoverInfo[] info;
	
	public InputProcessor(String input) {
		String[] lines = input.split("\n");
		
		processFirstLine(lines[0]);
		processRemainderLines(Arrays.copyOfRange(lines, 1, lines.length));		
	}
	
	private void processFirstLine(String firstLine) {
		String tokens[] = firstLine.trim().split(" ");
		
		if (tokens.length != 2) {
			throw new IllegalArgumentException("first line must have only two numbers");
		}
		
		int x = Integer.parseInt(tokens[0]);
		int y = Integer.parseInt(tokens[1]);
		
		plateau = Plateau.fromUpperRightCoordinate(new Location(x, y));
	}
	
	private void processRemainderLines(String[] lines) {
		int numberOfRovers = lines.length / 2;
		info = new RoverInfo[numberOfRovers];
		
		RoverInfo r = null;
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			
			if (r == null) {
				String[] tokens = line.trim().split(" ");				
				int x = Integer.parseInt(tokens[0]);
				int y = Integer.parseInt(tokens[1]);
				Location initialLocation = new Location(x, y);
				Orientation orientation = Orientation.valueOf(tokens[2]);
				
				r = new RoverInfo(initialLocation, orientation);
				info[i / 2] = r;
			} else {
				NavigationInstruction[] instructions = processInstructions(line);
				r.setInstructions(instructions);
				r = null;
			}
		}
	}
	
	private NavigationInstruction[] processInstructions(String instructionsLine) {
		int numberOfInstructions = instructionsLine.length();
		NavigationInstruction[] instructions = new NavigationInstruction[numberOfInstructions];
		
		for (int i = 0; i < numberOfInstructions; i++) {
			NavigationInstruction instruction = NavigationInstruction.valueOf(String.valueOf(instructionsLine.charAt(i)));
			if (instruction == null) {
				throw new IllegalArgumentException(instructionsLine.charAt(i) + " is not a valid navigation instruction");
			}
			instructions[i] = instruction;
		}
		
		return instructions;
	}
	
	public Plateau createPlateau() {
		return plateau;
	}
	
	public RoverInfo[] getRoversInfo() {
		return info;
	}
}
