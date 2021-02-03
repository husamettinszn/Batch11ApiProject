package com.techproed;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
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

        response.prettyPrint();

        JsonPath jsonPath =response.jsonPath();
        System.out.println(jsonPath.getString("data.employee_name"));
        System.out.println(jsonPath.getString("data.employee_salary"));
        System.out.println(jsonPath.getString("data.employee_name[2]"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getString("data.employee_name[2]"), "Ashton Cox");
        System.out.println(jsonPath.getString("data.employee_name[0,1,2,3,4]"));
        System.out.println(jsonPath.getString("data[0,1,2,3,4].employee_name"));
        System.out.println(jsonPath.getString("data[-1].employee_name"));
        System.out.println(jsonPath.getString("data.employee_name[-1]"));

        softAssert.assertAll();



    }





}
