package com.techproed;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseHerOkuApp;

import static io.restassured.RestAssured.given;

public class GetRequest07Tekrar extends TestBaseHerOkuApp {
    /*
     * When I send a GET request to REST API URL
     * https://restful-booker.herokuapp.com/booking/5
     * Then HTTP Status Code should be 200
     * And response content type is “application/JSON”
     * And response body should be like;
     * {"firstname": "Sally",
     *   "lastname": "Ericsson",
     *   "totalprice": 111,
     *   "depositpaid": false,
     *   "bookingdates": { "checkin": "2017-05-23",
     *                     "checkout":"2019-07-02" }
     * }
     */
    @Test
    public void ge02(){
        spec02.pathParam("bookingid",5);

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

        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getString("firstname"));
        Assert.assertEquals("Firstname istenilen gibi degil", "Susan", jsonPath.getString("firstname"));

        System.out.println(jsonPath.getString("lastname"));
        Assert.assertEquals("Lastna,e istenildigi gibi degil", "Brown", jsonPath.getString("lastname" ));

        System.out.println(jsonPath.getInt("totalprice"));
        Assert.assertEquals("Totalprice istenildigi gibi degil", 857, jsonPath.getInt("totalprice"));

        System.out.println(jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals("Deposit paid beklenen gibi degil", true, jsonPath.getBoolean("depositpaid"));

        System.out.println(jsonPath.getString("Checkin Tarihi"+ jsonPath.getString("bookingdates.checkin")));
        Assert.assertEquals("Checkin tarihi beklenen gibi degil", "2019-01-01",jsonPath.getString("bookingdates.checkin"));

        System.out.println(jsonPath.getString("Checkout Tarihi"+ jsonPath.getString("bookingdates.checkout")));
        Assert.assertEquals("Checkout tarihi beklenen gibi degil", "2019-04-29",jsonPath.getString("bookingdates.checkout"));



    }
}
