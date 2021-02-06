package com.techproed;

import TestData.DummyTestData;
import org.junit.Test;
import testbase.TestBaseDummy;

import javax.xml.ws.Response;
import java.util.Map;

public class GetRequest14 extends TestBaseDummy {
    /*
	 	When
	 		I send a request to http://dummy.restapiexample.com/api/v1/employees
	 	Then
	 		Status code is 200
	 		And the highest salary is 725000
	 		And the minimum age is 19
	 		And the second lowest salary is 675000
	*/
    @Test
    public void get01(){
        spec03.pathParam("empoloyessPath", "employees");

        DummyTestData expectedObj = new DummyTestData();
        Map<String, Integer> expectedDataMap = expectedObj.setUpData2();
        System.out.println(expectedDataMap);



    }
}
