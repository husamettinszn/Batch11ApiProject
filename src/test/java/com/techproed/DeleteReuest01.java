package com.techproed;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBaseDummy;

public class DeleteReuest01 extends TestBaseDummy {
    /*
	 	When
	 		I send DELETE Request to the Url http://dummy.restapiexample.com/api/v1/delete/2
	 	Then
		 	Status code is 200
		 	And Response body is {
								    "status": "success",
								    "data": "2",
								    "message": "Successfully! Record has been deleted"
								 }
	*/
    @Test
    public void delete01(){
        spec03.pathParams("deletePath", "delete",
                "id", 2);

        
        Response response =
    }
}
