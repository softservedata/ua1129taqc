package com.softserve.edu04;

import java.util.Objects;

public class Student { // extends Object {  // by default
    private static int count; // = 0;

    static {
        count = 0;
    }

    private String firstname;
    private String lastname;


    public Student() { // Overload
        firstname = "Ivan";
        lastname = "Petrov";
        count++;
    }

    public Student(String firstname, String lastname) { // Overload
        this.firstname = firstname;
        this.lastname = lastname;
        count++;
    }

    public String getFirstname() {
        // Get Role
        return firstname;
    }

    public static int getCount() {
        return count;
    }

    public void setFirstname(String firstname) {
        if (firstname.length() > 2) {
            this.firstname = firstname;
        } else {
            // ERROR
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstname, student.firstname)
                && Objects.equals(lastname, student.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", count=" + getCount() +
                '}';
    }
}
