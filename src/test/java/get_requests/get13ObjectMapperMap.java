package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get13ObjectMapperMap extends JsonPlaceHolderBaseUrl {
    /*
    Given
        https://jsonplaceholder.typicode.com/todos/198
    When
        I send GET Request to the URL
    Then
        Status code is 200
    And response body is like
        {
            "userId": 10,
            "id": 198,
            "title": "quis eius est sint explicabo",
            "completed": true
        }
*/

    @Test
    public void get13ObjectMaperMap() {

        //Set the Url
        spec.pathParams("first", "todos", "second", "198");

        //SetbexpectedData

        String body = "{\n" +
                "\"userId\": 10,\n" +
                "\"id\": 198,\n" +
                "\"title\": \"quis eius est sint explicabo\",\n" +
                "\"completed\": true\n" +
                "}";
        Map<String,Object> expectedDAtaMap = ObjectMapperUtils.convertJsonToJava(body, HashMap.class);
        System.out.println("expectedDAtaMap = " + expectedDAtaMap);
        // Sent req and get Resp
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        // Do assertion
        Map<String, Object>  actualDataMap = ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedDAtaMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDAtaMap.get("userId"),actualDataMap.get("userId"));


    }
}