package com.softserve.edu04;

public class A { //extends Object {
    Student student = null;

    private int i = 123;

    public A() {
        System.out.println("class A constructor done");
    }


    public void m1() {
        System.out.println("class A m1() i = " + i);
    }

    public void m2() {
        System.out.println("class A m2() i = " + i);
    }
}
