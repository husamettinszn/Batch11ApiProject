package com.techproed;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseDummy;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest09Tekrar extends TestBaseDummy {
     /*
		 				Warm Up (10 Minutes)
		 1)Create a class and name it as GetRequest09
		 2)When
		 	 I send a GET Request to http://dummy.restapiexample.com/api/v1/employees
		 Then
			 status code is 200
			 And the name of the 5th employee is "Airi Satou"
			 And the salary of the 6th employee is "372000"
			 And there are "24" employees
			 And "Rhona Davidson" is one of the employees
			 And "21", "23", "61" are among(arasinda) the employee ages
		 3)Do the assertions by using Hard Assertion
	*/
    @Test
    public void get03(){
        spec03.pathParam("name", "employees");

        Response response = given().
                spec(spec03).
                with().
                get("/{name}");
        //response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                body("data.employee_name[4]", Matchers.equalTo("Airi Satou"),
                        "data.employee_salary[5]",Matchers.equalTo("372000"),
                        "data.id", Matchers.hasSize(24),
                        "data.employee_name", Matchers.hasItem("Rhona Davidson"),
                        "data.employee_age", Matchers.hasItems("21","23","61"));

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals("Airi Satou", jsonPath.getString("data.employee_name[4]"));
        Assert.assertEquals("372000", jsonPath.getString("data[5].employee_salary"));
        System.out.println(jsonPath.getList("data_id"));
        Assert.assertEquals(24,  jsonPath.getList("data.id").size());
        System.out.println(jsonPath.getList("data.employee_name"));
        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));

        List<String> yasListesi = new ArrayList<>();
        yasListesi.add("21");
        yasListesi.add("23");
        yasListesi.add("61");

        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(yasListesi));

    }
}
