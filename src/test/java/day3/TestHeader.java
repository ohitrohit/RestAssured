package day3;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestHeader {

	//@Test()
		void testHeader() {
			
			given()
			
			.when()
			    .get("https://www.google.com/")
			.then()
			    .header("Content-Type", "text/html; charset=ISO-8859-1");
			   
		}
	
	
		@Test()
		void getHeader() {
			
			Response res=given()
			
			.when()
			    .get("https://www.google.com/");
		
//			String Value = res.getHeader("Content-Type");
//			System.out.println("Content-Type ====> "+Value);
			
			Headers value = res.getHeaders();
			for(Header h:value) {
				System.out.println(h.getName()+" "+h.getValue());
			}
		}
}
