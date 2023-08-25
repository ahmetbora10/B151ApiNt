package Homework;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class homework_4  extends ReqresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void homework4() {

        //Set the Url
        spec.pathParams("first", "unknown", "second", 3);

        //Set the  extected Data

        //sent the response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        //SoftAssert uc asamadan olusur.
        /*
        1)SoftAssert objesi olusturulur.
        2)Assertion yapilir
        3)assertAll methodu ile bitirilir.
         */
        //SoftAssert objesi olusturulur.
        SoftAssert softAssert = new SoftAssert();

        //Assertion yapilir.
        JsonPath json = response.jsonPath();
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.contentType(), "“application/json; charset=utf-8”");
        softAssert.assertEquals(json.getInt("data.id"), 4, "Id degeri dogru degil");

        //assertAll() methodu yazilir.
        softAssert.assertAll();

    }
}