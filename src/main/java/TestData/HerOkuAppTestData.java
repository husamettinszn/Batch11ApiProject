package TestData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    Map<String,String> bookingDatesMap = new HashMap<>();

    Map<String,Object> bookoingDetailsMap = new HashMap<>();

    public Map<String,Object> setUpData() {
        bookingDatesMap.put("checkin", "2020-02-27");
        bookingDatesMap.put("checkout","2020-12-16");

        bookoingDetailsMap.put("firstname", "Eric");
        bookoingDetailsMap.put("lastname", "Ericsson");
        bookoingDetailsMap.put("totalprice", 612);
        bookoingDetailsMap.put("depositpaid", true);
        bookoingDetailsMap.put("bookingdates", "Breakfast");

        return bookoingDetailsMap;
    }
    public JSONObject setUpDataJSONObject(){
        JSONObject bookingDatesJSONObject = new JSONObject();
        bookingDatesJSONObject.put("checkin","2020-09-09");
        bookingDatesJSONObject.put("checkout","2020-09-21");

        JSONObject bookingDetailsJSONObject = new JSONObject();
        bookingDetailsJSONObject.put("firstname","Selim");
        bookingDetailsJSONObject.put("lastname","Ak");
        bookingDetailsJSONObject.put("totalprice",11111);
        bookingDetailsJSONObject.put("depositpaid",true);
        bookingDetailsJSONObject.put("bookingdates",bookingDatesJSONObject);

        return  bookingDetailsJSONObject;
    }
}
