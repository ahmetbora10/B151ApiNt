package smokeTestHerOkuApp;
import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static smokeTestHerOkuApp.C01_CreateBooking.bookingId;

public class C05_DeleteBooking extends HerokuAppBaseUrl {
  /* /*
    Given
        https://restful-booker.herokuapp.com/booking/1
    When
        sent delete request
    Then
        StatusCode 201
    And
        body : Created
     */

    @Test
    public void delete() {
        // Set Url
        spec.pathParams("first", "booking", "second", bookingId);
        // Set expected data
        String expectedData = "Created";
        // Send req and get resp
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();
        // Do assertion
        assertEquals(201, response.statusCode());
        assertEquals(expectedData, response.asString());
    }
}