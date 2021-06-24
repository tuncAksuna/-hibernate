package com.tuncode.hibernate.demo.onetone;

import com.tuncode.hibernate.demo.onetone.entity.Instructor;
import com.tuncode.hibernate.demo.onetone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/onetone/hibernate.cfg-onetoone.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 6;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("Instructor Detail : " + instructorDetail);

            System.out.println("\nAssociated instructor that has id 6 : " + instructorDetail.getInstructor());

            // DELETE INSTRUCTOR DETAIL ( Cascade type = PERSIST,MERGE,DETECH,REFRESH )
            // PROGRAM THROW AN ERROR BECAUSE OF "CASCADE TYPE"
            System.out.println("\nDeleting Instructor Detail that has id 6 ,If Cascade Type is ALL: ");
            session.delete(instructorDetail);

            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            session.close();
            factory.close();
        }
    }
}
