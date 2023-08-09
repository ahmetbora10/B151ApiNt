package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;


public class GET01 {
   /*
    https://restful-booker.herokuapp.com/booking/55
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
    public void get01(){
//1- Set the URL = URL'i tanımla
        //*************1.Yontem****************//
String url="https://restful-booker.herokuapp.com/booking/55";//bu yontem fazla tercih edilmiyor.
        //************2.Yontem***************//
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/booking/55";

//2- Set the expected data = Beklenen dataları ayarla

//3- Send the request and get the response = İsteği gönder ve cevabı al
        Response response = given().when().get();
        response.prettyPrint();
     
//4- Do assertion = Doğrulama yap
        response.
                then() // Assertion metodu
                .statusCode(200) // Status kodun 200 olduğunu doğruladık
                .contentType("application/json") // Content type'ın "application/json" olduğunu doğruladık
                .statusLine("HTTP/1.1 200 OK"); // Status Line'ın "HTTP/1.1 200 OK" olduğunu doğruladık

        //given() kismi testin basinda request'in hazirlanmasi asamasidir. Testin temel kosullarinin hazirlanmasi
        //then(); yaptigimiz eylemleri sonuclarini kontrol etmek icin kullanilir



    }



}

