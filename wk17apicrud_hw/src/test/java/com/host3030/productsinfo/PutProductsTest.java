package com.host3030.productsinfo;

import com.host3030.model.Datum;
import com.host3030.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutProductsTest extends TestBase {
    int IdNumber;
    @Test
    public void UpdateProducts(){
        Datum datum = new Datum();
        datum.setName("Vanial ice-cream");
        datum.setType("VerySoftGood");
        datum.setPrice(9.99F);
        datum.setUpc("bjfbCCCVVbkjx");
        datum.setShipping(25);
        datum.setDescription("createisveryhighqulitymilk");
        datum.setManufacturer("Vadilal");
        datum.setModel("FinalFirstTrial");
        datum.setUrl("www.valilalicecream.com");
        datum.setImage("mm_kk_YY_TT_RR_SS_CC");
        datum.setCreatedAt("MadeInBharat");
        datum.setUpdatedAt("Mumbai");
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
