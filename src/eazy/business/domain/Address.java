package eazy.business.domain;

public class Address {
	private String street;
	private String number;
	private String apt;
	private String zip;
	private String city;
	private String state;
	private String country;

	public Address(String street, String number, String apt, String zip, String city, String state, String country) {
		super();
		this.street = street;
		this.number = number;
		this.apt = apt;
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
