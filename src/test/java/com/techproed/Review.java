package com.techproed;

public class Review {

    /*
    A) Assertion icin kac farkli yontem vardir
        1) Body Matchers --- Hard Assert
        2) JsonPath --- Nesne olustuduk, json uzerinden respons a ulastik
        3) GSON -- De-Serialization
        4) POJO -- Class lar olusturduk--
        5) Object Mapper

     B) ReqBody -- Patch, Post; Put ExpectedData--- Get ve Delete
        ReqBody ve ExpectedData'yi hangi sekillerde olusturduk
        Data Collections
        JSONObject
        ObjectMapper
        POJO

     C) TestBase classlarimiz
        RequestSpecification Interface'inden nesne urettik
        RequestBuilder methodunu kullandik
        build() methodunu kullandik
        Before Annotation'ini kullandik-- JUnitteki Test methodunu kullandik
        Test'ten once spec leri olusturmak icin Befor'u kullandik

        spec.params("";""); -- URL i kullandik
        query params varsa (/todos?esefdm,ds=ssds)
        spec.pathparams().queryparams();

        Hard Assertion-- assertEquals, asserttrue, assertFalse
        Hard Assertion-- body assertEquals, assetTrue, assertFalse

        Neleri assert ettik?
        status code, content type, expected data ve respons u assert ettik



     */

}
