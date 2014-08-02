package org.mylearnings.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("Ajay");
		

		Address address = new Address();
		address.setHouseNo("56");
		address.setCity("Bangalore");
		address.setStreet("HSR");
		address.setState("Karnataka");
		
		Address officeAddress = new Address();
		officeAddress.setHouseNo("56O");
		officeAddress.setCity("Bangalore_O");
		officeAddress.setStreet("HSR_O");
		officeAddress.setState("Karnataka_O");
		
		user.getAddressList().add(address);
		user.getAddressList().add(officeAddress);
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = factory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		
		System.out.println(user);
		//session.close();
		
	}

}
