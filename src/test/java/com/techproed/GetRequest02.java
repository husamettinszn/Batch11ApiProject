package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static io.restassured.RestAssured.*;

public class GetRequest02 {
     /*
	 Positive Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking
	 and()  Accept Type'i "application/json" dir.
	 then() status code 200'dur
	 and()  content type  "application/json" dir.
	*/

        /*
         Negative Scenario:
         when() Bir GET Request asagida verilen Endpoint'e yollanir
                https://restful-booker.herokuapp.com/booking/1001
         and()  Accept Type'i "application/json" dir.
         then() status code 404'dur.
         */

    /*
	 Negative Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking/1001
	 then() status code 404'dur
	 and()  Response body'de "Not Found" var
	 and()  Response body'de "API" yok
	 */
    @Test
    public void get01(){
        //url yi olustur
        //datayi olustur
        //requesti gonder
        //Assert et

        String url = "https://restful-booker.herokuapp.com/booking";
        Response response = given().accept(ContentType.JSON).when().get(url);
        response.prettyPrint();

        System.out.println("Status Code= " +response.getStatusCode());
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(200,response.getStatusCode());

        System.out.println("Status Line= "+ response.statusLine());

        System.out.println("Content Type= "+response.getContentType());

        response.then().assertThat().contentType(ContentType.JSON);

        System.out.println("Header= "+ response.getHeader("Content-Type"));

      //  Assert.assertEquals("application/json", response.getContentType());
        System.out.println("========================");
        //Headers daki tum veriler
        System.out.println(response.getHeaders());

        //Headers dan belirli bir veri alalim
        System.out.println("Date="+response.getHeader("Date"));
    }
    @Test
    public void test02(){

        /*
	 Negative Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking/1001
	 then() status code 404'dur
	 and()  Response body'de "Not Found" var
	 and()  Response body'de "API" yok
	 */

        String url = "https://restful-booker.herokuapp.com/booking/1001";

        Response response= given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();
        System.out.println(response.getHeaders());

        response.
                then().
                assertThat().
                statusCode(404);
        Assert.assertEquals(404, response.getStatusCode());
    }

    @Test
    public void get03(){
        /*Negative Scenario:
        when() Bir GET Request asagida verilen Endpoint'e yollanir
        https://restful-booker.herokuapp.com/booking/1001
        then() status code 404'dur
        and()  Response body'de "Not Found" var
        and()  Response body'de "API" yok
                */
        String url ="https://restful-booker.herokuapp.com/booking/1001";

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
