package com.softserve.edu04;

public class B extends A implements IB {

    public B() {
        System.out.println("\tclass B constructor done");
    }

    @Override
    public void m1() {
        System.out.println("class B m1()");
        super.m1();
    }

    public void m3() {
        System.out.println("class B m3()");
    }
}
