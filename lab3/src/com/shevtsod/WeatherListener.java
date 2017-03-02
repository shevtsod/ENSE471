package com.shevtsod;

import javax.swing.*;
import java.awt.*;

/**
 * @author Daniel Shevtsov
 */
public abstract class WeatherListener implements WeatherEvent {

	protected int temperature;
	protected JPanel weatherPanel;
	protected JFrame frame;
	protected JLabel temperatureLabel;
	
	/**
	 * Constructor for WeatherListener concrete classes
	 */
	public WeatherListener() {
        frame = new JFrame();

		weatherPanel = new JPanel();

        temperature = 0;
		temperatureLabel = new JLabel();
		temperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(BorderLayout.CENTER, weatherPanel);
        frame.add(BorderLayout.SOUTH, temperatureLabel);
        temperatureLabel.setText("Temperature: Unknown");
        temperatureLabel.setFont(new Font("Arial", Font.BOLD, 18));
	}


	@Override
	public void setTemperature(int temperature) {
		this.temperature = temperature;
		temperatureLabel.setText("Temperature: " + Integer.toString(temperature) + " °C");
	}

	@Override
	public void setWeatherPanel(JPanel weatherPanel) {
	    frame.remove(this.weatherPanel);
		this.weatherPanel = weatherPanel;
        frame.add(BorderLayout.CENTER, weatherPanel);
	}

    /**
     * Allows other classes to update the frame when inner panels are changed
     */
    public void updateFrame() {
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
}
