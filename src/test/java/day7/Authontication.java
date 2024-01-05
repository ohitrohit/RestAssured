package day7;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class Authontication {

	@Test()
	void testBasicAuthontication() {
		
		given()
		   .auth().basic("postman", "password")
		.when()
		    .get("https://postman-echo.com/basic-auth")
		.then()
		    .statusCode(200)
		    .body("authenticated",equalTo(true))
		    .log().all();
		
		
	}
	
	//@Test()
	void testDigestAuthontication() {
		
		given()
		   .auth().digest("postman", "password")
		.when()
		    .get("https://postman-echo.com/basic-auth")
		.then()
		    .statusCode(200)
		    .body("authenticated",equalTo(true))
		    .log().all();
		
		
	}
	
	//@Test()
	void testPreemptiveAuthontication() {
		
		given()
		   .auth().preemptive().basic("postman", "password")
		.when()
		    .get("https://postman-echo.com/basic-auth")
		.then()
		    .statusCode(200)
		    .body("authenticated",equalTo(true))
		    .log().all();
		
		
	}
	
	//@Test()
	void testBearerTokenAuthontication() {
		
		String bearerToken = "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";
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		.when()
		    .get("https://api.github.com/user/repos")
		.then()
		    .statusCode(200)
		    .log().all();
		
		
	}
	
	//@Test()
		void testOAuth1Authontication() {
			
			given()
			   .auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")
			.when()
			    .get("url")
			.then()
			    .statusCode(200)
			    .log().all();
	
	}
		
	// @Test()
	     void testOAuth2Authontication() {
					
			given()
			    .auth().oauth2("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") //for this token u have to generate manualy by postman or dev gove u
			.when()
				.get("https://api.github.com/user/repos")
			.then()
			     .statusCode(200)
			     .log().all();
			
			}
	 
	  // @Test()
			void testApiKeyAuthontication() {
				
				given()
				   .queryParam("apiKey","value")
				.when()
				    .get("url")
				.then()
				    .statusCode(200)
				    .log().all();
		
		}
}
