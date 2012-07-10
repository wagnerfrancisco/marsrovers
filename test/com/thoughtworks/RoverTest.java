package com.thoughtworks;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoverTest {
	
	@Test(expected = IllegalStateException.class)
	public void shouldNotInsertRoverOutOfPlateau() {
		Rover r = new Rover();
		Location location = new Location(5, 6);
		Plateau plateau = Plateau.fromUpperRightCoordinate(new Location(5, 5));
		r.insertOn(plateau, location, Orientation.N);
	}
	
	@Test
	public void shouldInsertRoverIntoThePlateau() {
		Rover rover = new Rover();
		Location location = new Location(5, 5);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		rover.insertOn(plateau, location, Orientation.N);
		
		assertEquals(new Location(5, 5), rover.getCurrentLocation());
		assertEquals(Orientation.N, rover.getCurrentOrientation());		
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldNotInsertNullOrientation() {
		Rover rover = new Rover();
		Location location = new Location(1, 1);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		rover.insertOn(plateau, location, null);		
	}
	
	@Test
	public void shouldTurnLeft() {
		Rover rover = new Rover();
		Location location = new Location(1, 1);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		rover.insertOn(plateau, location, Orientation.N);
		
		assertEquals(Orientation.N, rover.getCurrentOrientation());
		
		rover.processInstruction(NavigationInstruction.L);
		assertEquals(Orientation.W, rover.getCurrentOrientation());
		
		rover.processInstruction(NavigationInstruction.L);
		assertEquals(Orientation.S, rover.getCurrentOrientation());
		
		rover.processInstruction(NavigationInstruction.L);
		assertEquals(Orientation.E, rover.getCurrentOrientation());
		
		rover.processInstruction(NavigationInstruction.L);
		assertEquals(Orientation.N, rover.getCurrentOrientation());
	}
	
	@Test
	public void shouldTurnRight() {
		Rover rover = new Rover();
		Location location = new Location(5, 5);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		rover.insertOn(plateau, location, Orientation.N);
		
		assertEquals(Orientation.N, rover.getCurrentOrientation());
		
		rover.processInstruction(NavigationInstruction.R);
		assertEquals(Orientation.E, rover.getCurrentOrientation());
		
		rover.processInstruction(NavigationInstruction.R);
		assertEquals(Orientation.S, rover.getCurrentOrientation());
		
		rover.processInstruction(NavigationInstruction.R);
		assertEquals(Orientation.W, rover.getCurrentOrientation());
		
		rover.processInstruction(NavigationInstruction.R);
		assertEquals(Orientation.N, rover.getCurrentOrientation());
	}
	
	@Test
	public void shouldMoveToNorth() {
		Rover rover = new Rover();
		Location location = new Location(2, 2);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		Location initialLocation = new Location(0, 0);
		
		rover.insertOn(plateau, initialLocation, Orientation.N);
		
		assertEquals(new Location(0, 0), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);		
		assertEquals(new Location(0, 1), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);		
		assertEquals(new Location(0, 2), rover.getCurrentLocation());
	}
	
	@Test
	public void shouldMoveToSouth() {
		Rover rover = new Rover();
		Location location = new Location(2, 2);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		Location initialLocation = new Location(0, 2);
		
		rover.insertOn(plateau, initialLocation, Orientation.S);
		
		assertEquals(new Location(0, 2), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);		
		assertEquals(new Location(0, 1), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);		
		assertEquals(new Location(0, 0), rover.getCurrentLocation());
	}
	
	@Test
	public void shouldMoveToWest() {
		Rover rover = new Rover();
		Location location = new Location(2, 2);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		Location initialLocation = new Location(2, 0);
		
		rover.insertOn(plateau, initialLocation, Orientation.W);
		
		assertEquals(new Location(2, 0), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);		
		assertEquals(new Location(1, 0), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);		
		assertEquals(new Location(0, 0), rover.getCurrentLocation());
	}
	
	@Test
	public void shouldMoveToEast() {
		Rover rover = new Rover();
		Location location = new Location(2, 2);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		Location initialLocation = new Location(0, 0);
		
		rover.insertOn(plateau, initialLocation, Orientation.E);
		
		assertEquals(new Location(0, 0), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);		
		assertEquals(new Location(1, 0), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);		
		assertEquals(new Location(2, 0), rover.getCurrentLocation());
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldNotMoveOutOfPlateau() {
		Rover rover = new Rover();
		Location location = new Location(2, 2);
		Plateau plateau = Plateau.fromUpperRightCoordinate(location);
		
		rover.insertOn(plateau, location, Orientation.N);
		
		assertEquals(new Location(2, 2), rover.getCurrentLocation());
		
		rover.processInstruction(NavigationInstruction.M);
	}
}
