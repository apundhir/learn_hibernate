package org.mylearnings.hibernate;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * HQL: Pagination
 */
public class HibernateTest {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		for(int i=0; i<10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("Ajay "+i);
			session.save(user);
		}
		
		Query query = session.createQuery("from UserDetails");
		// Start point
		query.setFirstResult(2);
		// End Point
		query.setMaxResults(2);

		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) query.list();
		System.out.println(users.size());
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u:users){
			System.out.println(u.getUserName());
		}
	}
}
