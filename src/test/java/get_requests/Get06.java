package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import org.testng.asserts.SoftAssert;
public class Get06 extends HerokuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/22
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is “application/json”
    And
        Response body should be like;
      {
        "firstname": "John",
        "lastname": "Smith",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }

     */

    @Test
    public void test() {
        spec.pathParams("first","booking"
                ,"second",22);
        Response response = given().spec(spec).when().get("{first}/{second}");
        response.prettyPrint();


        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("John"),
                        "lastname",equalTo("Smith"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("Breakfast")
                );
        //***********2.YOL***************//
       JsonPath json = response.jsonPath();
       // System.out.println(json.getInt("totalprice"));
        assertEquals("John",json.getString("firstname"));
        assertEquals("Smith",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals(true,json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("Breakfast",json.getString("additionalneeds"));

        //******************3.YOL************************************//
// SoftAssertion 3 adımda yapılır: ---> testng poma eklenmeli

        //1.Adım Softassertion objesi oluşturulur
        SoftAssert softAssert = new SoftAssert();

        //2. Adım Assertion yapılır
        softAssert.assertEquals(json.getString("firstname") , "John");
        softAssert.assertEquals(json.getString("lastname") , "Smith");
        softAssert.assertEquals(json.getInt("totalprice") , 111);
        softAssert.assertEquals(json.getBoolean("depositpaid") , true);
        softAssert.assertEquals(json.getString("bookingdates.checkin") , "2018-01-01");
        softAssert.assertEquals(json.getString("bookingdates.checkout") , "2019-01-01");
        softAssert.assertEquals(json.getString("additionalneeds") , "Breakfast");

        //3. softAssert.assertAll anahtar kelimesiyle bitirilir
        softAssert.assertAll();
    }

}