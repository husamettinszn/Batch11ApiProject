package com.techproed;

import Utilities.JSonUtil;
import org.junit.Test;
import testbase.TestBaseHerOkuApp;

import java.util.Map;

public class GetRequestWithObjectMapper02Tekrar extends TestBaseHerOkuApp {
    /*
    {
    "firstname": "Jim",
    "lastname": "Jackson",
    "totalprice": 502,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2020-06-30",
        "checkout": "2020-11-25"
    }
     */
    @Test
    public void get01() {

        String expectedJson = " {\"firstname\": \"Jim\",\n" +
                "\"lastname\": \"Jackson\",\n" +
                "\"totalprice\": 502,\n" +
                "\"depositpaid\": true,\n" +
                "\"bookingdates\": {\n" +
                "\"checkin\": \"2020-06-30\",\n" +
                "\"checkout\": \"2020-11-25\"\n" +
                "}";

  //      Map<String, Object> expectedDataMap = JSonUtil.convertJsonToJava(expectedJson, Map.class);
    }
}
