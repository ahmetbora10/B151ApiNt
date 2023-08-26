package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {
    protected RequestSpecification spec;

    @Before
    public void Setup(){
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjk1NjM3MTA1fQ.7knDIePz7qb1EgFfZ8Kwj6OgDU9qmOHrmGBTSoApgEoR1j4EZUjMKvbXCNqzkybFlFmqy6xj-_3bWcOsWb7Y3Q")
                .setBaseUri("https://gmibank.com").build();
    }
}

