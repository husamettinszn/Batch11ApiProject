package com.techproed;

import TestData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.junit.Test;
import testbase.TestBaseDummy;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteRequest01Tekrar extends TestBaseDummy {

    @Test
    public void delete01(){
        spec03.pathParams("deletePath", "delete",
                "id", 2);

        DummyTestData expectedObj = new DummyTestData();
        Map<String, Object> expectedDataMap = expectedObj.setUpExpectedDeleteWithMap();
        System.out.println(expectedDataMap);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec03).
                when().
                delete("/{deletePath}/{id}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                body("data", equalTo(expectedDataMap.get("data")),
                        "status", equalTo(expectedDataMap.get("status"))
                );




    }
}
