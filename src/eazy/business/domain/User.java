package eazy.business.domain;

import java.util.Date;
import java.util.Random;

public class User {
	
	private String name;
	private String password;
	private Integer id;
	private Integer payMethod;
	private Address address;
	private String telephone;
	private GPS coordinates;
	private Reservation reservation;
	
	public User(String name, String password, Integer id, Integer payMethod, 
			Address address, String telephone) {
		this.name = name;
		this.password = password;
		this.id = id;
		this.payMethod = payMethod;
		this.address = address;
		this.telephone = telephone;
	}

	public void reserveSpace(ParkSpace space, Date startDate, Date endDate) {
		if (!space.hasReservation(startDate, endDate)) {
			Random r = new Random();
			Integer identifier = r.nextInt();
			
			this.reservation = new Reservation(
					identifier, startDate, endDate, this, space);
			
			space.getReservations().add(this.reservation);
		}
	}
	
	public void changePayMethod(Integer newMethod) {
		this.payMethod = newMethod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public GPS getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(GPS coordinates) {
		this.coordinates = coordinates;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	
	
}