package com.host3030.productsinfo;

import com.host3030.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteProductTest extends TestBase {

    int IdNumber;
    @Test
    public void DeleteProduct(){
        Response response = given()
                .log().all()
                .pathParams("id",IdNumber)
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
    }
}
