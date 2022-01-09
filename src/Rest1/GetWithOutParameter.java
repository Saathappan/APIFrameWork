package Rest1;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
public class GetWithOutParameter {
	  @BeforeTest
	  public void beforeTest() 
	  {
	      RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	  }
	@Test
  public void GetWithOutParameter() 
  { 
          Response response = given().log().all().contentType(ContentType.JSON).when().get("/posts").then().extract().response();
          System.out.println("Actual Response Code"+response.statusCode());
          Assert.assertEquals(200, response.statusCode());
          Assert.assertEquals("eum et est occaecati",response.jsonPath().getString("title[3]"));
  }
}





