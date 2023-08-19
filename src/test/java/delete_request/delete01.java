package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.ObjectMapperUtils.convertJsonToJava;

public class delete01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
            I send DELETE Request to the Url
        Then
            Status code is 200
        And Response body is { }
    */

    @Test
    public void delete() {

        //set the Url

        spec.pathParams("frist","todos","second","198");

        //set the expectedData
        Map<String,String> expecteddata = new HashMap<>();

        //set the response

        Response response=given().when().delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String,String> actualData = convertJsonToJava(response.asString(), HashMap.class);
        assertEquals(200, response.statusCode());
        // 1.YOL
        assertEquals(expecteddata, actualData);
        // 2.YOL
        assertEquals(0, actualData.size());
        // 3.YOL
        assertTrue(actualData.isEmpty());


    }
}
