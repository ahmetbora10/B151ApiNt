package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get1a {
    /*
   https://restful-booker.herokuapp.com/booking/1
   When
   Kullanıcı URL'e bir GET request gönderir
   Then
   HTTP Status Code 200 olmalı
           And
   Content Type "application/json" olmalı
           And
   Status Line "HTTP/1.1 200 OK" olmalı
   */
    @Test
public void Get01(){

       // i- Set the URL = URL'i tanımla
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
          RestAssured.basePath="/booking/1";

        //ii- Set the expected data = Beklenen dataları ayarla

        //iii- Send the request and get the response = İsteği gönder ve cevabı al
        Response response =given().when().get();
         response.prettyPrint();
        //iv- Do assertion = Doğrulama yap
        response.
                then().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");
    }
}
