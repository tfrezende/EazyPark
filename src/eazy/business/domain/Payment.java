package eazy.business.domain;

import java.util.Date;

public class Payment {

	private User user;
	private ParkSpace space;
	private Double value;
	private Date date;
	
	public boolean processPayment() {
		
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ParkSpace getSpace() {
		return space;
	}

	public void setSpace(ParkSpace space) {
		this.space = space;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
	
}