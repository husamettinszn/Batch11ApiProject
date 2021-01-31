package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {
    /*
	 Positive Scenario:
		 When I send a GET Request to
		     http://dummy.restapiexample.com/api/v1/employees
	     And Accept type  “application/JSON” olsun
	     Then
	         HTTP Status Code 200 olsun
	     And Response'in format "application/JSON" olsun
	     And 24 employees olsun
	     And "Ashton Cox" employee'lerden biri olsun
	     And 21, 61, ve 23 employee yaslarindan biri olsun
	*/
    @Test
    public void test01(){
        String url = "http://dummy.restapiexample.com/api/v1/employees";

        Response response = given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                body("data.id", Matchers.hasSize(24)).
                body("data.employee_name", Matchers.hasItem("Ashton Cox")).
                body("data.employee_age", Matchers.hasItems("21","61","23"));


    }



}
