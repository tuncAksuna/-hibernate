package com.tuncode.hibernate.demo.onetomanybidirectional;

import com.tuncode.hibernate.demo.onetomanybidirectional.entity.Course;
import com.tuncode.hibernate.demo.onetomanybidirectional.entity.Instructor;
import com.tuncode.hibernate.demo.onetomanybidirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourse {
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
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class,7);

            Course spring_with_hibernate = new Course("Spring with Hibernate");
            Course hiber= new Course("HIBERNATE");

            instructor.add(spring_with_hibernate);
            instructor.add(hiber);

            session.save(spring_with_hibernate);
            session.save(hiber);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

}
