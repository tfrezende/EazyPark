package eazy.business.domain;

import java.util.Date;
import java.util.List;

public class ParkSpace {

	private ParkMap parkingLot;
	public boolean status; // Public b/c it depends on external signal (sensor)
	private User user;
	private Integer id;
	public Double hoursOccupied; // Public b/c counter is located on external sensor
	private List<Reservation> reservations;
	private static final Double HOURLY_RATE = 5.0;
		
	public ParkSpace(ParkMap parkingLot, Integer id) {
		super();
		this.parkingLot = parkingLot;
		this.id = id;
		this.hoursOccupied = 0.0;
		this.reservations = null;
		this.status = false;
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
		return ((hoursOccupied * HOURLY_RATE));
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public Double getHoursOccupied() {
		return hoursOccupied;
	}

	public void setHoursOccupied(Double hoursOccupied) {		
		this.hoursOccupied = hoursOccupied;
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