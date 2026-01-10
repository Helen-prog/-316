package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
//        Employee employee = new Employee("Сергей", "Бирюков", "IT", 500);
//        Employee employee = new Employee("Виктор", "Сазонов", "HR", 750);
//        Employee employee = new Employee("Игорь", "Винник", "Sales", 700);
        Employee employee = new Employee("Игорь", "Сазонов", "IT", 600);
        session.beginTransaction();
        session.persist(employee);  // save()

        System.out.println(employee);
        session.getTransaction().commit();

        factory.close();
    }
}
