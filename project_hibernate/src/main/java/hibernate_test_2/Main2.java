package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();
        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Михаил", "Сидоров", "HR", 850);
//            Detail detail = new Detail("Сочи", "+7(888)789-45-61", "misha@mail.ru");
//
//            employee.setEmployeeDetail(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction();
//
//            session.persist(employee);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Detail detail = session.get(Detail.class, 3);
//            System.out.println(detail.getEmployee());
//            session.getTransaction().commit();


//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Detail detail = session.get(Detail.class, 3);
//            session.remove(detail);
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmployeeDetail(null);
            session.remove(detail);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
