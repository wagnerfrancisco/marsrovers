package com.mezaroba;

public class Rover {

	private Plateau plateau;
	private Location currentLocation;
	private Orientation currentOrientation;
	
	public void insertOn(Plateau plateau, Location initialLocation, Orientation initialOrientation) {
		if (initialOrientation == null) {
			throw new NullPointerException("initial orientation must not be null");
		}
		
		if (!plateau.hasLocation(initialLocation)) {
			throw new IllegalStateException("initial location not in plateau");
		}
		
		this.plateau = plateau;
		this.currentLocation = initialLocation;
		this.currentOrientation = initialOrientation;
	}
	
	public void processInstruction(NavigationInstruction instruction) {
		if (instruction == NavigationInstruction.L) {
			currentOrientation = Orientation.onTheLeftOf(currentOrientation);	
		} else if (instruction == NavigationInstruction.R) {
			currentOrientation = Orientation.onTheRightOf(currentOrientation);
		} else if (instruction == NavigationInstruction.M) {
			handleMoveInstruction();
		}
	}
	
	private void handleMoveInstruction() {
		Location newLocation = null;
		
		if (currentOrientation == Orientation.N) {
			newLocation = new Location(currentLocation.getX(), currentLocation.getY() + 1);
		} else if (currentOrientation == Orientation.E) {
			newLocation = new Location(currentLocation.getX() + 1, currentLocation.getY());
		} else if  (currentOrientation == Orientation.S) {
			newLocation = new Location(currentLocation.getX(), currentLocation.getY() - 1);
		} else if  (currentOrientation == Orientation.W) {
			newLocation = new Location(currentLocation.getX() - 1, currentLocation.getY());
		}
		
		if (!plateau.hasLocation(newLocation)) {
			throw new IllegalStateException("out of the plateau");
		}
		
		this.currentLocation = newLocation;
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	public Orientation getCurrentOrientation() {
		return currentOrientation;
	}
}
