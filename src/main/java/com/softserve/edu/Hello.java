package com.softserve.edu;

import com.softserve.edu04.Student;

public class Hello {

    public static void main(String[] args) {
        Student st1 = new Student("Ivan", "Ivanov");
        Student st2 = new Student();
        Student st3 = new Student();
        //
        if (st2 == st3) {
            System.out.println("st2 == st3 : true");
        } else {
            System.out.println("st2 == st3 : false");
        }
        //
        if ( st2.equals(st3) ) {
            System.out.println("st2.equals(st3) : true");
        } else {
            System.out.println("st2.equals(st3) : false");
        }
        System.out.println( "st2.hashCode() = " + st2.hashCode() );
        System.out.println( "st3.hashCode() = " + st3.hashCode() );
        //
        System.out.println("st1 = " + st1);
        //System.out.println("st1 = " + st1.toString()); // st1.toString();
        System.out.printf("Hello, count of students = " + Student.getCount());
    }
}
