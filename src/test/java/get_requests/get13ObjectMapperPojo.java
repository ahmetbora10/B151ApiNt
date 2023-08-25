package get_requests;

import pojos.JsonPlaceHolderPojo;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class get13ObjectMapperPojo extends JsonPlaceHolderBaseUrl {
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
    public void get13() {
        //Set the Url
        spec.pathParams("first","todos","second","98");
        //Set the expected Data
        String body = "{\n" +
                "\"userId\": 10,\n" +
                "\"id\": 198,\n" +
                "\"title\": \"quis eius est sint explicabo\",\n" +
                "\"completed\": true\n" +
                "}";
    JsonPlaceHolderPojo expectedDataPojo = ObjectMapperUtils.convertJsonToJava( body,JsonPlaceHolderPojo.class);

        System.out.println("expectedDataPojo" + expectedDataPojo);

        //Send the request and get the response

        Response response =given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //do assertion



    }
}
