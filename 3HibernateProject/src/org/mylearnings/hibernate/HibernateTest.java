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
		user.setAddress("HSR");
		user.setJoiningDate(new Date());
		user.setDescription("new description");

		UserDetails user2 = new UserDetails();
		user2.setUserName("Ajay2");
		user2.setAddress("HSR2");
		user2.setJoiningDate(new Date());
		user2.setDescription("new description 2");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = factory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		
		System.out.println(user);
		
	}

}
