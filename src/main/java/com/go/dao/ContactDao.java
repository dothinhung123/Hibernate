package com.go.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.go.config.JdbcConnection;
import com.go.model.Contact;

public class ContactDao {
	 

	 SessionFactory sessionFactory  = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Contact.class).buildSessionFactory();
		
		public void add(Contact contact) {
		Session session = sessionFactory.openSession();
	   session.beginTransaction();
	   session.save(contact);
	   session.getTransaction().commit();
	   session.close();
	}
	public List<Contact> getAllContacts(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Contact> contacts = (List<Contact>) session.createQuery("from Contact").getResultList().stream().sorted(Comparator.comparing(Contact::getId)).collect(Collectors.toList());
        session.getTransaction().commit();
        session.close();
		return contacts;
		
		
	}
	public Contact getById(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Contact contact = session.get(Contact.class, id);
		session.getTransaction().commit();
		session.close();
		return contact;
	}
	public void update(Contact contact) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(contact);
		session.getTransaction().commit();
		session.close();


		}
	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Contact contact = getById(id);
		session.delete(contact);
		session.getTransaction().commit();
		session.close();
	}

}
