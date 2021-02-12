package com.techproed;



import TestData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.Test;
import testbase.TestBaseDummy;

import java.util.*;

import static io.restassured.RestAssured.*;

public class GetRequest14 extends TestBaseDummy {

    /*
     When
         I send a request to http://dummy.restapiexample.com/api/v1/employees
     Then
         Status code is 200
         And the highest salary is 725000
         And the minimum age is 19
         And the second highest salary is 675000
*/

}