package com.thoughtworks;

import java.util.Arrays;
import java.util.List;

public enum Orientation {
	N, S, W, E;	
	
	public static Orientation onTheLeftOf(Orientation orientation) {
		int index = getOrientationIndex(orientation) - 1;
		
		if (index < 0) {
			index = orientations.size() - 1;
		}

		return orientations.get(index);
	}
	
	public static Orientation onTheRightOf(Orientation orientation) {
		int index = getOrientationIndex(orientation) + 1;

		if (index == orientations.size()) {
			index = 0;
		}

		return orientations.get(index);
	}
	
	private static int getOrientationIndex(Orientation orientation) {
		int index = orientations.indexOf(orientation);
		
		if (index < 0) {
			throw new IllegalStateException("Orientation not found");
		}
		
		return index;
	}
	
	private static List<Orientation> orientations = Arrays.asList(N, E, S, W);
}
