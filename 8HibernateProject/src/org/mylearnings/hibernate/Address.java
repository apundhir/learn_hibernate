package org.mylearnings.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "HOUSE_NO")
	private String houseNo;
	@Column(name ="STREET_NAME")
	private String street;
	@Column( name = "CITY_NAME")
	private String city;
	@Column(name = "STATE_NAME")
	private String state;
	
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", street=" + street + ", city="
				+ city + ", state=" + state + "]";
	}
	
	
}
