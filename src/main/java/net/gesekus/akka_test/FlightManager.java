package net.gesekus.akka_test;

public interface FlightManager {
	
	/**
	 * Adds a flight to the manager
	 * @param flight the flight to add
	 */
	public void add(Flight flight);
	
	
	/**
	 * Gets a flight identified by its id
	 * @param flightId the id to identify the flight
	 * @return the flight
	 */
	public Flight get(int flightId);
}
