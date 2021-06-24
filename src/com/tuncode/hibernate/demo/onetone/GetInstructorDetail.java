package com.tuncode.hibernate.demo.onetone;

import com.tuncode.hibernate.demo.onetone.entity.Instructor;
import com.tuncode.hibernate.demo.onetone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetail {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/onetone/hibernate.cfg-onetoone.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            int theId = 2;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class,theId);
            System.out.println("Instructor detail : " + instructorDetail);

            System.out.println("\nAssociated instructor that has 2 id : " + instructorDetail.getInstructor());

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }

    }
}
