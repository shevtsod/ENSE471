package com.shevtsod;

import java.awt.*;

import javax.swing.*;

/**
 * @author Daniel Shevtsov
 */
public class StationA extends WeatherListener {
	
	private WeatherController wController;

	/**
	 * Constructor for StationA
	 * @param wController The WeatherController to bind to this object
	 */
	public StationA(WeatherController wController) {
		this.wController = wController;
		
		//Window Frame
		frame.setSize(400, 400);
		frame.setResizable(true);
		frame.setLocation(700, 200);
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Weather Station A");
		
		frame.setVisible(true);

		//Automatically add this station as a listener of the controller
        wController.addWeatherListener(this);
	}
}
