package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import groovy.xml.slurpersupport.NamespaceAwareHashMap;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {
      /*
    Given
        https://jsonplaceholder.typicode.com/todos/2
    When
        I send GET Request to the URL
    Then
        Status code is 200
        And "completed" is false
        And "userId" is 1
        And "title" is "quis ut nam facilis et officia qui"
        And header "Via" is "1.1 vegur"
        And header "Server" is "cloudflare"
        {
            "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
        }
    */

    @Test
    public void get08() {

        //set  the URL
        spec.pathParams("first","todos","second","2");

        // set the expected data
        JsonPlaceHolderTestData obj =new JsonPlaceHolderTestData();
     Map<String,Object> expedtedData = obj.expectedDataMapper(1,"quis ut nam facilis et officia qui",false);
     expedtedData.put("Via","1.1vegur");
     expedtedData.put("Server","cloudflare");
        //Send the request and get the response
        Response response=given(spec).when().get("{first}/{second}");
        response.prettyPrint();

     //do assertion
      Map<String,Object>  actualData= response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(expedtedData.get("completed"),actualData.get("completed"));
        assertEquals(expedtedData.get("userId"),actualData.get("userId"));
        assertEquals(expedtedData.get("title"),actualData.get("title"));
        assertEquals(expedtedData.get("Via"), response.header("Via"));
        assertEquals(expedtedData.get("Server"), response.header("Server"));
    }
}
