package com.thoughtworks;

public class Plateau {

	private int numberOfColumns;
	private int numberOfLines;
	
	public Plateau(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("coordinates must not be negative");
		}
		numberOfColumns = x + 1;
		numberOfLines = y + 1;
	}
	
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	public int getNumberOfLines() {
		return numberOfLines;
	}
}
