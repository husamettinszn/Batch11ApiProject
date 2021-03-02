package TestData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyTestData {

    public List<Map<String, Object>> expectedDataList = new ArrayList<>();

    public List<Map<String, Object>> setUpData() {
        HashMap<String, Object> expectedMap1 = new HashMap<>();
        HashMap<String, Object> expectedMap2 = new HashMap<>();
        HashMap<String, Object> expectedMap3 = new HashMap<>();
        HashMap<String, Object> expectedMap4 = new HashMap<>();
        HashMap<String, Object> expectedMap5 = new HashMap<>();
        HashMap<String, Object> expectedMap6 = new HashMap<>();
 /*
      When
      I send get request to yje URL http://dummy.restapiexample.com/api/v1/employees
      Then
      Status Code 200
      5. calisanin ismi "Airi Satou"
      Calisan sayisi 24
      Sondan ikinci calisanin maasi "106450"
      40,21 ve 19 yaslarinda calisanlar olup olmadıgı
      11. calisanin bilgileri {              "id": "11",
                                            "employee_name": "Jena Gaines",
                                            "employee_salary": "90560",
                                            "employee_age": "30",
                                            "profile_image": ""
                                             }
                                            seklinde mi
                                            Assert edelim.
    ​
     */
        expectedMap1.put("Status Code", 200);
        expectedDataList.add(expectedMap1);

        expectedMap2.put("SelectedEmployeeName", "Airi Satou");
        expectedDataList.add(expectedMap2);

        expectedMap3.put("NumOfEmployees", 24);
        expectedDataList.add(expectedMap3);

        expectedMap4.put("SelectedSalary", "106450");
        expectedDataList.add(expectedMap4);

        List<String> agelist = new ArrayList<>();
        agelist.add("40");
        agelist.add("19");
        agelist.add("23");

        expectedMap5.put("MulipleAges", agelist);
        expectedDataList.add(expectedMap5);


        Map<String, String> empDetailsMap = new HashMap<>();
        empDetailsMap.put("id", "11");
        empDetailsMap.put("employee_name", "Jena Gaines");
        empDetailsMap.put("employee_salary", "90560");
        empDetailsMap.put("employee_age", "30");
        empDetailsMap.put("profile_image", "");

        expectedMap6.put("AllDetailsAboutEmployee", empDetailsMap);
        expectedDataList.add(expectedMap6);

        return expectedDataList;
    }

    public Map<String, Integer> setUPData2() {
        Map<String, Integer> expectedDataMap = new HashMap<>();
        expectedDataMap.put("Status code", 200);
        expectedDataMap.put("highest_salary", 725000);
        expectedDataMap.put("minimum_age", 19);
        expectedDataMap.put("second_highest_salary", 675000);
        expectedDataMap.put("highest_age", 66);

        return expectedDataMap;
    }

    public Map<String, String> setUpData3() {

        Map<String, String> reqBodyMap = new HashMap<>();
        reqBodyMap.put("name", "Ahmet Aksoy");
        reqBodyMap.put("salary", "1000");
        reqBodyMap.put("age", "18");
        reqBodyMap.put("profile_image", "");

        return reqBodyMap;
    }

    public Map<String, String> setUpMessageWithMap() {
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("status", "success");
        messageMap.put("message", "Successfully! Record has been added.");

        return messageMap;
    }

    public JSONObject setUpPostWithJSONOBJECT() {
        JSONObject reqBodyJSONObject = new JSONObject();
        reqBodyJSONObject.put("name", "Ahmet Aksoy");
        reqBodyJSONObject.put("salary", "1000");
        reqBodyJSONObject.put("age", "18");
        reqBodyJSONObject.put("profil_image", "");

        return reqBodyJSONObject;
    }

    public JSONObject setUpMessageWithJSONOBJECT() {
        JSONObject messageJsonObject = new JSONObject();
        messageJsonObject.put("status", "success");
        messageJsonObject.put("message", "Successfully! Record has been added.");

        return messageJsonObject;

    }
}