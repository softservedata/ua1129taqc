package com.softserve.practical08;

import java.util.Objects;

public class Employee {

    private static double totalSum = 0;

    private String name;
    private double rate;
    private int hours;

    private double bonus = 0;

    public Employee() {
        name = "name";
        rate = 1;
        hours = 0;
    }

    public Employee(String name, double rate, int hours) {
        this.name = name;
        this.rate = rate;
        this.hours = hours;
    }

    public static double getTotalSum() {
        return totalSum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(rate, employee.rate) == 0 && hours == employee.hours && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate, hours);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", hours=" + hours +
                '}';
    }

    public double getSalary() {
        double result = getRate() * getHours();
        bonus = 0.1 * result;
        totalSum = totalSum + result + bonus;
        return result;
    }

    public double getBonuses() {
        return bonus;
    }
}
