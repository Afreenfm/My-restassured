package APITest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Tre {

	public static String baseurl = "https://api.trello.com";
	public Object id;
	

	@Test(priority = 0)
	public void createboard()
	{
		RestAssured.baseURI= baseurl;
		Response response = (Response) given().queryParam("key", "b4f28fde93f0edf0336a94b014a42a62")
				.queryParam("token", "15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
				.queryParam("name", "Freetime").header("content-Type","application/json")
				//condition//differetn HTTP methds
				.when()
				.post("/1/boards/")
				//basically checking response //applying assertion //assertion and response
				.then()
				.assertThat().statusCode(200).contentType(ContentType.JSON).
	extract().response();
	String jsonresponse = response.asString();
	JsonPath responsebody = new JsonPath(jsonresponse);
	id = responsebody.get("id");
	System.out.println(id);
	}
	
		@Test(priority = 1)
		public void getboard()
		{
			//any time u have to work with rest assured first u have to load the base url
			
			RestAssured.baseURI = baseurl;
			Response response=given().param("key","b4f28fde93f0edf0336a94b014a42a62")
			.param("token","15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
			
			.when()
			.get("/1/boards/"+id)
			
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
			
			String jsonresponse = response.asString();
			JsonPath responsebody = new JsonPath(jsonresponse);
			id = responsebody.get("id");
			System.out.println(id);
			
		}
		
		@Test(priority = 2)
		public void deleteboard()
		{
			RestAssured.baseURI= baseurl;
			//pre-requiste//parameter//header//cookies
					given().queryParam("key", "b4f28fde93f0edf0336a94b014a42a62")
					.queryParam("token", "15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
					.queryParam("name", "Freetime").header("content-Type","application/json")
					//condition//differetn HTTP methds
					.when()
					.delete("/1/boards/"+id)
					//basically checking response //applying assertion //assertion and response
					.then()
					.assertThat().statusCode(200).contentType(ContentType.JSON).
				extract().response();
				String jsonresponse = response.asString();
				System.out.println(jsonresponse);
		
		}

}
