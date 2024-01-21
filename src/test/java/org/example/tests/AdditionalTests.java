package org.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdditionalTests {
    @Test (groups="unit1")
    public void aTest(){
        System.out.println("AdditionalTests::aTest @" + Thread.currentThread().getName());
    }

    @Test (groups="unit2")
    public void bTest(){
        System.out.println("AdditionalTests::bTest @" + Thread.currentThread().getName());
    }

    @Test (groups="unit3")
    public void cTest(){
        System.out.println("AdditionalTests::cTest @" + Thread.currentThread().getName());
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("AdditionalTests::BeforeMethod @" + Thread.currentThread().getName());
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AdditionalTests::AfterMethod @" + Thread.currentThread().getName());
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("AdditionalTests::BeforeTest @" + Thread.currentThread().getName());
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AdditionalTests::AfterTest @" + Thread.currentThread().getName());
    }
}
