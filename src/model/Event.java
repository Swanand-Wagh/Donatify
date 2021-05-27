package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
	private Integer id;
	private String name; // name of event
	private String category;
	private String address;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String NGO; // name of NGO
	
	public String getNGO() {
		return NGO;
	}

	public void setNGO(String nGO) {
		NGO = nGO;
	}

	public Event () {}

	public Event(String name, String category, String address, LocalDate startDate, LocalDate endDate,
			LocalTime startTime, LocalTime endTime) {
		super();
		this.name = name;
		this.category = category;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Event(String name, String category, String address, LocalDate startDate, LocalDate endDate,
			LocalTime startTime, LocalTime endTime, String nGO) {
		super();
		this.name = name;
		this.category = category;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.NGO = nGO;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Event(Integer id, String name, String category, String address, LocalDate startDate, LocalDate endDate,
			LocalTime startTime, LocalTime endTime, String nGO) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		NGO = nGO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", category=" + category + ", address=" + address + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}
