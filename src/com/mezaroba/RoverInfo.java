package com.mezaroba;

public class RoverInfo {

	private Location initialLocation;
	private Orientation orientation;
	private NavigationInstruction[] instructions;

	public RoverInfo(Location initialLocation, Orientation orientation) {
		if (initialLocation == null) {
			throw new NullPointerException("initialLocation must not be null");
		}
		
		if (orientation == null) {
			throw new NullPointerException("orientation must not be null");
		}
		
		this.initialLocation = initialLocation;
		this.orientation = orientation;
	}

	public Location getInitialLocation() {
		return initialLocation;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public NavigationInstruction[] getInstructions() {
		return instructions;
	}

	public void setInstructions(NavigationInstruction[] instructions) {
		this.instructions = instructions;
	}

}
