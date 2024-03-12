package com.softserve.framework.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LoginTest extends TestRunner {

    private static Stream<Arguments> provideUsers() {
        return Stream.of(
                Arguments.of("tyv09754@zslsz.com", "Qwerty_1", "QwertyY")
        );
    }

    //@Test
    @ParameterizedTest//(name = "{index} => email={0}, password={1}, username={2}")
    @MethodSource("provideUsers")
    public void checkLogin(String email, String password, String expectedUserName) {
        // Login
        guestOperation.signIn(email, password);
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        Assertions.assertEquals(expectedUserName, logginedOperation.getLogginedName());
    }

    private static Stream<Arguments> provideMenuMyHabit() {
        return Stream.of(
                Arguments.of("tyv09754@zslsz.com", "Qwerty_1", "My habits")
        );
    }

    //@Test
    @ParameterizedTest//(name = "{index} => email={0}, password={1}, username={2}")
    @MethodSource("provideMenuMyHabit")
    public void checkMyHabit(String email, String password, String expectedLabel) {
        // Steps
        guestOperation.signIn(email, password);
        presentationSleep(); // For Presentation ONLY
        //
        guestOperation.greencitySwitch();
        presentationSleep(); // For Presentation ONLY
        //
        logginedOperation.chooseMySpace();
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        Assertions.assertEquals(expectedLabel, logginedOperation.getMyHabbitsMenuName());
    }
}
