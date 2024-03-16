package in.ineuron.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static Configuration cfg = null;
	static Transaction transaction = null;
	static SessionFactory sessionFactory = null;
	static Session session = null;
	
	static {
	try {
		cfg =new Configuration();
		cfg.configure();
		System.out.println("generated properties "+ cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory();
	} catch (HibernateException e) {
		e.printStackTrace();
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	}
	public static Session getSession() {
		if(session==null) 
			session = sessionFactory.openSession();
		return session;
	}
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	
    
}

