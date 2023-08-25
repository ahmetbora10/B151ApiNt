package Homework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class homework_1  {
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
/* ilk once given kisminda yer alan kodun calisip calismadigini  postmande kontrl ediyoruz.
Sonra gorevi anliyoruz.https://regers.in/api/users/3 url adresine bir  get request gondermemizi ve bu bub status codunun 200
Content Type kisminin JSON ve status code line kisminin HTTP/1.1. 200 ok olmasi isteniyor.
Biz yappacagimiz islemler 4 asamada yapiyoruz.
//1- Set the URL = URL'i tanımla
//2- Set the expected data = Beklenen dataları ayarla
//3- Send the request and get the response = İsteği gönder ve cevabı al
//4- Do assertion = Doğrulama yap
 */
    @Test
    public void homework1() {

        //1- Set the URL = URL'i tanımla
        //1.Yol
        String url =" https://reqres.in/api/users/3";//Bu yöntem tercih edilmez


        //2.Yol
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="/api/users/3";


        //2- Set the expected data = Beklenen dataları ayarla

        //3- Send the request and get the response = İsteği gönder ve cevabı al
     //  Response response = given().when().get() Burada kullancagimiz sntex bu Url yi Stringe esayn ettigimiz zaman sintex bos kullaniriz
    Response response =given().when().get();
    response.prettyPrint();//resoponse prettyPrint ile yazdirilir.

        //4- Do assertion = Doğrulama yap
        //Burada given().get().Then() sintexini kullanip akisa sunacagiz.
        given()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");


    }
}


