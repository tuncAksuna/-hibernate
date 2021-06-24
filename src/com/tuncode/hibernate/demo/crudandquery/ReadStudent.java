package com.tuncode.hibernate.demo.crudandquery;

import com.tuncode.hibernate.demo.crudandquery.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/crudandquery/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            Student myStudent = new Student();
            session = factory.getCurrentSession();
            session.beginTransaction();

            // READING STUDENT WITH PRIMARY KEY :
            System.out.println("\nGetting student from the Database");

            int theId = 4;
            Student incomingStudent = session.get(Student.class, theId);
            System.out.println("\nGet complete : " + incomingStudent);

            /*******************************************************************************************/

            // READING ALL STUDENTS WITH HQL
            List allStudents = session.createQuery("from Student").getResultList();

            System.out.println("All Student by HQL : " + allStudents);


            // with query :
            System.out.println("\nSpesific ID with Hibernate : " + session.createQuery("from Student where id=15").getResultList());

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
