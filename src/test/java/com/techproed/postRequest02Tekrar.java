package com.techproed;

import TestData.HerOkuAppTestData;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.AssertionSupport;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBaseHerOkuApp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class postRequest02Tekrar extends TestBaseHerOkuApp {

    @Test
    public void post02(){

        HerOkuAppTestData expectedObj = new HerOkuAppTestData();
        JSONObject expectedBodyData = expectedObj.setUpDataJSONObject();
        System.out.println(expectedBodyData);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec02).
                auth().
                basic("admin", "password123").
                body(expectedBodyData.toString()).
                when().post();
        response.prettyPrint();

        //Body methodu
        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200).
                body("booking.firstname", Matchers.equalTo(expectedBodyData.getString("firstname")),
                        "booking.lastname",Matchers.equalTo(expectedBodyData.getString("lastname")),
                "booking.totalprice", Matchers.equalTo(expectedBodyData.getInt("totalprice")),
                        "booking.depositpaid", Matchers.equalTo(expectedBodyData.getBoolean("depositpaid")),
                        "booking.bookingdates.checkin", Matchers.equalTo(expectedBodyData.getJSONObject("bookingdates").getString("checkin")),
                        "booking.bookingdates.checkout", Matchers.equalTo(expectedBodyData.getJSONObject("bookingdates").getString("checkout")));

        //HardAssert
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expectedBodyData.getString("firstname"), jsonPath.getString("booking.firstname"));
        Assert.assertEquals(expectedBodyData.getString("lastname"), jsonPath.getString("booking.lastname"));
        Assert.assertEquals(expectedBodyData.getInt("totalprice"), jsonPath.getInt("booking.totalprice"));
        Assert.assertEquals(expectedBodyData.getBoolean("depositpaid"), jsonPath.getBoolean("booking.depositpaid"));
        Assert.assertEquals(expectedBodyData.getJSONObject("bookingdates").getString("checkin"), jsonPath.getString("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedBodyData.getJSONObject("bookingdates").getString("checkout"), jsonPath.getString("booking.bookingdates.checkout"), jsonPath.getString("booking.bookingdates.checkout"));

        //De_Serialization  JSONObject ve GSON ile yapalim
        Map<String, Object> actualMap = response.as(HashMap.class);
        System.out.println(actualMap);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(((Map)actualMap.get("booking")).get("firstname"), expectedBodyData.getString("firstname"));
        softAssert.assertEquals(((Map)actualMap.get("booking")).get("lastname"), expectedBodyData.getString("lastname"));
        softAssert.assertEquals(((Map) actualMap.get("booking")).get("totalprice"), expectedBodyData.getInt("totalprice"));
        softAssert.assertEquals(((Map) actualMap.get("booking")).get("depositpaid"), expectedBodyData.getBoolean("depositpaid"));
        softAssert.assertEquals(((Map)((Map)actualMap.get("booking")).get("bookingdates")).get("checkin"), expectedBodyData.getJSONObject("bookingdates").getString("checkin"));
        softAssert.assertEquals(((Map)((Map)actualMap.get("booking")).get("bookingdates")).get("checkout"), expectedBodyData.getJSONObject("bookingdates").getString("checkout"));

        softAssert.assertAll();


    }
}
