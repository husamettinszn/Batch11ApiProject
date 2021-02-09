package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.TodosPojo;
import testbase.TestBaseJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo01 extends TestBaseJsonPlaceHolder {
    /*
    Plain Old Java Objects
    Adimlar
    1)
     */
    /*
	 	When
	 		I send POST Request to the URL https://jsonplaceholder.typicode.com/todos
	 		with Post Request body  {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }
	 	Then
	 		Status code is 201
	 		And response body is like {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }

	 */
    @Test
    public void postPojo01(){
        spec01.pathParam("todosPath", "todos");

        TodosPojo expectedPojoData = new TodosPojo(21,201,"Tidy your room", false);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedPojoData).
                when().
                post("/{todosPath}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(201).
                body("userId", Matchers.equalTo(expectedPojoData.getUserId()),
                        "id", Matchers.equalTo(expectedPojoData.getId()),
                        "title", Matchers.equalTo(expectedPojoData.getTitle()),
                        "completed", Matchers.equalTo(expectedPojoData.isCompleted()));

        //2.Yol Jsonpath + Pojo
        //3. Yol Gson + Pojos
        TodosPojo actualTodosData=response.as(TodosPojo.class);
        System.out.println(actualTodosData);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTodosData.getUserId(), expectedPojoData.getUserId());
        softAssert.assertEquals(actualTodosData.getId(), expectedPojoData.getId());
        softAssert.assertEquals(actualTodosData.getTitle(), expectedPojoData.getTitle());
        softAssert.assertEquals(actualTodosData.isCompleted(), expectedPojoData.isCompleted());

        softAssert.assertAll();
    }
}
