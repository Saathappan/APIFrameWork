package Rest1;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
public class GetWithParameter {
	  @BeforeTest
	  public void beforeTest() 
		{
		        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	     }
	@Test
  public void GetWithParameter() {  
  Response response = given().log().all()
              .contentType(ContentType.JSON)
              .param("postId", "1")
              .when()
              .get("/comments")
              .then()
              .extract().response();
  System.out.println("Actual response code :"+response.statusCode());
  Assert.assertEquals(200, response.statusCode());
   Assert.assertEquals("Nikita@garfield.biz", response.jsonPath().getString("email[2]"));
 // Jayne_Kuhic@sydney.com
 // Assert.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
  }
  }
