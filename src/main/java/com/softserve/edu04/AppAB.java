package com.softserve.edu04;

public class AppAB {
    public static void main(String[] args) {
        /*
        //B b = new B();
        A b = new B();
        b.m1();
        b.m2();
        */
        //
        IB b1 = new B();
        //A b1 = new A();
        b1.m2();
        //b1.m1(); // Compile Error
        //((B) b1).m1();
        ((B) b1).m3();
        //
        /*
        int k = 1;
        double d = 2.5;
        System.out.println("Origin k = " + k + " d = " + d);
        //
        //d = k;
        //System.out.println("new d = " + d);
        //
        k = (int) d;
        System.out.println("new k = " + k);
        */
        //
    }
}
