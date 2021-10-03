package com.techproed;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Data;
import pojos.EmployeesExpectedPojo;
import testbase.TestBaseDummy;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithPojoTekrar extends TestBaseDummy {
    /*
         When
             I send GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/1
         Then
             Status code is 200
             And response body is like {
                                        "status": "success",
                                        "data": {
                                            "id": 1,
                                            "employee_name": "Tiger Nixon",
                                            "employee_salary": 320800,
                                            "employee_age": 61,
                                            "profile_image": ""
                                        },
                                        "message": "Successfully! Record has been fetched."
                                       }

     */
    @Test
    public void getPojo(){
        spec03.pathParams("employeePath", "employee",
                "id", 1);

        Data data = new Data(1, "Tiger Nixon", 320800, 61, "");
        EmployeesExpectedPojo employeesExpectedPojo = new EmployeesExpectedPojo("success", data, "Successfully! Record has been fetched.");

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec03).
                when().
                get("/{employeePath}/{id}");
        response.prettyPrint();

        //De-Serialization
        EmployeesExpectedPojo actualDataPojo = response.as(EmployeesExpectedPojo.class);
        System.out.println(actualDataPojo);

        Assert.assertEquals(employeesExpectedPojo.getStatus(), actualDataPojo.getStatus());
        Assert.assertEquals(employeesExpectedPojo.getData().getId(), actualDataPojo.getData().getId());
        Assert.assertEquals(employeesExpectedPojo.getData().getEmployee_name(), actualDataPojo.getData().getEmployee_name());
        Assert.assertEquals(employeesExpectedPojo.getData().getEmployee_salary(), actualDataPojo.getData().getEmployee_salary());
        Assert.assertEquals(employeesExpectedPojo.getData().getEmployee_age(), actualDataPojo.getData().getEmployee_age());
        Assert.assertEquals(employeesExpectedPojo.getData().getProfile_image(), actualDataPojo.getData().getProfile_image());
        Assert.assertEquals(employeesExpectedPojo.getMessage(), actualDataPojo.getMessage());

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(employeesExpectedPojo.getData().getEmployee_name(), jsonPath.getString("data.employee_name"));
        Assert.assertEquals(employeesExpectedPojo.getData().getEmployee_age(), jsonPath.getInt("data.employee_age"));
        Assert.assertEquals(employeesExpectedPojo.getData().getEmployee_salary(), jsonPath.getInt("data.employee_salary"));
        Assert.assertEquals(employeesExpectedPojo.getData().getProfile_image(), jsonPath.getString("data.profile_image"));
        Assert.assertEquals(employeesExpectedPojo.getStatus(), jsonPath.getString("status"));
        Assert.assertEquals(employeesExpectedPojo.getMessage(), jsonPath.getString("message"));

        System.out.println("======================================");

        //Serialization
        //1
        Gson gson = new Gson();
        //2
        String jsonFromJavaObject = gson.toJson(employeesExpectedPojo);
        System.out.println(jsonFromJavaObject);

    }
}
