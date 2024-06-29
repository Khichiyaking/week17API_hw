package com.host3030.productsinfo;

import com.host3030.model.Datum;
import com.host3030.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProductsTest extends TestBase {
    int IdNumber;
    @Test
    public void GetProducts(){
    given()
            .when()
            .get("http://localhost:3030/products")
            .then()
            .statusCode(200);
    }

    @Test
    public void GetProductCheckByID(){
        Datum datum = given()
                .log().all()
                .pathParams("id", IdNumber)
                .when()
                .get("/{Id}")
                .getBody()
                .as(Datum.class);
        System.out.println(datum.getName());
    }

}
