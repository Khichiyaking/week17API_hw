package com.host3030.Studentinfo;

import com.host3030.model.StudentPojo;
import com.host3030.testbase.TestBase1;
import com.host3030.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class StudentCrud_3 extends TestBase1 {

    int IdNumber;
    static String firstName = "Divyam"+ TestUtils.getRandomValue();
    static String lastname = "Patel" + TestUtils.getRandomValue();
    static String programme = "Social Sciences";
    static String email = TestUtils.getRandomValue()+ "@gmail.com";
    static int studentId;

    @Test
    public void getStudentinfo(){
        given()
                .when()
                .get("/list")
                .then().statusCode(200);
    }
    @Test
    public void NewStudentCreate() {
        List<String> courseList = new ArrayList<>();
        courseList.add("Social");
        courseList.add("Sciences");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courseList);

        Response response =given().log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(studentPojo)
                .post();
        response.then().statusCode(201);

    }

    @Test
    public void FatchStudentData(){
            HashMap<String, Object> studentData =given()
                    .when()
                    .get("/list")
                    .then()
                    .statusCode(200)
                    .extract().path("findAll{it.firstName =='"+firstName+"'}.get(0)");

            studentId= (int) studentData.get("id");
            System.out.println(studentId);
        }

    @Test
    public void StudentVerifyByID(){
        Response response =given().log().all()
                .pathParam("id",studentId)
                .when()
                .get("/{id}");
        response.then().log().all().statusCode(200).body("firstName", equalTo(firstName));

    }

    @Test
    public void StudentDeleteByID(){
        Response response =given().log().all()
                .pathParam("id",studentId)
                .when()
                .delete("/{id}");
        response.then().log().all().statusCode(204);
    }

    @Test
    public void StudentDeleteVerifyByID(){
        Response response =given().log().all()
                .pathParam("id",studentId)
                .when()
                .get("/{id}");
        response.then().log().all().statusCode(404);
    }
}
