package com.controller;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	
private static   SessionFactory sessionFactory ;

static {
	try {
		System.out.print("Initializing connection");
	
		StandardServiceRegistry standardRegistry  = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		
		sessionFactory =metaData.getSessionFactoryBuilder().build();
		
	}catch(Exception e) {
		e.printStackTrace();
	}

}

public static  SessionFactory getSessionFactory() {
	return sessionFactory;
}
}
