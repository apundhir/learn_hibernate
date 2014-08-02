package org.mylearnings.hibernate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
 * We can use Table annotation to assign the new name to the table.
 * The difference between what we do with Entity and table name is, while using Entity
 * we are assigning new name to entity itself, while with Table annotaion we are giving
 * name to the table only
 */
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	private int userId;
	
	/*
	 * To make a field non persistent, there are 3 options:
	 * 1. make the field transient, static or use @Transient 
	 */
	@Transient
	private String userName;
	
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	private String address;
	
	/*
	 * By default hibernate make all string as default varchar(256)
	 * To support for large size use @Lob annotaion, to make hibernate select largest available datatype like Blob..
	 */
	
	@Lob
	private String description;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
