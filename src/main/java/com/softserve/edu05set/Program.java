package com.softserve.edu05set;

import java.util.*;

public class Program {
        public static void main(String[] args) {
                //Set<String> set = new LinkedHashSet<>();
                //Set<String> set = new HashSet<>();
                //Set<String> set = new TreeSet<>();
                Set<String> set = new TreeSet<>(
                        new Comparator<String>() {
                                @Override
                                public int compare(String o1, String o2) {
                                        return -o1.compareTo(o2);
                                }
                        }
                );
                set.add("Mike");
                set.add("Nike");
                set.add("Alex");
                set.add("Sara");
                for (String current : set) {
                      System.out.println(current);
                }
        }
}