package APITest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Trello {

	
	public static String baseurl = "https://api.trello.com";
	

	@Test(priority = 0)
	public void createboard()
	{
		RestAssured.baseURI= baseurl;
		//pre-requiste//parameter//header//cookies
				given().queryParam("key", "b4f28fde93f0edf0336a94b014a42a62")
				.queryParam("token", "15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
				.queryParam("name", "Freetime").header("content-Type","application/json")
				//condition//differetn HTTP methds
				.when()
				.post("/1/boards/")
				//basically checking response //applying assertion //assertion and response
				.then()
				.assertThat().statusCode(200).contentType(ContentType.JSON);
			}
	
		@Test(priority = 1)
		public void getboard()
		{
			//any time u have to work with rest assured first u have to load the base url
			
			RestAssured.baseURI = baseurl;
			
			
			given().param("key","b4f28fde93f0edf0336a94b014a42a62")
			.param("token","15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
			
			.when()
			.get("/1/boards/pimoX2S8")
			
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON).and()
			.body("name", equalTo("Freetime")).and()
			.body("id",equalTo("61a715487c3c654b0072bd4f"));
			
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
					.delete("/1/boards/pimoX2S8")
					//basically checking response //applying assertion //assertion and response
					.then()
					.assertThat().statusCode(200).contentType(ContentType.JSON);
				}

}
