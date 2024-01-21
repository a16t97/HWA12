package org.example.tests;

import org.testng.annotations.*;

public class PrioritTests {
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
        System.out.println("PrioritTests::BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("PrioritTests::AfterMethod");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("PrioritTests::BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("PrioritTests::AfterTest");
    }
}
