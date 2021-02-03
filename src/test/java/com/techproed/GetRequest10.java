package com.techproed;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBaseDummy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends TestBaseDummy {
    /*
	 When
		 I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
	 Then
		 Status code is 200
		 1)Print all ids greater than 10 on the console
		   Assert that there are 14 ids greater than 10
		 2)Print all ages less than 30 on the console
		   Assert that maximum age is 23
		 3)Print all employee names whose salaries are greater than 350,000
		   Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
	 */
    @Test
    public void get01(){
        spec03.pathParam("employeePath", "employees");

        Response response = given().
                spec(spec03).
                with().
                get("/{employeePath}");
       //response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200);

        SoftAssert softAssert = new SoftAssert();

        JsonPath jsonPath = response.jsonPath();

        List<String> idLIst =jsonPath.getList("data.findAll{Integer.valueOf(it.id)>10}"); // it this görevi görür
        System.out.println(idLIst);

        softAssert.assertEquals(idLIst.size(), 14);

        List<String> ageList = jsonPath.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
                                                  //("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age"
         System.out.println(ageList);

        List<Integer> ageListInt = new ArrayList<>();

        for (String w: ageList
             ) {
            ageListInt.add(Integer.valueOf(w));
        }
        System.out.println(ageListInt);
        Collections.sort(ageListInt);
        softAssert.assertEquals(Integer.valueOf("23"), ageListInt.get(ageListInt.size()-1));

        List<String> salaryList = jsonPath.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");

        softAssert.assertAll();


    }
}
