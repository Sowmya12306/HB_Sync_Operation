package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class DBRowToEntitySync {

	public static void main(String[] args) {
		Session session = null;
		Employee employee = null;
		int id = 4;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				employee = session.get(Employee.class, id);
				if(employee!=null) {
				System.out.println("Employee details before updating manually in DB "+ employee);
				System.in.read();
				session.refresh(employee);  // this refresh() method is used to reflect changes inthe DB to entity, Without this method changes won't happen automatically (Synchronization using refresh())
				System.out.println("Employee details after updating record manually on DB "+employee);
				}
				else
	 				System.err.println("Record not found :(");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
