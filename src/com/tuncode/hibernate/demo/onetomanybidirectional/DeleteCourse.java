package com.tuncode.hibernate.demo.onetomanybidirectional;

import com.tuncode.hibernate.demo.onetomanybidirectional.entity.InstructorDetail;
import com.tuncode.hibernate.demo.onetomanybidirectional.entity.Course;
import com.tuncode.hibernate.demo.onetomanybidirectional.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCourse {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/onetomanybidirectional/hibernate.cfg-onetomany.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // we cannot delete a course, because of CASCADE TYPE ..
            session.beginTransaction();

            Course course = session.get(Course.class, 15);
            session.delete(course);

            // ALL COURSES
            List courses = session.createQuery("from Course").getResultList();
            System.out.println("All courses : " + courses);

            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
