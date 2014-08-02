package org.mylearnings.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("Ajay");
		// Till here the object is said to be in transient state, as the hibernate does not know that we need to save this.
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		// Now we are asking hibernate to save the user object so, the object is in persisted stage.
		session.save(user);
		
		// Once the object is in the persisted state, any change made will be reflected in DB,
		// There is only one update which is the last value will be reflected no matter how many times 
		user.setUserName("Ajay Updated");
		user.setUserName("Ajay Again updated");
		
		session.getTransaction().commit();
		
		session.close();
		// Once the session is closed, object becomes detached state, i.e any changes made will not be reflacted in DB.
		user.setUserName("Ajay Detached");
	}
}
