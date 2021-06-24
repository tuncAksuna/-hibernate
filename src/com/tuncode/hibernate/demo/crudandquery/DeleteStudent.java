package com.tuncode.hibernate.demo.crudandquery;

import com.tuncode.hibernate.demo.crudandquery.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudent {
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

            List<Student> allStudents = session.createQuery("from Student").getResultList();
            System.out.println("ALL STUDENTS : " + allStudents);

            int theId = 7;

            // DELETE STUDENT
            System.out.println("\nDeleting Student with id : " + theId);

            Student deleteStudent = session.get(Student.class, theId);
            session.delete(deleteStudent);

            /*******************************************************************************************/

            // DELETE STUDENT HQL
            System.out.println("\nDeleting Student with id 9 by HQK: ");

            session.createQuery("delete from Student where id=9").executeUpdate();

            System.out.println("\nALL STUDENTS  : " + allStudents);

            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }
}
