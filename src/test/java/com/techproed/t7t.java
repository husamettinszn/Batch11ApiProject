package com.techproed;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseHerOkuApp;

import static io.restassured.RestAssured.*;

public class t7t extends TestBaseHerOkuApp {
    /*
     * When I send a GET request to REST API URL
     * https://restful-booker.herokuapp.com/booking/5
     * Then HTTP Status Code should be 200
     * And response content type is “application/JSON”
     * And response body should be like;
     * {"firstname": Sally,
     *   "lastname": "Smith",
     *   "totalprice": 789,
     *   "depositpaid": false,
     *   "bookingdates": { "checkin": "2017-12-11",
     *                     "checkout":"2020-02-20" }
     * }
     */
    @Test
    public void get01(){
        // Url olusturmak
        spec02.pathParam("bookingid",5);

        //Request olusturmak
        Response response = given().
                spec(spec02).
                when().
                get("/{bookingid}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
        //jsonPath ();
        // response un icerisinde hareket edebilmezi ve degerlere ulasabilmemizi saglar.

        JsonPath jsonPath = response.jsonPath();
        System.out.println("First name "+ jsonPath.getString("firstname"));
        Assert.assertEquals("Firstname istenilen gibi degil","Eric",jsonPath.getString("firstname"));
        System.out.println("Last name "+jsonPath.getString("lastname"));
        Assert.assertEquals("Lastname istenilen gibi degil","Wilson",jsonPath.getString("lastname"));
        System.out.println("Total price "+jsonPath.getInt("totalprice"));
        Assert.assertEquals("Totalprice istenilen gibi degil ",276,jsonPath.getInt("totalprice"));
        System.out.println("DEposit paid "+ jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals("Deposit paid beklenen gibi degil ",true,jsonPath.getBoolean("depositpaid"));
        System.out.println("Check in tarihi "+ jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals("Check in tarihi istenilen gibi degil ","2016-08-02",jsonPath.getString("bookingdates.checkin"));
        System.out.println("Check out tarihi "+ jsonPath.getString("bookingdates.checkout"));
        Assert.assertEquals("Check out tarihi istenilen gibi degil ","2020-01-03",jsonPath.getString("bookingdates.checkout"));


        System.out.println("==========");

        /*
         * When I send a GET request to REST API URL
         * https://restful-booker.herokuapp.com/booking/5
         * Then HTTP Status Code should be 200
         * And response content type is “application/JSON”
         * And response body should be like;
         * {"firstname": Sally,
         *   "lastname": "Smith",
         *   "totalprice": 789,
         *   "depositpaid": false,
         *   "bookingdates": { "checkin": "2017-12-11",
         *                     "checkout":"2020-02-20" }
         * }
         */
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Eric"),
                        "lastname", Matchers.equalTo("Smith"),
                        "totalprice", Matchers.equalTo(789),
                        "depositpaid", Matchers.equalTo(false),
                        "bookongdates.checkin", Matchers.equalTo("2017-12-11"),
                        "bookingdates.checkout", Matchers.equalTo("2020-02-20"));
    }

}





