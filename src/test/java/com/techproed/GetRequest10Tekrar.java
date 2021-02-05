package com.techproed;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBaseDummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest10Tekrar extends TestBaseDummy {
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
        spec03.pathParam("name", "employees");

        Response response = given().
                spec(spec03).
                when().
                get("/{name}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200);

        //Groovy language

        JsonPath jsonPath = response.jsonPath();

        List<String> idList = jsonPath.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println(idList);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(idList.size(),14);

        List<String> ageList = jsonPath.getList("data.findAll{Integer.valueOf(it.employee_age)<30}");
        System.out.println(ageList);

        List<String>  ageListInt = new ArrayList<>();

        for (String w: ageList
             ) {
            ageListInt.add(String.valueOf(w));
        }
        System.out.println(ageListInt);

        softAssert.assertAll();



    }
}
