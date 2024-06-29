package com.host3030.productsinfo;

import com.host3030.model.Datum;
import com.host3030.testbase.TestBase;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostProductsTest extends TestBase {
    int IdNumber;
    @Test
    public void NewProductCreate(){

        Datum datum=new Datum();
        datum.setName("ice-cream");
        datum.setType("SoftGood");
        datum.setPrice(8.99F);
        datum.setUpc("bjfbjdbbkjx");
        datum.setShipping(22);
        datum.setDescription("createisveryhighqulitymatireal");
        datum.setManufacturer("Vadilal");
        datum.setModel("FirstTrial");
        datum.setUrl("www.valilalicecream.com");
        datum.setImage("mm_kk_YY_TT_RR");
        datum.setCreatedAt("MadeInBharat");
        datum.setUpdatedAt("Gujarat");
        Datum datum1= given()
                .log().all()
                .header("Content-Type","application/json")
                .when()
                .body(datum)
                .post()
                .getBody()
                .as(Datum.class);
        System.out.println(datum1.getId());
        IdNumber=datum1.getId();

    }
}
