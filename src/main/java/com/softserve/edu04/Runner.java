package com.softserve.edu04;

public class Runner {
    public static void main(String[] args) {
        //
        Helper.setMessage("hello");
        Helper.print();
        //
        // Not recommended
        Helper helper = new Helper();
        helper.setMessage("new message");
        helper.print();
    }
}
