package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBase;

import static io.restassured.RestAssured.given;

public class FatihHoca extends TestBase {
    /*
     * When I send a GET request to REST API URL
     * https://restful-booker.herokuapp.com/booking/5


     * Then HTTP Status Code should be 200
            * And response content type is “application/JSON”
            * And response body should be like;
	 *   {"firstname": "Sally",
	 *   "lastname": "Ericsson",
	 *   "totalprice": 111,
	 *   "depositpaid": false,
	 *   "bookingdates": { "checkin": "2017-05-23",
	 *                     "checkout":"2019-07-02" }
	 * }

     */
    @Test
    public void get008(){
        spec001.pathParams("bookingPath", "booking",
				"id", 5);
		Response response = given().
				spec(spec001).
				when().
				get("/{bookingPath}/{id}");
		response.prettyPrint();

		response.
				then().
				assertThat().
				statusCode(200).
				contentType("application/JSON");

		JsonPath  jsonPath = response.jsonPath();

		Assert.assertEquals("firstname is not matching", "Jim", jsonPath.getString("firstname"));






    }

}
