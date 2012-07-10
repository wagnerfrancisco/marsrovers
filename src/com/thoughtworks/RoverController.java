package com.thoughtworks;

public class RoverController {

	private StringBuilder output;

	public RoverController(String input) {
		output = new StringBuilder();
		InputProcessor processor = new InputProcessor(input);

		Plateau plateau = processor.createPlateau();
		RoverInfo[] infos = processor.getRoversInfo();
		
		for (RoverInfo roverInfo : infos) {
			Rover rover = new Rover();
			rover.insertOn(plateau, roverInfo.getInitialLocation(), roverInfo.getOrientation());
			
			for (NavigationInstruction instruction : roverInfo.getInstructions()) {
				rover.processInstruction(instruction);
			}
			
			if (!"".equals(output.toString())) {
				output.append("\n");	
			}
			output.append(rover.getCurrentLocation().getX() + " " + rover.getCurrentLocation().getY() + " " + rover.getCurrentOrientation());			
		}
	}
	
	public String getOutput() {
		return output.toString();
	}
}
