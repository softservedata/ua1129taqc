package com.softserve.edu.JavaPart2HW.Framework.Data;

public class UserRepository {
    public UserRepository(){
    }

    public static User GetValidUser()
    {
        return new User("paneken468@azduan.com", "Test123@", "TestUser");
    }

    public static User GetInvalidUserWithIncorrectEmail()
    {
        return new User("samplestesgreencity.com", "Test123@", "InvalidUser");
    }

    public static User GetInvalidUserWithWeekPassword()
    {
        return new User("paneken468@azduan.com", "....", "InvalidUser");
    }

    public static User GetInvalidUser()
    {
        return new User("samplestesgreencity.com", "weekpassword", "InvalidUser");
    }
}
