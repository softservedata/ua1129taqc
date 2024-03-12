package com.softserve.framework.data;

import java.util.ArrayList;
import java.util.List;

public class MySpaceMenu {
    private List<String> subMenu;

    public MySpaceMenu() {
        subMenu = new ArrayList<>();
    }

    public MySpaceMenu addSubMenuName(String subMenuName) {
        subMenu.add(subMenuName);
        return this;
    }

    public String getSubMenuName(int index) {
        if (subMenu.size() <= index) {
            throw new RuntimeException("ERROR: subMenu.size() = " + subMenu.size() + " <= index = " + index);
        }
        return subMenu.get(index);
    }
}
