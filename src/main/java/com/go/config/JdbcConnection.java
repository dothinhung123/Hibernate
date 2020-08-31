package com.go.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class JdbcConnection {
	   private static final SessionFactory sessionFactory = buildSessionFactory();
	   
	    private static SessionFactory buildSessionFactory() {
	//        try {
//	            // Create the SessionFactory from hibernate.cfg.xml
//	            Configuration configuration = new Configuration();
//	            configuration.addAnnotatedClass(com.go.model.Contact.class);
//	            configuration.configure("hibernate.cfg.xml");
//	        
//
//	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//	                .applySettings(configuration.getProperties()).build();
//
//	            return configuration.buildSessionFactory(serviceRegistry);
//	        } catch (Throwable ex) {
//	            System.err.println("Initial SessionFactory creation failed." + ex);
//	            throw new ExceptionInInitializerError(ex);}
	    	SessionFactory sessionFactory = null;
	    	StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	    	//sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	    //	return sessionFactory;
	    	try {
	    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	    	} catch (Exception ex) {
	    	    StandardServiceRegistryBuilder.destroy(registry);
	    	}
	    	return sessionFactory;
//	      }
	    	
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	

}
