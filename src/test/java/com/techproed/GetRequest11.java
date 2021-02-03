package com.techproed;

import TestData.JsonPlaceHolderTestData;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBaseJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class GetRequest11 extends TestBaseJsonPlaceHolder {
    /*
    When
	 I send GET Request to jsonplaceholder api/todos/2
	 Status code: 200
	 "completed": is false
	 "userId": 1,
     "id": 2,
     "title": "quis ut nam facilis et officia qui",
     "completed": false
     header "via"= "1.1 vegur"
    */

    /*
    DE_Serialization: JSON datasini Java Objelerine (Map, List, List of Map, Set) islemidir.
    GSON dependency sini kullanarak De-Serialization ve Serialization yapilabilir.
     */

    @Test
    public void get01(){
    spec01.pathParams("todos","todos", "id",34);
    //Expected datayi olustur



        Response response = given().
                spec(spec01).
                when().
                get("/{todos}/{id}");
        response.prettyPrint();

        JsonPlaceHolderTestData expectedObj = new JsonPlaceHolderTestData();

        expectedObj.setUpData();
        //1.yol ile (body) assert edelim

        response.
                then().
                assertThat().
                statusCode((Integer)expectedDataMap.get("Status Code")).
                body("completed", Matchers.equalTo(expectedDataMap.get("completed")),
                        "title", Matchers.equalTo(expectedDataMap.get("title")),
                        "userId", Matchers.equalTo(expectedDataMap.get("userId")))
                .headers("Via", expectedDataMap.get("Via"),"Server", expectedDataMap.get("Server"));

        //2.Yol
        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedDataMap.get("Status Code"), response.getStatusCode());

        Assert.assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));

        Assert.assertEquals(expectedDataMap.get("completed"), actualDataMap.get("title"));

        Assert.assertEquals(expectedDataMap.get("Via"), response.getHeader("Via"));

        Assert.assertEquals(expectedDataMap.get("Server"), response.getHeader("Server"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), expectedDataMap.get("Status Code"));
        softAssert.assertEquals(actualDataMap.get("userId"), expectedDataMap.get("userId"));
        softAssert.assertEquals(actualDataMap.get("title"), expectedDataMap.get("completed"));
        softAssert.assertEquals(response.getHeader("Via"), expectedDataMap.get("Via"));
        softAssert.assertEquals(response.header("Server"), expectedDataMap.get("Server"));

        softAssert.assertAll();




    }
}
