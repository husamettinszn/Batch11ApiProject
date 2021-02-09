package com.techproed;

import Utilities.JSonUtil;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseDummy;
import testbase.TestBaseHerOkuApp;
import testbase.TestBaseJsonPlaceHolder;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithObjectMapper01 extends TestBaseJsonPlaceHolder {


    @Test
    public  void get01(){
        spec01.pathParams("todosPath", "todos",
                "id", 198);

        String expectedJson = "{\n" +
                " \"userId\": 10,\n" +
                "\"id\": 198,\n" +
                "\"title\": \"quis eius est sint explicabo\",\n" +
                " \"completed\": true\n" +
                " }";
        Map<String ,Object> expectedMap = JSonUtil.convertJsonToJava(expectedJson);
        System.out.println(expectedMap);

        Response response = given().
                spec(spec01).
                when().
                get("/{todosPath}/{id}");
        response.prettyPrint();

        Map<String, Object> actualMap = JSonUtil.convertJsonToJava(response.asString());
        System.out.println(actualMap);
        Assert.assertEquals(expectedMap.get("userId"), actualMap.get("userId"));
        Assert.assertEquals(expectedMap.get("completed"), actualMap.get("completed"));
        Assert.assertEquals(expectedMap.get("title"), actualMap.get("title"));
        Assert.assertEquals(expectedMap.get("id"), actualMap.get("id"));



    }
}
