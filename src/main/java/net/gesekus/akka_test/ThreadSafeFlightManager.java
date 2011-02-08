package net.gesekus.akka_test;

import akka.stm.*;


/**
 * A threadsafe version of the {@link FlightManager} implemented with akka-stm
 * @author gesekus
 *
 */
public class ThreadSafeFlightManager implements FlightManager {

	final TransactionalMap<Integer, Flight> flights = new TransactionalMap<Integer, Flight>();

	
	public void add(final Flight flight) {
		new Atomic() {
		    public Object atomically() {
		        flights.put(flight.getId(),new MutableFlight(flight));
		        return null;
		    }
		}.execute();
		
	}

	public Flight get(final int flightId) {
		return new Atomic<Flight>() {
		    public Flight atomically() {
		        return flights.get(flightId).get();
		    }
		}.execute();
	}

}
