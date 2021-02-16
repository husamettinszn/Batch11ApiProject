package com.techproed;

import TestData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseDummy;

import javax.swing.*;
import java.util.*;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class GetRequest14Tekrar<salaryListInt, Collectio> extends TestBaseDummy {
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
    //response.prettyPrint();

    JsonPath jsonPath = response.jsonPath();
                                                //Integer                       //int
    Assert.assertEquals((expectedDataMap.get("Status code")), (Integer) (response.statusCode()));

    List<String> salaryList = jsonPath.getList("data.employee_salary");
    System.out.println(salaryList);

    List<Integer> salaryListInt = new ArrayList<>();
    salaryList.stream().forEach(t->salaryListInt.add(Integer.valueOf(t)));

    Collections.sort(salaryListInt);
    System.out.println(salaryListInt);

    Assert.assertEquals(expectedDataMap.get("highest_salary"), salaryListInt.get(salaryListInt.size()-1));

    List<String> ageList = jsonPath.getList("data.employee_age");

    List<Integer> ageListInt = new ArrayList<>();
    ageList.stream().forEach(t-> ageListInt.add(Integer.valueOf(t)));
    Collections.sort(ageListInt);
    System.out.println(ageListInt);
    Assert.assertEquals(expectedDataMap.get("minimum_age"), ageListInt.get(0));
    Assert.assertEquals(expectedDataMap.get("highest_age"), ageListInt.get(ageListInt.size()-1));

    Assert.assertEquals(expectedDataMap.get("second_highest_salary"), salaryListInt.get(salaryListInt.size()-2));

    //De-Serialization
    Map<String, Object> actualDataMap = response.as(HashMap.class);
    System.out.println(actualDataMap);

    Assert.assertEquals(expectedDataMap.get("Status code"), (Integer) response.statusCode());

    List<String> salaryList2 = new ArrayList<>();
    for (int i=0; i<((List)(actualDataMap.get("data"))).size(); i++){
        salaryList2.add(  (String) (((Map)(((List)(actualDataMap.get("data"))).get(i))).get("employee_salary"))  );
    }
    List<Integer> salaryList2Int = new ArrayList<>();
    salaryList2.stream().forEach(t->salaryList2Int.add(Integer.valueOf(t)));

    Collections.sort(salaryList2Int);
    System.out.println(salaryList2Int);

    Assert.assertEquals(expectedDataMap.get("highest_salary"), salaryList2Int.get(salaryListInt.size()-1));
    Assert.assertEquals(expectedDataMap.get("second_highest_salary"), salaryList2Int.get(salaryList2Int.size()-2));

    List<String> ageList2= new ArrayList<>();
    for (int i=0; i< ((List)(actualDataMap.get("data"))).size(); i++){
        ageList2.add(  (String) (((Map)((List)(actualDataMap.get("data"))).get(i))).get("employee_age"));
    }
    List<Integer> agelistInt2 = new ArrayList<>();
    ageList2.stream().forEach(t->agelistInt2.add(Integer.valueOf(t)));

    Collections.sort(agelistInt2);
    Assert.assertEquals(expectedDataMap.get("minimum_age"), agelistInt2.get(0));
    Assert.assertEquals(expectedDataMap.get("highest_age"), agelistInt2.get(agelistInt2.size()-1));
    }





}

