package com.softserve.practical08;

public class AppEmp {

    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", 10, 160);
        Employee petro = new Employee("Petro", 9, 160);
        //
        System.out.println("Ivan.getSalary = " + ivan.getSalary() + "  bonus = " + ivan.getBonuses());
        System.out.println("Petro.getSalary = " + petro.getSalary() + "  bonus = " + petro.getBonuses());
        System.out.println("Total = " + Employee.getTotalSum());
    }
}
