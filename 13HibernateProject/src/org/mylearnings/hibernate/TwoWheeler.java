package org.mylearnings.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="BIKE")
public class TwoWheeler extends Vehicle {
	private String stearingHandle;

	public String getStearingHandle() {
		return stearingHandle;
	}

	public void setStearingHandle(String stearingHandle) {
		this.stearingHandle = stearingHandle;
	}
}
