package org.mylearnings.hibernate;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	private String stearingWheel;

	public String getStearingWheel() {
		return stearingWheel;
	}

	public void setStearingWheel(String stearingWheel) {
		this.stearingWheel = stearingWheel;
	}
}
