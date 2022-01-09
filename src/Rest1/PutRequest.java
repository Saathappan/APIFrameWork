package Rest1;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
public class PutRequest {
	private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"baz\",\n" +
            "  \"userId\": \"1\",\n" +
            "  \"id\": \"1\" \n}";
  @Test
  public void PutRequest() {  
	  Response response = given()
              .header("Content-type", "application/json")
              .and()
              .body(requestBody)
              .when()
              .put("/posts/1")
              .then()
              .extract().response();
      Assert.assertEquals(200, response.statusCode());
      Assert.assertEquals("foo", response.jsonPath().getString("title"));
      Assert.assertEquals("baz", response.jsonPath().getString("body"));
      Assert.assertEquals("1", response.jsonPath().getString("userId"));
      
      Assert.assertEquals("1", response.jsonPath().getString("id"));
  }
  @BeforeTest
  public static void setup() {
      RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
  }

}
