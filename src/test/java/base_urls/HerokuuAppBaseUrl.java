package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
public class HerokuuAppBaseUrl {
    protected  RequestSpecification spec;
    @Before
    public void Setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
    // tekrarlı olarak kullanılan değerlerler burada yazılır
}
