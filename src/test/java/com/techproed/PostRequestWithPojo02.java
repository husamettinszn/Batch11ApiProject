package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import testbase.TestBaseHerOkuApp;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo02 extends TestBaseHerOkuApp {
    /*
	 	When
	 		I send POST Request to the Url https://restful-booker.herokuapp.com/booking
	 		with the request body {
								    "firstname": "Selim",
								    "lastname": "Ak",
								    "totalprice": 11111,
								    "depositpaid": true,
								    "bookingdates": {
								        "checkin": "2020-09-09",
								        "checkout": "2020-09-21"
								     }
								  }
	 	Then
	 		Status code is 200
	 		And response body should be like {
											    "bookingid": 11,
											    "booking": {
											        "firstname": "Selim",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        }
											    }
											 }
	 */
    @Test
    public void postWithPojo(){



    }

}
