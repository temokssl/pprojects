package main.java.Utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectDBUtil {
	  private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  public static Session getSession() {
		 return sessionFactory.openSession();
	  }
}