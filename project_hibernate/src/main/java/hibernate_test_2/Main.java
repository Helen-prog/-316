package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();
//
//        Session session = factory.getCurrentSession();
//        Employee employee = new Employee("Роман", "Соколов", "IT", 500);
//        Detail detail = new Detail("Москва", "+7 999 123 45 67", "roman@gmail.com");
//
//        employee.setEmployeeDetail(detail);
//        session.beginTransaction();
//
//        session.persist(employee);
//
//        session.getTransaction().commit();
//
//        factory.close();


//        Session session = factory.getCurrentSession();
//        Employee employee = new Employee("Игорь", "Тигров", "Sales", 700);
//        Detail detail = new Detail("Воронеж", "+7 555 123 45 67", "igor@gmail.com");
//
//        employee.setEmployeeDetail(detail);
//        session.beginTransaction();
//
//        session.persist(employee);
//
//        session.getTransaction().commit();
//
//        factory.close();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 2);
//            System.out.println(emp.getEmployeeDetail());
//
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.remove(emp);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }
}
