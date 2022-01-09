package Rest1;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.given;

import java.io.FileWriter;
import java.io.IOException;

public class PostRequest {
	private static String requestBody = "{\n" + "  \"title\": \"test\",\n" + "  \"body\": \"bar\",\n"
			+ "  \"userId\": \"1\" \n}";

	@BeforeTest
	public void beforeTest() {
		{
			RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		}
	}

	@Test
	public void PostRequest() throws IOException {
		Response response = given().log().all().header("Content-type", "application/json").and().body(requestBody)
				.when().post("/posts").then().extract().response();
		System.out.println("Actual response code :" + response.statusCode());
		System.out.println("Actual output response :" + response.jsonPath().getString("id"));

		String i = response.asString();
		String Test = "C:\\BrowserDriver&Jars\\Test.json";

		FileWriter fw = new FileWriter(Test);

		fw.write(i);
		fw.close();
		Assert.assertEquals(201, response.statusCode());
		Assert.assertEquals("test", response.jsonPath().getString("title"));
		Assert.assertEquals("bar", response.jsonPath().getString("body"));
		Assert.assertEquals("1", response.jsonPath().getString("userId"));
		Assert.assertEquals("101", response.jsonPath().getString("id"));
	}
}
