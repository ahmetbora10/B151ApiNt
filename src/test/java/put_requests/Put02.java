package put_requests;

import pojos.DummyDataPojo;
import pojos.DummyResponsePojo;
import base_urls.DummyResApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyResApiBaseUrl {
    /*
    Given
    https://dummy.restapiexample.com/api/v1/update/21
And
    Request body: {
                    "employee_name": "Ali Can",
                    "employee_salary": 111111,
                    "employee_age": 23,
                    "profile_image": "Perfect image"
                }
When
    User sends PUT request
Then
    Status code should be 200
And
    Response body should be like the following:
                {
                    "status": "success"
                    "data": {
                        "employee_name": "Ali Can"
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                    },
                    "message": "Successfully! Record has been updated."
                }
     */

    @Test
    public void put02() {

        //set the url
        spec.pathParams("first","update","second","21");

        //set the  expectedData
        DummyDataPojo payload = new DummyDataPojo("Ali Can",111111,23,"Perfect image");
        System.out.println("payload =" + payload);

        // Send the request and get the respons
        Response response = given(spec).body(payload).when().get("{first}/{second}");
        response.prettyPrint();
// Do assertion
        DummyResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyResponsePojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(payload.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(payload.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(payload.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(payload.getProfile_image(),actualData.getData().getProfile_image());


    }
}
