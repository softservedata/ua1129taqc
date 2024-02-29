package com.softserve.edu.homeworkjava1.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String priceStr = reader.readLine();

        double priceExcludingVat = Double.parseDouble(priceStr);
        double priceWithVat = priceExcludingVat * 1.2;

        System.out.println("Price excluding VAT: " + priceExcludingVat);
        System.out.println("Price including VAT: " + priceWithVat);
    }
}
