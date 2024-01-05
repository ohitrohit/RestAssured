package day3;

import static io.restassured.RestAssured.given;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CookiesDemo {

	//@Test()
	void testCookies() {
		
		given()
		
		.when()
		    .get("https://www.google.com/")
		.then()
		    .cookie("AEC" , "Ackid1RSqfCJ31F0b-yxMfQ4JqtNYJCFNUyvn312B_WVR69tcdaB__FTWg")  //method will get fail bcz coockies not every time same
		    .log().all();
	}
	
	@Test()
	void getCookiespresentorNOt() {
		
		given()
		
		.when()
		    .get("https://www.google.com/")
		.then()
		     .cookie("AEC");
	}
	
	@Test()
	void getCookiesinfo() {
		
		Response res=given()
		
		.when()
		    .get("https://www.google.com/");
		
		//get single cookies
		
//		String cookie_value = res.getCookie("AEC");
//		System.out.println("AEC Value ========> "+cookie_value);
		
		Map<String, String> cookies_value = res.getCookies();
//		System.out.println(cookies_value.keySet());
		
		for(String k:cookies_value.keySet()){
			String value = res.getCookie(k);
			System.out.println(k+" "+value);
		}
		
		
	}
	
}
