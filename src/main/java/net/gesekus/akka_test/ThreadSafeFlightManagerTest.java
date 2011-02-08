package net.gesekus.akka_test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ThreadSafeFlightManagerTest extends TestCase {
	
	public void testIt() {
		FlightManager fm = new ThreadSafeFlightManager();
		MutableFlight f = new MutableFlight(1,"Test");
		
		fm.add(f);
		f.setCallsign("Changed");
		Flight g = fm.get(1);
		
		//Assert that a copy was added
		Assert.assertFalse(g.getCallsign() == f.getCallsign());
	
		MutableFlight mg = new MutableFlight(g);
		mg.setCallsign("Muhah");
			
		Flight h = fm.get(1);
		
		//Assert that we return a copy
		Assert.assertFalse(h.getCallsign() == h.getCallsign());
	
		
	}

}
