package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02Tekrar {
     /*
	 Positive Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking
	 and()  Accept Type'i "application/json" dir.
	 then() status code 200'dur
	 and()  content type  "application/json" dir.
	*/

    @Test
    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().
                            accept(ContentType.JSON).
                            when().get(url);
        response.prettyPrint();

        System.out.println("Status Code "+ response.statusCode());

        response.then().assertThat().statusCode(200);

        Assert.assertEquals(200, response.statusCode());

        System.out.println("Status Line "+ response.statusLine());

        System.out.println( "Contetnt Type "+ response.contentType());

        response.then().assertThat().contentType(ContentType.JSON);

        System.out.println("Header "+ response.getHeader("Content-Type"));

       // Assert.assertEquals("application/json", response.contentType());
        System.out.println(response.getHeaders());

        System.out.println("Date "+ response.getHeader("Date"));

    }
      /*
         Negative Scenario:
         when() Bir GET Request asagida verilen Endpoint'e yollanir
                https://restful-booker.herokuapp.com/booking/1001
         and()  Accept Type'i "application/json" dir.
         then() status code 404'dur.
         */

    @Test
    public void test02(){
        String url = "https://restful-booker.herokuapp.com/booking/1001";

        Response response = given().
                            accept(ContentType.JSON).
                            when().get(url);
        response.prettyPrint();

        System.out.println(response.getHeaders());

        response.
                then().
                assertThat().
                statusCode(404);

        Assert.assertEquals(404, response.statusCode());

    }
    /*
	 Negative Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking/1001
	 then() status code 404'dur
	 and()  Response body'de "Not Found" var
	 and()  Response body'de "API" yok
	 */
    @Test
    public void test3(){
        String url = "https://restful-booker.herokuapp.com/booking/1001";

        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(404);

        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.toString().contains("API"));

    }
}
