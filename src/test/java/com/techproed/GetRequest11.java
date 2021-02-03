package com.techproed;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
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
    spec01.pathParams("todos","todos", "id",2);
    //Expected datayi olustur
        HashMap<String,Object> expectedDataMap = new HashMap<>();

        expectedDataMap.put("Status Code", 200);
        expectedDataMap.put("userId", 1);
        expectedDataMap.put("title", "quis ut nam facilis et officia qui");
        expectedDataMap.put("completed", false);
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");


        Response response = given().
                spec(spec01).
                when().
                get("/{todos}/{id}");
        response.prettyPrint();

        //1.yol ile (body) assert edelim

        response.
                then().
                assertThat().
                statusCode(200).
                body("userId", Matchers.equalTo(1),
                        "id",Matchers.equalTo(2),
                        "title",Matchers.equalTo("quis ut nam facilis et officia qui"),
                        "completed", Matchers.equalTo(false));



    }
}
