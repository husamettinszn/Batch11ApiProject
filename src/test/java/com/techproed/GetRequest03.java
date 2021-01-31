package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest03 {
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
    public void get01(){
         String url ="https://restful-booker.herokuapp.com/booking/7";
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
/*
        response.
                then().
                assertThat().
                body("firstname", Matchers.equalTo("Mark")).
                body("lastname", Matchers.equalTo("Jones")).
                body("totalprice", Matchers.equalTo(975)).
                body("depositpaid", Matchers.equalTo(true)).
                body("bookingdates.checkin", Matchers.equalTo("2019-12-04")).
                body("bookingdatescheckout", Matchers.equalTo("2020-10-26")).
                body("additionalneeds", Matchers.equalTo("Breakfast"));
*/        response.
                then().
                assertThat().
                body("firstname", equalTo("Jim"),
                        "lastname", equalTo("Jones"),
                        "totalprice", equalTo(932),
                        "depositpaid",equalTo(false),
                        "bookingdates.checkin", equalTo("2018-02-17"),
                        "bookingdatescheckout", equalTo("2020-09-24"),
                        "additionalneeds", equalTo("Breakfast"));





    }




}
