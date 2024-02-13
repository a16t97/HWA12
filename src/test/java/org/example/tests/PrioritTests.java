package org.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrioritTests {
    @Test (groups="unit1")
    public void oneTest(){
        System.out.println("PrioritTests::oneTest @" + Thread.currentThread().getName());
    }

    @Test (groups="unit2")
    public void twoTest(){
        System.out.println("PrioritTests::twoTest @" + Thread.currentThread().getName());
    }

    @Test (groups="unit3")
    public void threeTest(){
        System.out.println("PrioritTests::threeTest @" + Thread.currentThread().getName());
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("PrioritTests::BeforeMethod @" + Thread.currentThread().getName());
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("PrioritTests::AfterMethod @" + Thread.currentThread().getName());
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("PrioritTests::BeforeTest @" + Thread.currentThread().getName());
    }

    @AfterTest
    public void afterTest(){
        System.out.println("PrioritTests::AfterTest @" + Thread.currentThread().getName());
    }
}

