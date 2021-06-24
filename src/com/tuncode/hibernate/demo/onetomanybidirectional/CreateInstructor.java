package com.tuncode.hibernate.demo.onetomanybidirectional;

import com.tuncode.hibernate.demo.onetomanybidirectional.entity.Course;
import com.tuncode.hibernate.demo.onetomanybidirectional.entity.Instructor;
import com.tuncode.hibernate.demo.onetomanybidirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
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
            Instructor instructor = new Instructor("Cem Tunç","Aksuna","cemtuncaksuna@tuncode.com");

            session.beginTransaction();

            System.out.println("Saving the Instructor");
            session.save(instructor);

            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
