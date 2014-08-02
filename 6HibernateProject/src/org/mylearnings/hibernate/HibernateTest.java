package org.mylearnings.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Ajay");
		
		
		Address myAddress = new Address();
		myAddress.setCity("Bangalore");
		myAddress.setStreet("HSR");
		myAddress.setPincode("12121212");
		myAddress.setState("Karnataka");
		
		
		Address myOfficeAddress = new Address();
		myOfficeAddress.setCity("Bangalore");
		myOfficeAddress.setStreet("Marathalli");
		myOfficeAddress.setPincode("202020");
		myOfficeAddress.setState("Karnataka");
		
		user.getListOfAddresses().add(myAddress);
		user.getListOfAddresses().add(myOfficeAddress);
		
		
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
		
		
		System.out.println(user.getUserName());
		System.out.println(user.getListOfAddresses().size());
		
		session.close();
		
	}

}
