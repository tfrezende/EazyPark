package eazy.data;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import eazy.business.domain.*;

public class ParkData {
	
	private Map<Integer, ParkMap> parkingLots;
	private final Log log;
	
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
			
			//parkingLots.put(1, new ParkMap());
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
	}
}
