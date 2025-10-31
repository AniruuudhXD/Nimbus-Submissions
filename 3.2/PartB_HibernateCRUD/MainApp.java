package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            // CREATE
            session.beginTransaction();
            Student s1 = new Student("Anirudh", "anirudh@email.com");
            session.save(s1);
            session.getTransaction().commit();
            System.out.println("Student saved!");

            // READ
            session = factory.openSession();
            Student fetched = session.get(Student.class, s1.getId());
            System.out.println("Fetched: " + fetched.getName());

            // UPDATE
            session.beginTransaction();
            fetched.setEmail("updated@email.com");
            session.update(fetched);
            session.getTransaction().commit();
            System.out.println("Updated successfully!");

            // DELETE
            session.beginTransaction();
            session.delete(fetched);
            session.getTransaction().commit();
            System.out.println("Deleted successfully!");
        } finally {
            session.close();
            factory.close();
        }
    }
}