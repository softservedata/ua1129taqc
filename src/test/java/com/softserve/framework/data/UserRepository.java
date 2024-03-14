package com.softserve.framework.data;

public final class UserRepository {

    private UserRepository() {
    }

    public static User getDefault() {
        return getValidUser();
    }

    public static User getValidUser() {
        return new User("tyv09754@zslsz.com", "Qwerty_1", "QwertyY");
    }
}
