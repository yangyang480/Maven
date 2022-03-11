package com.test.hib.model.controller;

import java.util.Scanner;

public class Runnable {
    public static void main(String[] args) {
        findUser_Hql ObjHql = new findUser_Hql();
        ObjHql.findAllUser();
        ObjHql.getRecordbyId();
        ObjHql.getMaxSalary();
        System.out.println("Please enter the user id: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        ObjHql.getAllUsers(input);//this is the way to make it dynamic.
        ObjHql.getAllUsers(2);//this is how we make it dynamic

    }
}
