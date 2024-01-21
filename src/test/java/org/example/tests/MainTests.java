package org.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTests {
    @Test (groups="unit3", dependsOnGroups = "unit1")
    public void firstTest(){
        System.out.println("MainTests::firstTest @" + Thread.currentThread().getName());
    }

    @Test (groups = "unit1")
    public void secondTest(){
        System.out.println("MainTests::secondTest @" + Thread.currentThread().getName());
    }

    @Test (groups="unit3", dependsOnGroups = "unit1")
    public void thirdTest(){
        System.out.println("MainTests::thirdTest @" + Thread.currentThread().getName());
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("MainTests::BeforeMethod @" + Thread.currentThread().getName());
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("MainTests::AfterMethod @" + Thread.currentThread().getName());
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("MainTests::BeforeTest @" + Thread.currentThread().getName());
    }

    @AfterTest
    public void afterTest(){
        System.out.println("MainTests::AfterTest @" + Thread.currentThread().getName());
    }
}
