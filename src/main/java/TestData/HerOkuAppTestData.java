package TestData;

import io.restassured.path.json.JsonPath;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    Map<String,String> bookingDatesMap = new HashMap<>();

    Map<String, Object> bookingDetailsMap = new HashMap<>();

    public  Map<String, Object> setUpData(){

        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        bookingDetailsMap.put("firstname","thomas");
        bookingDetailsMap.put("lastname", "Brown");
        bookingDetailsMap.put("totalprice", 111);
        bookingDetailsMap.put("depositpaid", false);
        bookingDetailsMap.put("bookingdates", bookingDatesMap);

        return bookingDetailsMap;
    }
    public JSONObject setUpDataJSONObject(){
        JSONObject bookingDatesJsonObject = new JSONObject();
        bookingDatesJsonObject.put("checkin", "2020-09-09");
        bookingDatesJsonObject.put("checkout", "2020-09-21");

        JSONObject bookingDetailsJSONObject = new JSONObject();
        bookingDetailsJSONObject.put("firstname","Selim");
        bookingDetailsJSONObject.put("lastname", "Ak");
        bookingDetailsJSONObject.put("totalprice", 1111);
        bookingDetailsJSONObject.put("depositpaid", true);
        bookingDetailsJSONObject.put("bookingdates", bookingDatesJsonObject);

        return bookingDetailsJSONObject;
    }


}
