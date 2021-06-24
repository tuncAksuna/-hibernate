package com.tuncode.hibernate.demo.onetone;

import com.tuncode.hibernate.demo.onetone.entity.Instructor;
import com.tuncode.hibernate.demo.onetone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/onetone/hibernate.cfg-onetoone.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Cem Tunc", "AKSUNA", "aksuna.tunc@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/tuncAksuna", "playing baglama");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
