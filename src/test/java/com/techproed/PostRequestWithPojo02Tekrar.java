package com.techproed;



import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
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
        BookingDatesPojo bookingDates = new BookingDatesPojo("2020-09-09","2020-09-21");
        BookingPojo expectedBookingPojo = new BookingPojo("Selim", "Ak", 1111, true, bookingDates);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec02).
                body(expectedBookingPojo).
                when().
                post();
        response.prettyPrint();

        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);
        System.out.println(actualData);

        Assert.assertEquals(expectedBookingPojo.getFirstname(), actualData.getBooking().getFirstname());
        Assert.assertEquals(expectedBookingPojo.getLastname(), actualData.getBooking().getLastname());
        Assert.assertEquals(expectedBookingPojo.getTotalprice(),actualData.getBooking().getTotalprice());
        Assert.assertEquals(expectedBookingPojo.isDepositpaid(), actualData.getBooking().isDepositpaid());
        Assert.assertEquals(expectedBookingPojo.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expectedBookingPojo.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());



    }
}
