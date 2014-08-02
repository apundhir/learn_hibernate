package org.mylearnings.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("Ajay");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Swift");
		
		user.setVehicle(vehicle);
				
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
		/*user = null;
		session = factory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		
		System.out.println(user);*/
		//session.close();
		
	}

}
