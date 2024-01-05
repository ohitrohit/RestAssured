package day2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
public class ForthAproachToPostRequest {
    
	
	//Create a post request with external json file
	int id;
	
	@Test(priority = 1)
	void createhuman() throws FileNotFoundException {
	 
		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		
		
		id=given()
		     .contentType("application/json")
		     .body(data)
		.when()
		     .post("http://localhost:3000/human")
		     .jsonPath().getInt("id");
				
	}
	
	@Test(priority = 2)
	void gethuman() {
		
		given()
		
		.when()
		   .get("http://localhost:3000/human/"+id)
		 
		.then()
		    .statusCode(200)
		    .log().all();
	}
	
	@Test(priority = 3)
	void deletehuman() {
		given()
		.when()
		   .delete("http://localhost:3000/human/"+id)
		.then()
		   .statusCode(200);
	}
}
