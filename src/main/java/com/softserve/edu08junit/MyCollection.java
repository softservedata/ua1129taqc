package com.softserve.edu08junit;

import java.util.ArrayList;
import java.util.List;

public class MyCollection {

    public List<String> getStringCollection() {
        List<String> collect = new ArrayList<>();
        collect.add("Alex");
        collect.add("Anna");
        collect.add("Natalya");
        return  collect;
    }
}
