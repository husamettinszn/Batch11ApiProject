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
    public void get(){
        spec03.pathParam("employeesPath","employees");

        Response response = given().
                spec(spec03).
                when().
                get("/{employeesPath}");
        //response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200);
        SoftAssert softAssert = new SoftAssert();

        JsonPath jsonPath= response.jsonPath();

        List<String> idList = jsonPath.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println(idList);
        softAssert.assertEquals(idList.size(), 14);

        List<String> ageList = jsonPath.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        System.out.println(ageList);

        List<Integer> ageListInt = new ArrayList<>();
        for (String w: ageList
             ) {
            ageListInt.add(Integer.valueOf(w));
        }
        Collections.sort(ageListInt);
        softAssert.assertTrue(ageListInt.get(ageListInt.size()-1).equals(23));
        softAssert.assertEquals(ageListInt.get(ageListInt.size()-1), Integer.valueOf("23"));

        List<String> name = jsonPath.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
        System.out.println(name);

        softAssert.assertTrue(name.contains("Charde Marshall"));



        softAssert.assertAll();
    }

}
