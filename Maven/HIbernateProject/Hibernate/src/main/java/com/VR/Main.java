package com.VR;

import com.VR.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("amour V P", "amour@gamil.com", 20);
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();
//        session.persist(student);        ---------> Create operation

        Student student1 = session.find(Student.class,2);  //---------------> read operation by id

//        student1.setName("Vijay");
//        session.merge(student1);            ---------------> update operation by using object
//        session.find(Student.class,2);

//        session.remove(student1);          -----------------> delete operation using object
        transaction.commit();
        System.out.println(student1.toString());
        session.close();
    }
}