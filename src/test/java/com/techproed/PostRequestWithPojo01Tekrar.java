package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.TodosPojo;
import testbase.TestBaseJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo01Tekrar extends TestBaseJsonPlaceHolder {

    @Test
    public void postPojo01(){
        spec01.pathParam("todosPath", "todos");
        TodosPojo expectedPojo= new TodosPojo(21,201, "Tidy your room", false);
        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedPojo).
                when().
                post("/{todosPath}");
        response.prettyPrint();

        //body Pojo
        response.
                then().
                    assertThat().
                        statusCode(201).
                            body("userId", Matchers.equalTo(expectedPojo.getUserId()),
                                    "id",Matchers.equalTo(expectedPojo.getId()),
                                    "title", Matchers.equalTo(expectedPojo.getTitle()),
                                    "completed", Matchers.equalTo(expectedPojo.isCompleted()));

        //JsonPath ve Pojos
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(expectedPojo.getUserId(), jsonPath.getInt("userId"));
        Assert.assertEquals(expectedPojo.getId(), jsonPath.getInt("id"));
        Assert.assertEquals(expectedPojo.getTitle(), jsonPath.getString("title"));
        Assert.assertEquals(expectedPojo.isCompleted(), jsonPath.getBoolean("completed"));

        //GSON ve Pojos (De_Serialization

        TodosPojo actualTodosData = response.as(TodosPojo.class);
        System.out.println(actualTodosData);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTodosData.getUserId(), expectedPojo.getUserId());
        softAssert.assertEquals(actualTodosData.getId(), expectedPojo.getId());
        softAssert.assertEquals(actualTodosData.getTitle(), expectedPojo.getTitle());
        softAssert.assertEquals(actualTodosData.isCompleted(), expectedPojo.isCompleted());


        softAssert.assertAll();











    }


}
