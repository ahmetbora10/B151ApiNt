package Pratice01;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01_IDileContactGetirme {
    @Test
    public void Get() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contactList/64d7ec2e36c2810013fe7d97";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGQ3YzQ2ZjlhNjk0ZTAwMTMwZjFmZGUiLCJpYXQiOjE2OTE4NjM2MTB9.4pqCj-grB9KyFd5DwFtn56gQDEkKckY3iqgJUMulsME";

        Response response = given().
                auth().oauth2(token)
                .when()
                .get();
        response.prettyPrint();


    }
}