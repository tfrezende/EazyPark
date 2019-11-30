package eazy.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import eazy.business.domain.*;

public class ParkData {
	
	private Map<Integer, ParkMap> parkingLots;
	private Map<Integer, User> users;
	private final Log log;
	private static final int MAX_ID = 200;
	
	public ParkData() {
		this(true, null);
	}
	
	public ParkData(boolean initData, Map<Integer, User> users) {
		this.log = LogFactory.getLog(getClass());
		this.parkingLots = new HashMap<Integer, ParkMap>();
		this.users = users;
		if(initData) {
			initData();
		}
	}

	public Map<Integer, ParkMap> getParkingLots() {
		return parkingLots;
	}

	private void initData() {
		try {
			buildLots();
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
	}
	
	private void buildLots() throws ParseException {		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		
		Random r = new Random();
		
		ParkMap lot1 = new ParkMap("Unsafe Park", r.nextInt(MAX_ID),
				new Address("Rua 15", "374", "90620-002"));
		
		ParkMap lot2 = new ParkMap("Escapar", r.nextInt(MAX_ID),
				new Address("Rua 27", "571", "90730-001"));
		
		ParkMap lot3 = new ParkMap("Slow Car", r.nextInt(MAX_ID),
				new Address("Rua 3", "85", "90330-001"));
		
		List<ParkSpace> spaces1 = new ArrayList<ParkSpace>();
		List<ParkSpace> spaces2 = new ArrayList<ParkSpace>();
		List<ParkSpace> spaces3 = new ArrayList<ParkSpace>();
		
		for(int i = 0; i < 20; i++) {
			spaces1.add(i, new ParkSpace(lot1, i));
			spaces2.add(i, new ParkSpace(lot2, i));
			spaces3.add(i, new ParkSpace(lot3, i));
		}
		
		// First lot
		spaces1.get(3).setHoursOccupied(3.0);
		spaces1.get(3).status = true;	
		spaces1.get(3).setUser(users.get(1));
		
		spaces1.get(17).setHoursOccupied(2.5);
		spaces1.get(17).status = true;
		spaces1.get(17).setUser(users.get(5));
		
		spaces1.get(11).setHoursOccupied(0.5);
		spaces1.get(11).status = true;
		spaces1.get(11).setUser(users.get(3));
		
		List<Reservation> reservations1 = new ArrayList<Reservation>();
		reservations1.add(new Reservation(0, 
				dateFormat.parse("05-12-2019"), 
				dateFormat.parse("07-12-2019"), 
				users.get(4), spaces1.get(4)));
		reservations1.add(new Reservation(1, 
				dateFormat.parse("09-12-2019"), 
				dateFormat.parse("13-12-2019"), 
				users.get(8), spaces1.get(4)));		
		spaces1.get(4).setReservations(reservations1);
		
		// Second lot
		spaces2.get(1).setHoursOccupied(1.0);
		spaces2.get(1).status = true;
		spaces2.get(1).setUser(users.get(8));
		
		spaces2.get(6).setHoursOccupied(8.0);
		spaces2.get(6).status = true;
		spaces2.get(6).setUser(users.get(6));
		
		spaces2.get(19).setHoursOccupied(3.5);
		spaces2.get(19).status = true;
		spaces2.get(19).setUser(users.get(4));
		
		List<Reservation> reservations2 = new ArrayList<Reservation>();
		reservations2.add(new Reservation(0, 
				dateFormat.parse("05-12-2019"), 
				dateFormat.parse("07-12-2019"), 
				users.get(9), spaces2.get(5)));
		reservations2.add(new Reservation(1, 
				dateFormat.parse("09-12-2019"), 
				dateFormat.parse("13-12-2019"), 
				users.get(2), spaces2.get(5)));		
		spaces2.get(5).setReservations(reservations2);
		
		// Third lot
		spaces3.get(0).setHoursOccupied(7.0);
		spaces3.get(0).status = true;
		spaces3.get(0).setUser(users.get(9));
		
		spaces3.get(1).setHoursOccupied(6.5);
		spaces3.get(1).status = true;
		spaces3.get(1).setUser(users.get(2));
		
		spaces3.get(7).setHoursOccupied(1.5);
		spaces3.get(7).status = true;
		spaces3.get(7).setUser(users.get(10));
		
		
		List<Reservation> reservations3 = new ArrayList<Reservation>();
		reservations3.add(new Reservation(0, 
				dateFormat.parse("10-12-2019"), 
				dateFormat.parse("12-12-2019"), 
				users.get(6), spaces3.get(15)));
		reservations3.add(new Reservation(1, 
				dateFormat.parse("15-12-2019"), 
				dateFormat.parse("17-12-2019"), 
				users.get(5), spaces3.get(15)));		
		spaces3.get(15).setReservations(reservations3);
		
		parkingLots.put(1, lot1);
		parkingLots.put(2, lot2);
		parkingLots.put(3, lot3);		
	}
}
