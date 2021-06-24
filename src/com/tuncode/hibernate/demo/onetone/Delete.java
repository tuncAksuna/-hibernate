package com.tuncode.hibernate.demo.onetone;

import com.tuncode.hibernate.demo.onetone.entity.Instructor;
import com.tuncode.hibernate.demo.onetone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/onetone/hibernate.cfg-onetoone.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 4;
            Instructor instructor = session.get(Instructor.class, theId);

            if (instructor != null) {

                System.out.println("Deleting: " + instructor);

                // Note: will ALSO delete associated "details" object because of CascadeType.ALL
                session.delete(instructor);
            }

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
