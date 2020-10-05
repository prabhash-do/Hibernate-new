package com.hibernate.demo;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.Instructor_Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Instructor_Detail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {

            Instructor instructor = new Instructor("sjsnns","njksks","wrt@11.cc");

            Instructor_Detail detail = new Instructor_Detail("njik","cricket");

            instructor.setInstructorDetail(detail);

            session.beginTransaction();

            //This will also save the instructor object of the use of cascadetype.all
            session.save(instructor);


            session.getTransaction().commit();
        }
        finally {

            sessionFactory.close();
        }
    }
}
