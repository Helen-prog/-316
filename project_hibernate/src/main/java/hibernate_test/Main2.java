package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
//        Employee employee = new Employee("Ирина", "Федорова", "Sales", 800);
        Employee employee = new Employee("Виктория", "Николаенко", "HR", 700);
        session.beginTransaction();
        session.persist(employee);  // save()

//        System.out.println(employee);
//        session.getTransaction().commit();

        int myId = employee.getId();
//        session = factory.getCurrentSession();
//        session.beginTransaction();
        Employee employee2 = session.get(Employee.class, myId);  // get == SELECT
        session.getTransaction().commit();
        System.out.println(employee2);

        factory.close();
    }
}
