package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.Instructor_Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Instructor_Detail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Integer id = 1;

            Instructor instructor = session.get(Instructor.class,id);

            Course course1 = new Course("Send");
            Course course2 = new Course("Receive");

            instructor.add(course1);
            instructor.add(course2);

            //This will also save the instructor object of the use of cascadetype.all
            session.save(course1);
            session.save(course2);


            session.getTransaction().commit();
        }
        finally {

            sessionFactory.close();
        }
    }
}
