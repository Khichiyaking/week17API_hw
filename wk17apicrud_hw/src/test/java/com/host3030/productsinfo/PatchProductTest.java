package com.host3030.productsinfo;

import com.host3030.model.Datum;
import com.host3030.testbase.TestBase;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchProductTest extends TestBase {
    int IdNumber;
    @Test
    public void PatchProductsChange(){
        Datum datum = new Datum();
        datum.setName("Smoothy ice-cream");
        datum.setType("100%soft");
        datum.setPrice(7.99F);
        datum.setUpc("bjfbCDDERRVbkjx");
        datum.setShipping(21);
        datum.setDescription("createisveryhighqulitypowdermilk");
        datum.setManufacturer("Vadilal");
        datum.setModel("LastTrial");
        Response response= given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParams("id",IdNumber)
                .when()
                .body(datum)
                .patch("/{id}");
        response.then().statusCode(200);
    }
}
