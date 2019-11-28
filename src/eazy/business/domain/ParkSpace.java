package eazy.business.domain;

import java.util.Date;
import java.util.List;

public class ParkSpace {

	private ParkMap parkingLot;
	public static boolean status;
	private User user;
	private Integer id;
	private Integer elapsedTime;
	private List<Reservation> reservations;
	private static final Double HOURLY_RATE = 5.0;
		
	public ParkSpace(ParkMap parkingLot, User user, Integer id, 
			Integer elapsedTime, List<Reservation> reservations) {
		super();
		this.parkingLot = parkingLot;
		this.user = user;
		this.id = id;
		this.elapsedTime = elapsedTime;
		this.reservations = reservations;
	}

	public boolean hasReservation(Date startDate, Date endDate) {
		
		for (Reservation reservation : reservations) {
			if (
				(startDate.after(reservation.getStartDate()) && 
				startDate.before(reservation.getEndDate())) 
				||
				(endDate.after(reservation.getStartDate()) && 
				endDate.before(reservation.getEndDate()))
				) {				
				
				return true;
			}
		}
		return false;
	}
	
	public boolean isAvailable() {		
		return !status;
	}

	public Double calculateCost() {
		return ((elapsedTime * HOURLY_RATE)/60.0);
	}

	public static boolean getStatus() {
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

	public ParkMap getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkMap parkingLot) {
		this.parkingLot = parkingLot;
	}
	
}