package day2;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class SecondApprorchToPostRequest {

	//1)Post request body using json.org 
	
		int id;
		
		@Test(priority = 1)
		
		void getData() {
			given()
			
			.when()
			     .get("http://localhost:3000/Student")
			.then()
			     .statusCode(200)
			     .log().all();
		}
		@Test(priority = 2)
		void testPostusingHashMap() {
			
			JSONObject data = new JSONObject();
			data.put("name", "student6");
			data.put("roll number", "1005");
			data.put("grade", "a");
			data.put("class", 8);
			
			id=given()
			     .contentType("application/json")
			     .body(data.toString())          //here we are creating a data in jsonobject thats why we need to convrt data in string 
			
			.when()
			      .post("http://localhost:3000/Student") 
			      .jsonPath().getInt("id");
			      
//			.then()
//			      .statusCode(200)
//			      .body("name",equalTo("student6"))
//			      .body("roll number",equalTo("1005"))
//			      .log().all();
		}
		
		
		@Test(priority = 3)
		void testDelete() {
			
			given()
			
			.when()
			   .delete("http://localhost:3000/Student/"+id)
			.then()
			.statusCode(200);
		}
		
		
}
