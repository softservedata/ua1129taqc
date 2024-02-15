package com.softserve.edu05set;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AppSet {

    public static void main(String[] args) {
        // /*-
		Set<String> s = new HashSet<>();
		//List<String> s = new LinkedList<>();
		for (int i = 0; i < args.length; i++) {
		    if (!s.add(args[i])) {
		        System.out.println("Duplicate detected: " + args[i]);
		    }
		}
		System.out.println("Elements: " + s);
		// */
    }
}
