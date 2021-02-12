package com.techproed;

import TestData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBaseDummy;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest12Tekrar extends TestBaseDummy {
     /*
      When
      I send get request to yje URL http://dummy.restapiexample.com/api/v1/employees
      Then
      Status Code 200
      5. calisanin ismi "Airi Satou"
      Calisan sayisi 24
      Sondan ikinci calisanin maasi "106450"
      40,21 ve 19 yaslarinda calisanlar olup olmadıgı
      11. calisanin bilgileri {              "id": "11",
                                            "employee_name": "Jena Gaines",
                                            "employee_salary": "90560",
                                            "employee_age": "30",
                                            "profile_image": ""
                                             }
                                            seklinde mi
                                            Assert edelim.
    ​
     */
    @Test
    public void get(){

        // URL
        spec03.pathParam("employeesPath", "employees1");

        //Expected Data
        DummyTestData expectedObj = new DummyTestData();
        List< Map<String, Object>> expectedDataList= expectedObj.setUpData();
        System.out.println(expectedDataList);

        Response response = given().
                spec(spec03).
                when().
                get("/{employees1");
        response.prettyPrint();
    }
}
