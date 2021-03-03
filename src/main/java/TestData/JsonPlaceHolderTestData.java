package TestData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public HashMap<String, Object> expectedDataMap;

    public HashMap<String, Object> setUpData(){
        expectedDataMap= new HashMap<String , Object>();

        expectedDataMap.put("Status Code", 200);
        expectedDataMap.put("userId", 10);
        expectedDataMap.put("title", "quis eius est sint explicabo");
        expectedDataMap.put("completed", true);
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");

        return expectedDataMap;
    }
    public JSONObject setUpPostRequestByJSONObject(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 55);
        requestBody.put("title", "Tidy your room");
        requestBody.put("completed", false);

        return requestBody;
    }
    public JSONObject setUpPutRequestByJSONObject(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 21);
        requestBody.put("title", "Wash the dishes");
        requestBody.put("completed", false);

        return requestBody;
    }
    public Map<String, Object> setUpPatchDataWithMap(){
        Map<String, Object> patchReqBodyMap = new HashMap<>();
        patchReqBodyMap.put("title", "I love API");
        return patchReqBodyMap;
    }

}



