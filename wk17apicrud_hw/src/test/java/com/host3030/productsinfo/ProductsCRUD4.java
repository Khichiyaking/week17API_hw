package com.host3030.productsinfo;

import com.host3030.model.Datum;
import com.host3030.model.Products;
import com.host3030.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductsCRUD4 extends TestBase {
    int IdNumber;

    @Test
    public void AllProducts(){
        Products products = given()
                .when()
                .get()
                .getBody().as(Products.class);
        System.out.println(products.getTotal());
    }

    @Test
    public void CreateProducts(){
        Datum datum=new Datum();
        datum.setName("ice-cream five");
        datum.setType("Soft five times Good");
        datum.setPrice(10.99F);
        datum.setUpc("xxyyzzxxzzyy");
        datum.setShipping(92);
        datum.setDescription("bestmatireal");
        datum.setManufacturer("Vadilal");
        datum.setModel("FiveTrial");
        datum.setUrl("www.valilalicecream.com");
        datum.setImage("DD_HH_AA_VV_AA_LL");
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

    @Test
    public void ProductGetById(){
        Datum datum1=given().log().all()
                .pathParam("id",IdNumber)
                .when()
                .get("/{id}")
                .getBody()
                .as(Datum.class);
        System.out.println(datum1.getName());
    }

    @Test
    public void UpdateProduct(){
        Datum datum=new Datum();
        datum.setPrice(234F);
        datum.setShipping(45);
        datum.setUpc("asdfgh");
        datum.setDescription("newfievnew");
        datum.setManufacturer("NewVanila");
        datum.setModel("Icecream choco");
        datum.setImage("NEW five Photo");

        Response response=given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id", IdNumber)
                .when()
                .body(datum)
                .patch("/{id}");
        response.then().statusCode(200);
    }
    @Test
    public void DeleteProductByID(){
        Response response=given()
                .log().all()
                .pathParam("id",IdNumber)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);  }

    @Test
    public void DeleteProductVerify(){
        Response response=given().log().all()
                .pathParam("id",IdNumber)
                .when()
                .get("/{id}");
        response.then().statusCode(404);
    }
}
