package com.techproed;

import TestData.HerOkuAppTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseHerOkuApp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest13Tekrar extends TestBaseHerOkuApp {
      /*
     When
         I send GET Request to https://restful-booker.herokuapp.com/booking/1
     Then
         Response body should be like that;
         {
                "firstname": "Eric",
                 "lastname": "Ericsson",
                 "totalprice": 786,
                 "depositpaid": false,
                 "bookingdates": {
                     "checkin": "2016-06-11",
                     "checkout": "2020-10-16"
             }
        }

       */

    @Test
    public void get01(){
        spec02.pathParam("bookingId",1);

        HerOkuAppTestData expectedObj = new HerOkuAppTestData();
        System.out.println(expectedObj.setUpData());
        Map<String, Object> expectedDataMap = expectedObj.setUpData();
        System.out.println(expectedDataMap);

        Response response = given().
                spec(spec02).
                when().
                get("/{bookingId}");
        response.prettyPrint();

        Map<String, Object> actualDataMap = response.as(HashMap.class);

        System.out.println(actualDataMap);



        Assert.assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
        Assert.assertEquals(((Map)(expectedDataMap.get("bookingdates"))).get("checkin"), ((Map)(actualDataMap.get("bookingdates"))).get("checkin"));
        Assert.assertEquals( ((Map)(expectedDataMap.get("bookingdates"))).get("checkout"), ((Map)(actualDataMap.get("bookingdates"))).get("checkout"));
    }

}
