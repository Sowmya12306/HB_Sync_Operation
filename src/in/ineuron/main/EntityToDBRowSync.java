package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class EntityToDBRowSync {

	public static void main(String[] args) {
          Session session = null;
          Transaction transaction = null;
          boolean flag = false;
          Integer id = 5;
          
          try {
			session = HibernateUtil.getSession();
			  if(session!=null) {
				  transaction = session.beginTransaction();
			  }
			  if(transaction!=null) {
				 Employee employee = session.get(Employee.class, id);
				 if(employee!=null) {
					 employee.setEmpSal(12980.9);
					 flag=true;
				 }
				 else {
					 System.err.println("record not found... ");
					 System.exit(0);
				 }
			  }
		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}
			else
				transaction.rollback();
		}
	}

}
