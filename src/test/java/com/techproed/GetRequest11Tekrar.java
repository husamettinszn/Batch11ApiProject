package com.techproed;

import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBaseJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest11Tekrar extends TestBaseJsonPlaceHolder {
        /* When
     I send GET Request to jsonplaceholder api/todos/2
     Status code: 200
             "completed": is false
             "title  is   "quis ut nam facilis et officia qui"
             "userId"  1
     header "Via"   "1.1 vegur"
     header "Server"  "cloudflare"

     De-Serialization: JSON datasını Java Objelerine (Map,List,List of Map, Set) cevirme islemidir.
     GSON dependency sini kullanarak De-SErialization ve Serialization yapılabilir.
     ,
          */
    @Test
    public void get01(){
     spec01.pathParams("todosPath","todos",
             "id", 198);
     //Expected datayi Map'a atalim

        Response response = given().
                spec(spec01).
                when().
                get("/{todosPath}/{id}");
        response.prettyPrint();

       JsonPlaceHolderTestData expectedObj1 = new JsonPlaceHolderTestData();

       HashMap<String, Object> expectedDataMap = expectedObj1.setUpData();

        //1.Yol body ile
        response.
                then().
                assertThat().
                statusCode((Integer)expectedDataMap.get("Status Code")).
                contentType(ContentType.JSON).
                body("userId", equalTo(expectedDataMap.get("userId")),
                        "title", equalTo(expectedDataMap.get("title")),
                        "completed", equalTo(expectedDataMap.get("completed"))).
                headers("Via", expectedDataMap.get("Via"), "Server", expectedDataMap.get("Server"));

        //2.Yol DE-Serialization
        //response u HashMap'a cevirelim
        HashMap<String, Object> actualDataMap= response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedDataMap.get("Status Code"), response.statusCode());
        Assert.assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        Assert.assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));
        Assert.assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
        Assert.assertEquals(expectedDataMap.get("Via"), response.getHeader("Via"));
        Assert.assertEquals(expectedDataMap.get("Server"), response.getHeader("Server"));

        //3. Yol SoftAssert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), expectedDataMap.get("Status Code"));
        softAssert.assertEquals(actualDataMap.get("userId"), expectedDataMap.get("userId"));
        softAssert.assertEquals(actualDataMap.get("completed"), expectedDataMap.get("completed"));
        softAssert.assertEquals(actualDataMap.get("title"), expectedDataMap.get("title"));
        softAssert.assertEquals(response.getHeader("Via"), expectedDataMap.get("Via"));
        softAssert.assertEquals(response.getHeader("Server"), expectedDataMap.get("Server"));

        softAssert.assertAll();











    }

}
