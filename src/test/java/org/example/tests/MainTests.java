package org.example.tests;

import org.testng.annotations.*;

public class MainTests {
    @Test
    public void firstTest(){
        System.out.println("I`m the first test");
    }

    @Test
    public void secondTest(){
        System.out.println("I`m the second test");
    }

    @Test
    public void thirdTest(){
        System.out.println("I`m the third test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("MainTests::BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("MainTests::AfterMethod");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("MainTests::BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("MainTests::AfterTest");
    }
}
