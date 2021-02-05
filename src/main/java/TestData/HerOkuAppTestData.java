package TestData;

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
}
