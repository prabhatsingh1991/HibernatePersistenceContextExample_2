package com.infotech.client;

import org.hibernate.Session;

import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class DeleteEntityClientTest {

	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			long personId = 1L;
			
			Person person = session.get(Person.class, personId);
			if(person != null){
				session.beginTransaction();
				session.delete(person);
				session.getTransaction().commit();
			}else{
				System.out.println("Person Doesn't Exist..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
