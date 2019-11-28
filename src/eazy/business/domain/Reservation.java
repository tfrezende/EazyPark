package eazy.business.domain;

import java.util.Date;

public class Reservation {

	private Integer id;
	private Date startDate;
	private Date endDate;
	private User user;
	private ParkSpace space;
	
	public Reservation() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
}