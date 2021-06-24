package com.tuncode.hibernate.demo.crudandquery;

import com.tuncode.hibernate.demo.crudandquery.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Query {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/crudandquery/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            // FOR ALL STUDENTS
            System.out.println("ALL STUDENTS FROM DATABASE");
            List<Student> theAllStudents = session.createQuery("from Student").getResultList();

            displayStudents(theAllStudents);

            // FOR SPESICIF STUDENT
            System.out.println("\nSPESIFIC STUDENT FROM DATABASE");

            // WHERE firstName and lastName
            List<Student> firstNameLastName = session.createQuery("from Student s where s.firstName='Tunç' OR s.lastName ='Doe'").getResultList();

            // WHERE email LIKE
            List<Student> whereEmailLike = session.createQuery("from Student s where s.email LIKE '@gmail.com'").getResultList();

            displayStudents(firstNameLastName);
            System.out.println("******************************");
            displayStudents(whereEmailLike);

            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student el : students) {
            System.out.println(el);
        }
    }

}
