package com.tuncode.hibernate.demo.crudandquery;

import com.tuncode.hibernate.demo.crudandquery.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/crudandquery/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            System.out.println("Updating student");

            session = factory.getCurrentSession();
            session.beginTransaction();

            int studentId = 3;
            System.out.println("Getting student that has 3 id : " + session.get(Student.class, studentId));

            Student updateStudent = session.get(Student.class, studentId);
            updateStudent.setEmail("aksuna.tunc@gmail.com");

            System.out.println("Updated student : " + updateStudent);

            session.getTransaction().commit();

            /*******************************************************************************************/

            // WITH HQL

            System.out.println("Updating ALL students email BY HQL -> ");

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='updatedHQL@hql.com'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
