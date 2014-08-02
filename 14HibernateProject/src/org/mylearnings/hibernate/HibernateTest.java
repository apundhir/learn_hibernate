package org.mylearnings.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
				
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Swift");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("My Bike");
		bike.setStearingHandle("Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("My Car");
		car.setStearingWheel("Wheel");
		
				
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
	}

}
