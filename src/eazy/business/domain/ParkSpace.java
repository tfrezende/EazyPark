package eazy.business.domain;

import java.util.Date;
import java.util.List;

public class ParkSpace {

	public static boolean status;
	private User user;
	private Integer id;
	private Integer elapsedTime;
	private List<Reservation> reservations;
	private static final Double HOURLY_RATE = 5.0;
	
	public ParkSpace() {
		
	}
	
	public boolean hasReservation(Date startDate, Date endDate) {
		return true;
	}
	
	public boolean isAvailable() {
		if (status == true) {
			return false;
		}
		
		return true;
	}

	public Double calculateCost() {
		return ((elapsedTime * HOURLY_RATE)/60.0);
	}

	public static boolean isStatus() {
		return status;
	}

	public static void setStatus(boolean status) {
		ParkSpace.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Integer elapsedTime) {		
		this.elapsedTime = elapsedTime;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public static Double getHourlyRate() {
		return HOURLY_RATE;
	}
	
}