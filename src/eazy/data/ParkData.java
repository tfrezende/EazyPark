package eazy.data;

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
	private final Log log;
	private static final int MAX_ID = 200;
	
	public ParkData() {
		this(true);
	}
	
	public ParkData(boolean initData) {
		this.log = LogFactory.getLog(getClass());
		this.parkingLots = new HashMap<Integer, ParkMap>();
		if(initData) {
			initData();
		}
	}

	public Map<Integer, ParkMap> getParkingLots() {
		return parkingLots;
	}

	public void initData() {
		try {
			buildLots();
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
	}
	
	private void buildLots() {		
		
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
		// missing set user now
		spaces1.get(17).setHoursOccupied(2.5);
		spaces1.get(17).status = true;
		
		spaces1.get(8).setHoursOccupied(4.0);
		spaces1.get(8).status = true;
		
		spaces1.get(11).setHoursOccupied(0.5);
		spaces1.get(11).status = true;
		
		// Second lot
		spaces2.get(1).setHoursOccupied(1.0);
		spaces2.get(1).status = true;
		
		spaces2.get(5).setHoursOccupied(8.0);
		spaces2.get(5).status = true;
		
		spaces2.get(18).setHoursOccupied(4.5);
		spaces2.get(18).status = true;
		
		spaces2.get(19).setHoursOccupied(3.5);
		spaces2.get(19).status = true;
		
		// Third lot
		spaces3.get(0).setHoursOccupied(7.0);
		spaces3.get(0).status = true;
		
		spaces3.get(1).setHoursOccupied(6.5);
		spaces3.get(1).status = true;
		
		spaces3.get(5).setHoursOccupied(4.0);
		spaces3.get(5).status = true;
		
		spaces3.get(7).setHoursOccupied(1.5);
		spaces3.get(7).status = true;
		
	}
}
