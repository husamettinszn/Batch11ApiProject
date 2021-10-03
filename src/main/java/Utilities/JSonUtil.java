package Utilities;


import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSonUtil {
    // Object Mapper kulanılarak De-SErialization yapma metodu

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }
    // Metodumuzu olusturucaz-- Json Data sını  Java Object sine donusturucek.
    public static Map< String, Object> convertJsonToJava(String json) {
        Map<String, Object> javaResult = null;

        try {
            javaResult = mapper.readValue(json, HashMap.class);
        } catch (IOException e) {
            System.err.println("Json Datasini Java'ya dönüstüremedi"+ e.getMessage());
        }
        return javaResult;
    }


}




