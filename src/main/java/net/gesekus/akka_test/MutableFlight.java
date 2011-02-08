package net.gesekus.akka_test;

public class MutableFlight implements Flight{
	private int id;
	private String callsign;

	public MutableFlight(int id, String callsign) {
		super();
		this.id = id;
		this.callsign = callsign;
	}

	public MutableFlight(Flight other) {
		super();
		this.id = other.getId();
		this.callsign = new String(other.getCallsign());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((callsign == null) ? 0 : callsign.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MutableFlight other = (MutableFlight) obj;
		if (callsign == null) {
			if (other.callsign != null)
				return false;
		} else if (!callsign.equals(other.callsign))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCallsign() {
		return new String(callsign);
	}

	public void setCallsign(String callsign) {
		this.callsign = new String(callsign);
	}

}
