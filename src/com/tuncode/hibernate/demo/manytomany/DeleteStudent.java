package com.tuncode.hibernate.demo.manytomany;

import com.tuncode.hibernate.demo.manytomany.entity.Course;
import com.tuncode.hibernate.demo.manytomany.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/manytomany/hibernate.cfg-manytomany.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            System.out.println("The student is being deleted");

            Student student = session.get(Student.class, 8);

            session.delete(student);

            System.out.println("The student deleted");

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
