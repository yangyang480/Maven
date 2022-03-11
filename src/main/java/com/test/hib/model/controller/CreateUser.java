package com.test.hib.model.controller;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateUser {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       /* Configuration cfg = new Configuration(); //we need to create the configuration activate connection
        Configuration c = cfg.configure();//create the connection looking for hibernate.cfg.cml for db information
        SessionFactory f = c.buildSessionFactory();// we need to create session factory return a database connection
        Session s = f.openSession(); //open the session for available connection
        Transaction t = s.beginTransaction(); //execute all the CRUD operation.
        */

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction(); // if you are going to use the select statement, so we need use transcation.
        //this is the short cuts of above code.

        User uone = new User();
        uone.setEmail("haseeb@gmail.com");
        uone.setFullname("Moh Haseeb");
        uone.setPassword("has123");
        uone.setSalary(2000.69);
        uone.setAge(20);
        uone.setCity("NYC");
        //uone.setId(1);//will be autogenerate by the save(), we setid because the PK will not be null.

        User uTwo = new User();
        uTwo.setEmail("James@gmail.com");
        uTwo.setFullname("James Santana");
        uTwo.setPassword("James123");
        uTwo.setSalary(2060.69);
        uTwo.setAge(25);
        uTwo.setCity("Dallas");
        //uTwo.setId(2);

        User uThree = new User();
        uThree.setEmail("Shahparan@gmail.com");
        uThree.setFullname("AH Shahparan");
        uThree.setPassword("Shahparan123");
        uThree.setSalary(3060.69);
        uThree.setAge(30);
        uThree.setCity("Chicago");
        //uThree.setId(3);

        /*========= We can pass value/data by using constructor =========*/
        User ufour = new User( "Christ", "christ@gmail.com",  "147852", 35, 35000.3,"NJ");
        User ufive = new User("Sid", "Sid", "s258", 29, 4000.36, "LA");
        Integer  userid = null;
        session.save(uone); //save the entity, don't need to setid manually, we can delete the setid.
        session.save(uTwo);
        session.save(uThree);
        session.save(ufour);
        session.save(ufive);

        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

}
