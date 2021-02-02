package com.techproed;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBaseDummy;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends TestBaseDummy {
    /*
        Url: "http://dummy.restapiexample.com/api/v1/employees
        1) Butun calisanlarin isimlerini consola yazdır
        2) 3. calisan kisinin ismini konsola yazdır
        3) Ilk 5 calisanin adini konsola yazdir
        4) En son calisanin adini konsola yazdir.
     */

    @Test
    public void get01(){

        spec03.pathParam("employees", "employees");

        Response response = given().
                spec(spec03).
                when().
                get("/{employees}");


    }





}
