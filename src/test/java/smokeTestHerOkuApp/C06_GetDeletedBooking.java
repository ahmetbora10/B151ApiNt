package smokeTestHerOkuApp;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C06_GetDeletedBooking extends HerokuAppBaseUrl {
    /*

        Given
                https://restful-booker.herokuapp.com/booking/:id
        When
                Send Get request
        Then
                Statuscode 404
        And
                Body: Not Found"
"
         */

    @Test
    public void get() {
        //set the Url
        spec.pathParams("first","booking","second","bookingId");
        //set expected data
        String expectedData ="Not Found";
        // Sent req and get resp
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do aseertion
        assertEquals(404,response.statusCode());
        assertEquals(expectedData,response.asString());

    }
}
