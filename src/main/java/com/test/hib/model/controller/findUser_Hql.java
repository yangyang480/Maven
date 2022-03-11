package com.test.hib.model.controller;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class findUser_Hql {

    public void findAllUser()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        //example for HQL to get all records from user table
        String hql = "From User"; //we have to use class name instead of table name. we don't need to use select.
        //String hql = "SELECT u FROM User u"; this is the same with the one above.
        Query q = session.createQuery(hql); //we still can use this one, will not get error, it's depressed.
        q.getResultList(); //return type will be a single expression, then we
        List<User> ulist = q.getResultList();
        for (User u : ulist)
        {
            System.out.println("user id: " + u.getId() + "user name: " + u.getFullname() + "user city: " + u.getCity());
        }
        //the result have lots of red text that's logs. it's not error.
        factory.close();
        session.close();
    }

    public void getRecordbyId()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "SELECT u FROM User u WHERE u.id < 3 ORDER BY u.id DESC";
        Query q = session.createQuery(hql);
        q.getResultList();
        List<User> ulist = q.getResultList(); //list we will get multiple results
        for (User u : ulist)
        {
            System.out.println("user id: " + u.getId() + "user name: " + u.getFullname() + "user city: " + u.getCity());
        }
        factory.close();
        session.close();
    }

    public void getMaxSalary()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "SELECT MAX(u.salary) FROM User u";
        Query q = session.createQuery(hql); //we can also use TypeQuery, typeQuery is the latest version.
        q.getResultList();
        Double sa = (Double) q.getSingleResult(); //getsingleresult used when we will get only single result. this method will return us an object, we can't print object directly, so we need to do the type casting.
        //List data = q.getSingleResult(); since list is generic type so when we don't put any datatype in, we don't need to do the type casting here. but the result we will get is in [].
        System.out.println("Max Salary: " + sa);
        factory.close();
        session.close();
    }

    public void getAllUsers(int getuserId){ // we set this parameter here will pass it to line71. we making the code dynamic, we can make it more dynamic.
        //we can use prepared statement make the query more dynamic
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "SELECT u FROM User u WHERE u.id = :userid"; //this is the prepared statement. but is different using with JDBC, jdbc using ?, in hibernate we use :
        TypedQuery q = session.createQuery(hql);
        q.setParameter("userid", getuserId);
        List<User> ulist = q.getResultList();
        for (User u : ulist)
        {
            System.out.println("user id: " + u.getId() + "user name: " + u.getFullname() + "user city: " + u.getCity());
        }
        factory.close();
        session.close();
    }

}

