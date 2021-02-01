package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest03Tekrar {
    	/*
	 Positive Scenario:
	 When Asagidaki Endpoint'e bir GET request yolladim
	 https://restful-booker.herokuapp.com/booking/7
     And Accept type “application/json” dir
     Then
     HTTP Status Code 200
     And Response format "application/json"
     And firstname "Sally"
     And lastname "Jackson"
     And checkin date "2017-04-19"
     And checkout date "2020-03-22"
	*/
    @Test
    public void test01(){
        String url = "https://restful-booker.herokuapp.com/booking/7";

        Response response = given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        response.
                then().
                assertThat().
                body("firstname", equalTo("Mark")).
                body("lastname", equalTo("Ericsson")).
                body("totalprice", equalTo(629)).
                body("depositpaid", equalTo(true));

        System.out.println("=============================");

        response.
                then().
                assertThat().
                body("firstname", equalTo("Mark"),
                        "lastname", equalTo("Ericsson"),
                        "totalprice", equalTo(629),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2021-01-06"),
                        "bookingdates.checkout", equalTo("2021-01-15"));




    }
}
