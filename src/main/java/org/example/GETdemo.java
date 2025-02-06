package org.example;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GETdemo {
    @BeforeSuite
    void setUP(){
        System.out.println("Setup");
    }
    @Test
    void test1(){
        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.basePath= "/users?page=2";
        System.out.println("Test1");
    }
    @AfterSuite
    void Aftertest(){
        System.out.println("Aftertest");
    }
}
