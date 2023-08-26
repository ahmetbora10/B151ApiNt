package gmBank;
import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.gmiBankPojos.CountryPojo;
import pojos.gmiBankPojos.StatePojo;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.ObjectMapperUtils.convertJsonToJava;
public class PostCountry extends GmiBankBaseUrl {
    /*
       https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1 dokümanını kullanarak en az 3 "state"
       içeren bir "country" oluşturan bir otomasyon testi yazınız.
       Not : Autherization için headers'a "Authorization" = ""Bearer abc123"  şeklinde Bearer token giriniz.
    */
        /*
            Given
                https://gmibank.com/api/tp-countries
            And
                {
                  "name": "Muz Cumhuriyeti",
                  "states": [
                    {
                      "id": 1,
                      "name": "Elma"
                    },
                    {
                      "id": 2,
                      "name": "Armut"
                    },
                    {
                      "id": 3,
                      "name": "Portakal"
                    }
                  ]
                }
            When
                Kullanıcı POST request gönderir
            Then
                Status Code = 201
            And
                Body:
                    {
                        "id": 191781,
                        "name": "Muz Cumhuriyeti",
                        "states": [
                            {
                                "id": 1,
                                "name": "Elma",
                                "tpcountry": null
                            },
                            {
                                "id": 2,
                                "name": "Armut",
                                "tpcountry": null
                            },
                            {
                                "id": 3,
                                "name": "Portakal",
                                "tpcountry": null
                            }
                        ]
                    }
         */
    @Test
    public void postCountry() {
        // Set the URl
        spec.pathParams("first", "api", "second", "tp-countries");
        // Set the expected data
        StatePojo state1 = new StatePojo(1, "Elma");
        StatePojo state2 = new StatePojo(2, "Armut");
        StatePojo state3 = new StatePojo(3, "Portakal");
        List<StatePojo> stateList = new ArrayList<>();
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);
        CountryPojo expectedData = new CountryPojo("Muz Cumhuriyeti", stateList);
        System.out.println(expectedData);
        // Send the request and get the response
        Response response = given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();
        // Do assertion
        CountryPojo actualData = convertJsonToJava(response.asString(), CountryPojo.class);
        System.out.println(actualData);
        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(state1.getId(), actualData.getStates().get(0).getId());
        assertEquals(state1.getName(), actualData.getStates().get(0).getName());
        assertEquals(state2.getId(), actualData.getStates().get(1).getId());
        assertEquals(state2.getName(), actualData.getStates().get(1).getName());
        assertEquals(state3.getId(), actualData.getStates().get(2).getId());
        assertEquals(state3.getName(), actualData.getStates().get(2).getName());

    }
}