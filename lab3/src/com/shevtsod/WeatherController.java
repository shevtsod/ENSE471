package com.shevtsod;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * @author Daniel Shevtsov
 */
public class WeatherController {
	
	private List<WeatherListener> weatherListeners;
	
	private JFrame frame;
	private JPanel topPanel, bottomPanel;
	
	private JTextField tfSetTemperature;
	private JButton btnSetTemperature;
	
	private JComboBox<String> cbWeather;
	private JButton btnSetWeather;

	private String[] weathers = {"Sunny", "Rain", "Snow", "Blizzard"};

	private int currentTemperature;
	private int currentWeather;

    /**
     * Constructor for a new WeatherController objects
     */
	public WeatherController() {
	    //Initialize private data
        weatherListeners = new ArrayList<>();

		//Window Frame
		frame = new JFrame();
		frame.setSize(500, 80);
		frame.setResizable(false);
		frame.setLocation(200, 540);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Weather Controller");
		
		//Temperature controls
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));
		frame.add(BorderLayout.NORTH, topPanel);

		tfSetTemperature = new JTextField();
		topPanel.add(tfSetTemperature);

		btnSetTemperature = new JButton("Set Temperature");
		topPanel.add(btnSetTemperature);
		
		
		//Weather controls
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 2));
		frame.add(BorderLayout.SOUTH, bottomPanel);

		cbWeather = new JComboBox<>(weathers);
		cbWeather.setSelectedIndex(0);
		bottomPanel.add(cbWeather);

		btnSetWeather = new JButton("Set Weather");
		bottomPanel.add(btnSetWeather);
		
		frame.setVisible(true);



		//EVENT LISTENERS:
        //Using Java 8 lambda syntax for action listeners

        //Handle selection of different weathers in JComboBox
        cbWeather.addActionListener(e -> {

        });

        //Send new temperature to all listeners when temperature button is pressed
        btnSetTemperature.addActionListener(e -> {
            //Convert the string in tfSetTemperature into an integer before sending it to listeners
            String tfText = tfSetTemperature.getText();
            try {
                //If parse to int failed or integer is not in range, throw NumberFormatException
                int temperature = Integer.parseInt(tfText);
                if(temperature < -60 || temperature > 60) {
                    throw new NumberFormatException();
                }

                updateListenersTemperature(temperature);
            } catch(NumberFormatException ex) {
                //If the text in tfSetTemperature was not an integer, output an error to the user
                tfSetTemperature.setText("Invalid Integer!");
            }
        });

        //Send new weatherPanel to all listeners when weather button is pressed
        btnSetWeather.addActionListener(e -> {
            updateListenersWeather(cbWeather.getSelectedIndex());
        });
	}

    /**
     * Add a new WeatherListener to listen to changes in this controller
     * @param wl The WeatherListener object to add as a listener
     */
	public void addWeatherListener(WeatherListener wl) {
        weatherListeners.add(wl);
	}

    /**
     * Remove an existing WeatherListener from this controller
     * @param wl The WeatherListener object to remove from the list of listeners
     */
	public void removeWeatherListener(WeatherListener wl) {
	    //List checks whether the element exists in the list on its own
        weatherListeners.remove(wl);
	}

    /**
     * Update the temperature of all registered WeatherListeners
     * @param newTemperature The integer temperature to set
     */
	public void updateListenersTemperature(int newTemperature) {
        //Send the new temperature to all registered listeners
        for (WeatherListener wl : weatherListeners) {
            wl.setTemperature(newTemperature);
            wl.updateFrame();
        }

        //Remember the current temperature
        currentTemperature = newTemperature;
    }

    /**
     * Update the GUI weatherPanel of all registered WeatherListeners
     * @param index The index of the weather selected from String array weathers
     */
	public void updateListenersWeather(int index) {
        //Send this JPanel to all registered listeners
        for (WeatherListener wl : weatherListeners) {
            //Build a new panel with the appropriate weather color
            JPanel weatherPanel = new JPanel();
            weatherPanel.setLayout(new BorderLayout());

            JLabel weather = new JLabel();
            weather.setHorizontalAlignment(SwingConstants.CENTER);
            weather.setFont(new Font("Arial", Font.BOLD, 30));

            //Set the color of the panel and the text based on the weather
            switch (index) {
                //"sunny"
                case 0:
                    weather.setText("Sunny");
                    weatherPanel.setBackground(Color.decode("#f4d695"));
                    break;
                //"Rain"
                case 1:
                    weather.setText("Rain");
                    weatherPanel.setBackground(Color.decode("#7F63FF"));
                    break;
                //"Snow"
                case 2:
                    weather.setText("Snow");
                    weatherPanel.setBackground(Color.decode("#7496D7"));
                    break;
                //"Blizzard"
                case 3:
                    weather.setText("Blizzard");
                    weatherPanel.setBackground(Color.decode("#FFFFFF"));
                    break;
                //Keep default color
                default:
                    break;
            } // End switch
            weatherPanel.add(BorderLayout.NORTH, weather);

            wl.setWeatherPanel(weatherPanel);
            wl.updateFrame();
        } //End for

        //Remember the current weather
        currentWeather = index;

    }

    /**
     * Sends update on the state of all data to all listeners with one method for convenience
     */
    public void updateListeners() {
        updateListenersTemperature(currentTemperature);
        updateListenersWeather(currentWeather);
    }

}
