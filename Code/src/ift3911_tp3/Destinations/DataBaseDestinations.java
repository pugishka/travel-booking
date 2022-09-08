package ift3911_tp3.Destinations;

import java.util.ArrayList;
import java.util.List;

public class DataBaseDestinations {

	private static List<Destination> aeroports;
	private static List<Destination> ports;
	private static List<Destination> gares;
	private static DataBaseDestinations instance;
	
	private DataBaseDestinations() {
		aeroports = new ArrayList<Destination>();
		ports = new ArrayList<Destination>();
		gares = new ArrayList<Destination>();
	};
	
	public static DataBaseDestinations getInstance() {
		if (instance == null) {
			instance = new DataBaseDestinations();
		}
		return instance;
	}

	public boolean newAeroport(String id, String ville) {
		for(Destination u : aeroports) {
			if(u.getId() == id) {
				return false;
			}
		}
		DestinationCreator c = AeroportCreator.getInstance();
		Destination u = c.render(id, ville);
		aeroports.add(u);
		return true;
	}

	public boolean newPort(String id, String ville) {
		for(Destination u : ports) {
			if(u.getId() == id) {
				return false;
			}
		}
		DestinationCreator c = PortCreator.getInstance();
		Destination u = c.render(id, ville);
		ports.add(u);
		return true;
	}

	public boolean newGare(String id, String ville) {
		for(Destination u : gares) {
			if(u.getId() == id) {
				return false;
			}
		}
		DestinationCreator c = GareCreator.getInstance();
		Destination u = c.render(id, ville);
		gares.add(u);
		return true;
	}

	public boolean checkAeroport(String id) {
		for(Destination u : aeroports) {
			if(u.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean checkPort(String id) {
		for(Destination u : ports) {
			if(u.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean checkGare(String id) {
		for(Destination u : gares) {
			if(u.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public Destination getDestination(int type, String id) {
		if (type == 1){
			for(Destination u : aeroports) {
				if(u.getId() == id) {
					return u;
				}
			}
		}
		if (type == 2){
			for(Destination u : ports) {
				if(u.getId() == id) {
					return u;
				}
			}
		}
		if (type == 3){
			for(Destination u : gares) {
				if(u.getId() == id) {
					return u;
				}
			}
		}
		return null;
	}
	
	
}
