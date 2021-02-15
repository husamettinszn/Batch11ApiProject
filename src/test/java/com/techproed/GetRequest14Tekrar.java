package com.techproed;

import TestData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseDummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest14Tekrar extends TestBaseDummy {
     /*
     When
         I send a request to http://dummy.restapiexample.com/api/v1/employees
     Then
         Status code is 200
         And the highest salary is 725000
         And the minimum age is 19
         And the second highest salary is 675000
*/
@Test
    public  void get01(){
    spec03.pathParam("employeesPath", "employees");

    DummyTestData expextedDataObj = new DummyTestData();
    Map<String, Integer> expectedDataMap = expextedDataObj.setUPData2();
    System.out.println(expectedDataMap);


    Response response = given().
            spec(spec03).
            when().
            get("/{employeesPath}");
    response.prettyPrint();

    JsonPath jsonPath = response.jsonPath();
                                                //Integer                       //int
    Assert.assertEquals((expectedDataMap.get("Status code")), (Integer) (response.statusCode()));


}
}
