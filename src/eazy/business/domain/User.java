package eazy.business.domain;

import java.util.Date;

public class User {
	
	private String name;
	private String password;
	private Integer id;
	private Integer payMethod;
	private Address address;
	private String telephone;
	private GPS coordinates;
	private ParkSpace space;
	
	public User(){
		
	}

	public void reserveSpace(ParkSpace space, Date startDate, Date endDate) {
		
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

	public ParkSpace getSpace() {
		return space;
	}

	public void setSpace(ParkSpace space) {
		this.space = space;
	}
	
}