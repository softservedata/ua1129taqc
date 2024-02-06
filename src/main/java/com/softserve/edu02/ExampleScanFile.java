package com.softserve.edu02;

import java.io.File;
import java.util.Scanner;

public class ExampleScanFile {
    public static void main(String[] args) {
        String path = ExampleScanFile.class.getResource("/test.txt").getPath();
        System.out.println("path = " + path);
        File file = new File(path);
        try (Scanner sc = new Scanner(file)) {
            String s;
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
