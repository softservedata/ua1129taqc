package com.softserve.framework.data;

public final class MenuRepository {

    private MenuRepository() {
    }

    public static MyMenu getDefault() {
        return getMySpaceMenu();
    }

    public static MyMenu getMySpaceMenu() {
        return new MyMenu()
                .addSubMenuName("My habits")
                .addSubMenuName("My news")
                .addSubMenuName("My Events");
    }
}
