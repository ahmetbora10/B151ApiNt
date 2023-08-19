package get_requests;

import io.restassured.response.Response;
import org.junit.Test;
import org.junit.Assert;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Get2a {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status code 404 olmalı
        And
            Status Line "HTTP/1.1 404 Not Found" olmalı
        And
            Response body "Not Found" içermeli
        And
            Response body "TechProEd" içermemeli
        And
            Server değeri "Cowboy" olmalı
    */
    @Test
    public void get2a() {
      //  i- Set the URL = URL'i tanımla
     //   ii- Set the expected data = Beklenen dataları ayarla
     //   iii- Send the request and get the response = İsteği gönder ve cevabı al
        String Url ="https://restful-booker.herokuapp.com/booking/0";
        Response response=given().when().get(Url);
      //  iv- Do assertion = Doğrulama yap
        given().
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");


        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));
        assertEquals(response.asString(),"Not Found");

        assertEquals("Cowboy",response.header("Server"));

        response
                .then()
                .body(containsString("Not Found"))
                .body(not(containsString("TechProEd")));
    }
}
