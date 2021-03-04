package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDates;
import pojos.BookingPojo;
import testbase.TestBaseHerOkuApp;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo02Tekrar extends TestBaseHerOkuApp {
   /* {
        "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
        "checkin": "2020-09-09",
                "checkout": "2020-09-21"
    }
    }

    */
    @Test
    public void postPojo02(){

        spec02.pathParam("bookingPath", "booking");

        BookingDates bookingDates = new BookingDates("2020-09-09", "2020-09-21");

        BookingPojo expectedBooking = new BookingPojo("Selim", "Ak", 1111, true, bookingDates);

        Response response = given().
                contentType(ContentType.JSON).
                auth().
                basic("admin", "password123").
                spec(spec02).
                body(expectedBooking).
                when().
                post("/{bookingPath}");
        response.prettyPrint();



    }
}
