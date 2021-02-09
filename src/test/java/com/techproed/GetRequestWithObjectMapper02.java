package com.techproed;

import Utilities.JSonUtil;
import org.junit.Test;
import testbase.TestBaseHerOkuApp;

import java.util.Map;

public class GetRequestWithObjectMapper02 extends TestBaseHerOkuApp {

    @Test
    public void get01(){
        spec02.pathParam("id",2);

        String expectedJson= "{\n" +
                "   \"firstname\": \"Mark\",\n" +
                "    \"lastname\": \"Ericsson\",\n" +
                "    \"totalprice\": 726,\n" +
                "   \"depositpaid\": true,\n" +
                "   \"bookingdates\": {\n" +
                "        \"checkin\": \"2015-08-07\",\n" +
                "       \"checkout\": \"2020-10-25\"\n" +
                "    }\n" +
                "  }";
        Map<String ,Object> expectedDataMap = JSonUtil.convertJsonToJava(expectedJson, Map.class);
    }
}
