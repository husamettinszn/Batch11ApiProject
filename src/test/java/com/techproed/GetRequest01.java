package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {
       /*
       Given: Baslangıc icin gereklilikleri ifade eder.
       When: Kullanicinin aksiyonunu ifade eder.
       Then: Ciktilari ifade eder-- Assert ler genelde burada yapilir
       And: Herhangi iki coklu adim arasinda kullanilabilir.
        Positive Scenario
     When I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
     Then
     HTTP Status code should be 200
     And  Content type should be Json
     And  Status Line should be HTTP/1.1 200 OK
    */
    @Test
    public void get01(){
        //1.Url i olustur
        String url = "https://restful-booker.herokuapp.com/booking/3";
        //2.Beklenen datayi olustur
        //3.Request gonder --- Send botinuna basmak gibi
        //Response class
        Response response = given().
                            accept("application/json"). // accep type in Json formatinda olmasini istiyorum
                            when().get(url);
        response.prettyPrint();  //Gelen response u consolda gordum
        //4. Assert islemi.
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");
    }
}
