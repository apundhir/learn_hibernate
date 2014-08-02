package org.mylearnings.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		// Insert
		for(int i=0; i<10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("USER "+i);
			session.save(user);
		}
		// Select
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		System.out.println(user.getUserName());
		
		//Update
		user.setUserName("Updated User Name");
		session.update(user);
		
		// Delete
		//session.delete(user);
		
		
		
		
		session.getTransaction().commit();
		session.close();
	}
}
