package com.shevtsod;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Daniel Shevtsov
 */
public class StationB extends WeatherListener {
	
	private WeatherController wController;

	/**
	 * Constructor for StationB
	 * @param wController The WeatherController to bind to this object
	 */
	public StationB(WeatherController wController) {
		this.wController = wController;
		
		//Window Frame
		frame.setSize(400, 400);
		frame.setResizable(true);
		frame.setLocation(700, 600);
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Weather Station B");

        //Button to register this station to its controller
        JButton btn1 = new JButton("Listen to Controller");
        frame.add(BorderLayout.CENTER, btn1);
		
		frame.setVisible(true);



		//EVENT LISTENERS:
		//Using Java 8 lambda syntax for action listeners

        //When listen to controller button is pressed, add this station as a listener and replace the
        //button with the weatherPanel that will be changed by the controller
        btn1.addActionListener(e -> {
            wController.addWeatherListener(this);
            frame.remove(btn1);
            wController.updateListeners();
            updateFrame();
        });
	}
}
