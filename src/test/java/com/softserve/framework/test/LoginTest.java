package com.softserve.framework.test;

import com.softserve.framework.data.MenuRepository;
import com.softserve.framework.data.MyMenu;
import com.softserve.framework.data.User;
import com.softserve.framework.data.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LoginTest extends TestRunner {

    private static Stream<Arguments> provideUsers() {
        return Stream.of(
                //Arguments.of("tyv09754@zslsz.com", "Qwerty_1", "QwertyY")
                //Arguments.of(new User("tyv09754@zslsz.com", "Qwerty_1", "QwertyY"))
                Arguments.of(UserRepository.getValidUser())
        );
    }

    //@Test
    @ParameterizedTest//(name = "{index} => email={0}, password={1}, username={2}")
    @MethodSource("provideUsers")
    //public void checkLogin(String email, String password, String expectedUserName) {
    public void checkLogin(User user) {
        logger.info("Start with user = " + user);
        // Login
        //guestOperation.signIn(email, password);
        guestOperation.signIn(user);
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        String expectedUserName = user.getName();
        Assertions.assertEquals(expectedUserName, logginedOperation.getLogginedName());
    }

    private static Stream<Arguments> provideMenuMyHabit() {
        return Stream.of(
                //Arguments.of("tyv09754@zslsz.com", "Qwerty_1", "My habits")
                //Arguments.of(new User("tyv09754@zslsz.com", "Qwerty_1", "QwertyY"),
                //        new MyMenu().addSubMenuName("My habits").addSubMenuName("My news"))
                Arguments.of(UserRepository.getValidUser(), MenuRepository.getMySpaceMenu())
        );
    }

    //@Test
    @ParameterizedTest//(name = "{index} => email={0}, password={1}, username={2}")
    @MethodSource("provideMenuMyHabit")
    //public void checkMyHabit(String email, String password, String expectedLabel) {
    public void checkMyHabit(User user, MyMenu myMenu) {
        logger.info("Start with user = " + user + " myMenu = " + myMenu);
        // Steps
        //guestOperation.signIn(email, password);
        guestOperation.signIn(user);
        presentationSleep(); // For Presentation ONLY
        //
        guestOperation.greencitySwitch();
        presentationSleep(); // For Presentation ONLY
        //
        logginedOperation.chooseMySpace();
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        String expectedLabel = myMenu.getSubMenuName(0);
        Assertions.assertEquals(expectedLabel, logginedOperation.getMyHabbitsMenuName());
    }
}
