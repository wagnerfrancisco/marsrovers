package com.thoughtworks;

public class Plateau {

	private int numberOfColumns;
	private int numberOfLines;
	
	public Plateau(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("plateau size must not be negative");
		}
		numberOfColumns = x;
		numberOfLines = y;
	}
	
	public boolean hasLocation(Location location) {
		return location.getX() < numberOfColumns && location.getY() < numberOfLines;
	}
	
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	public int getNumberOfLines() {
		return numberOfLines;
	}
	
	public static Plateau fromUpperRightCoordinate(Location location) {
		return new Plateau(location.getX() + 1, location.getY() + 1);
	}
}
