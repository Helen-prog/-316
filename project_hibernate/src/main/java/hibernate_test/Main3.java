package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Employee> employees = session.createQuery("from Employee where name = 'Игорь' and salary > 650").list();

        for (Employee emp : employees) {
            System.out.println(emp);
        }
        session.getTransaction().commit();

        factory.close();
    }
}
