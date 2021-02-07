package TestData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {


    public HashMap<String,Object> expectedDataMap ;

    public HashMap<String,Object> setUpData(){

        expectedDataMap.put("Status Code",200);
        expectedDataMap.put("userId",10);
        expectedDataMap.put("title","quis eius est sint explicabo");
        expectedDataMap.put("completed",true);
        expectedDataMap.put("Via","1.1 vegur");
        expectedDataMap.put("Server","cloudflare");
        return expectedDataMap;

    }
    /*
  {
                                  "userId": 55,
                                  "title": "Tidy your room",
                                  "completed": false
                                 }
   */
    public JSONObject setUpPostRequestByJSONObject(){
        JSONObject reqBody = new JSONObject();
        reqBody.put("userId",55);
        reqBody.put("title","Tidy your room");
        reqBody.put("completed",false);
        return reqBody ;
    }
    public Map<String, Object> setUpPutDataByUsingMap(){

        Map<String, Object> putReqBodyMap = new HashMap<String, Object>();

        putReqBodyMap.put("userId", 21);
        putReqBodyMap.put("title", "Wash the dishes");
        putReqBodyMap.put("completed", false);

        return putReqBodyMap;
    }
    public Map<String, Object> setUpPatchDataByUsingMap(){

        Map<String, Object> patchReqBodyMap = new HashMap<String, Object>();

        patchReqBodyMap.put("title", "Tidy your room");

        return patchReqBodyMap;
    }

}





