package com.techproed;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBaseJsonPlaceHolder;

import static io.restassured.RestAssured.given;

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
             "id", 2);
        Response response = given().
                spec(spec01).
                when().
                get("/{todosPath}/{id}");
        response.prettyPrint();

        response.
                then().
                assertThat();
    }

}
