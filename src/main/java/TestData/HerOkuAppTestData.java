package TestData;

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


}
