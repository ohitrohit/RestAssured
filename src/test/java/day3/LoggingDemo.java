package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LoggingDemo {

	 @Test()
			void testHeader() {
				
				given()
				
				.when()
				    .get("https://www.google.com/")
				.then()
//				    .log().body();
//				    .log().cookies();
//				    .log().headers();
				    .log().all();
				   
			}
}
