package com.shevtsod;

/**
 * @author Daniel Shevtsov
 */
public class Client3 {

	/**
	 * Main program entry point
	 * @param args String arguments from console (unused)
	 */
	public static void main(String[] args) {
		//Create the three windows of the program:
        //Controller window
		WeatherController wController = new WeatherController();
		//Two listener windows
		StationA sA = new StationA(wController);
		StationB sB = new StationB(wController);
	}

}
