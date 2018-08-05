package com.sthirty.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Mayank
 * This class provides open and close session methods
 * that will be used in the entire application
 */
public class HibernateUtilityManager {
	private HibernateUtilityManager(){}
	private static final SessionFactory sessionfactory;
	static{
		try{
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
					applySettings(configuration.getProperties());
			sessionfactory = configuration.buildSessionFactory(builder.build());
		}
		catch(Exception e){
			System.out.checkError();
			throw new ExceptionInInitializerError(e);			
			}
		}
	/**
	 * This method is returning a SessionFactory object 
	 * that we will use to get session
	 * @return
	 */
	public static SessionFactory getSessionFactory(){
		return sessionfactory;
	}
	
	/**
	 * this method is returning a Session object with open session
	 * @return
	 */
	public static Session getSession(){ // 
		return sessionfactory.openSession();
	}
	
	/**
	 * This method provides close session method
	 * that will be called by DAO class to close the 
	 * opened session.
	 */
	public static void closeSession(){
		sessionfactory.openSession().close();
	}	
}
