package com.host3030.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase1 {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
        //http://localhost:8080/student
    }
}
