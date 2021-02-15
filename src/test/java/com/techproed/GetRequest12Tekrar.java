package com.techproed;

import TestData.DummyTestData;
import io.restassured.internal.common.assertion.AssertionSupport;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseDummy;

import java.util.ArrayList;
import java.util.HashMap;
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
        spec03.pathParam("employeesPath", "employees");

        //Expected Data
        DummyTestData expectedObj = new DummyTestData();
        List< Map<String, Object>> expectedDataList= expectedObj.setUpData();
        System.out.println(expectedDataList);

        //Actual Data
        Response response = given().
                spec(spec03).
                when().
                get("/{employeesPath}");
        //response.prettyPrint();

       response.
                then().
                assertThat().
                statusCode((Integer)expectedDataList.get(0).get("Status Code")).
                body("data[4].employee_name", Matchers.equalTo(expectedDataList.get(1).get("SelectedEmployeeName")),
                "data.id", Matchers.hasSize((Integer)expectedDataList.get(2).get("NumOfEmployees")),
                 "data[-2].employee_salary", Matchers.equalTo(expectedDataList.get(3).get("SelectedSalary")),
                        "data.employee_age", Matchers.hasItems (
                                ((List)expectedDataList.get(4).get("MulipleAges")).get(0),
                                ((List) expectedDataList.get(4).get("MulipleAges")).get(1),
                                ((List) expectedDataList.get(4).get("MulipleAges")).get(2)),
                        "data[10].employee_name", Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_name")),
                        "data[10].employee_salary", Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_salary")),
                        "data[10].employee_age", Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_age")),
                        "data[10].profile_image", Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("profile_image"))
                );

       //DE-Serialization
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedDataList.get(0).get("Status Code"), response.statusCode());
        Assert.assertEquals(expectedDataList.get(1).get("SelectedEmployeeName"), ((Map)((List)actualDataMap.get("data")).get(4)).get("employee_name"));
        Assert.assertEquals(expectedDataList.get(2).get("NumOfEmployees"), ((List) actualDataMap.get("data")).size());
        int numOfEmployees = ((List) actualDataMap.get("data")).size();
        Assert.assertEquals(expectedDataList.get(3).get("SelectedSalary"), ((Map)((List) actualDataMap.get("data")).get(numOfEmployees-2)).get("employee_salary"));

        List<String> ageList = new ArrayList<>();
        for(int i=0; i<numOfEmployees; i++){
            ageList.add((String)(((Map)(((List) actualDataMap.get("data")).get(i))).get("employee_age")));
        }
        System.out.println(ageList);

        Assert.assertTrue( ageList.containsAll((List)(expectedDataList.get(4).get("MulipleAges"))) );

        Assert.assertEquals(((Map) expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_name"), ((Map)(((List) actualDataMap.get("data")).get(10))).get("employee_name"));
        Assert.assertEquals(((Map) expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_salary"),  ((Map)(((List) actualDataMap.get("data")).get(10))).get("employee_salary") );
        Assert.assertEquals(((Map) expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_age"),  ((Map)(((List) actualDataMap.get("data")).get(10))).get("employee_age"));
        Assert.assertEquals(((Map) expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("profile_image"),  ((Map)(((List) actualDataMap.get("data")).get(10))).get("profile_image")  );







    }
}
