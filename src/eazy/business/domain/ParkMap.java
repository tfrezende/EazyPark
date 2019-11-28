package eazy.business.domain;

import java.util.List;

public class ParkMap {
	
	private List<ParkSpace> spaceMap;
	private String name;
	private Integer id;
	private Address address;
	
	public ParkMap(List<ParkSpace> spaceMap, String name, Integer id, Address address) {
		super();
		this.spaceMap = spaceMap;
		this.name = name;
		this.id = id;
		this.address = address;
	}

	public List<ParkSpace> getSpaceMap() {
		return spaceMap;
	}

	public void setSpaceMap(List<ParkSpace> spaceMap) {
		this.spaceMap = spaceMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}