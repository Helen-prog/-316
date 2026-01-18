package hibernate_one_to_many;

import hibernate_one_to_many.entity.Department;
import hibernate_one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();

        Session session = null;

        try{
//            session = factory.getCurrentSession();
//            Department department = new Department("IT", 1500, 120);
//            Employee emp1 = new Employee("Виктор", "Романов", 800);
//            Employee emp2 = new Employee("Ирина", "Комина", 1000);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.persist(department);
//            session.getTransaction().commit();


//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmployees());
//            session.getTransaction().commit();


//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 4);
            session.remove(employee);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
