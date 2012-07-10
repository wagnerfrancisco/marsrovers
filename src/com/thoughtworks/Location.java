package com.thoughtworks;

public class Location {

	private int x;
	private int y;

	public Location(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("x and y must be greater or equal to 0");
		}
		
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "Location(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Location)) {
			return false;
		}
		
		Location other = (Location) obj;
		return x == other.x && y == other.y;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + x;
		result = 37 * result + y;
		return result;
	}	
}
