package com.shevtsod;

import javax.swing.JPanel;

/**
 * @author Daniel Shevtsov
 */
public interface WeatherEvent {
	/**
	 * Handles event in which a new temperature has been set for a listener
	 * @param temperature The new int temperature
	 */
	public void setTemperature(int temperature);

	/**
	 * Handles event in which a new GUI panel have been set for a listener
	 * @param weatherPanel The new GUI panel
	 */
	public void setWeatherPanel(JPanel weatherPanel);
}
