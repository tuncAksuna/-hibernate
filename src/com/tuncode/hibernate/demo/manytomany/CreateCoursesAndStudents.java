package com.tuncode.hibernate.demo.manytomany;

import com.tuncode.hibernate.demo.manytomany.entity.Course;
import com.tuncode.hibernate.demo.manytomany.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudents {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("com/tuncode/hibernate/demo/manytomany/hibernate.cfg-manytomany.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Coding in HIBERNATE");
            Course course2 = new Course("Coding with tunCode");

            // save the course
            session.save(course);

            // create the students
            Student student = new Student("Cem Tunç", "AKSUNA", "aksuna.tunc@gmail.com");
            Student student2 = new Student("Selvi", "AKSUNA", "aksuna.selvi@gmail.com");
            Student student3 = new Student("Eyüp", "AKKAYA", "eyup.akkaya@gmail.com");
            Student student4 = new Student("Agit", "Oktay", "agit.oktay@gmail.com");

            // add students to the course
            course.addStudent(student);
            course.addStudent(student2);

            course2.addStudent(student3);
            course2.addStudent(student4);

            // save the students
            System.out.println("\nSaving students ...");
            session.save(student);
            session.save(student2);
            System.out.println("Saved students: " + course.getStudentList());

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
