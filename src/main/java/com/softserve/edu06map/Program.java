package com.softserve.edu06map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();

        //add elements to the map
        hashMap.put(1, "Mike");
        hashMap.put(2, "Nick");
        hashMap.put(3, "Sara");

        //get object by key 2
        String element = hashMap.get(2);
        System.out.println("Element by key 2: " + element);

        //returns a Set containing all map values
        Set<Integer> keys = hashMap.keySet();
        System.out.println("keys = " + keys);

        // get a set of all values
        Collection<String> values = hashMap.values();
        System.out.println("values = " + values);

        //replace element
        //hashMap.replace(3, "Alex");
        hashMap.put(3, "Alex");

        // deleting element by key 1
        hashMap.remove(1);

        // iterate through elements
        for (Integer key : keys) {
            System.out.print(key + ": ");
            System.out.println(hashMap.get(key));
        }
    }
}
