package com.techproed;

import TestData.JsonPlaceHolderTestData;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PatchRequest01Tekrar extends TestBaseJsonPlaceHolder {

    @Test
    public void patch01(){
        spec01.pathParams("todosPath", "todos",
                "id", 198);

        JsonPlaceHolderTestData expectObj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData=expectObj.setUpPatchDataWithMap();
        System.out.println(expectedData);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedData).
                when().
                patch("/{todosPath}/{id}");
        response.prettyPrint();

        //Body expectedData
        response.
                then().
                assertThat().
                body("title", equalTo(expectedData.get("title")));
        //JsonPath expectedData
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("title"), jsonPath.getString("title"));


        //GSON expectedData
        Map<String, Object> actualGSON = response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("title"), actualGSON.get("title"));

    }
}
