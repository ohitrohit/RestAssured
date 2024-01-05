package day2;
/**
 * diffrent ways to create POST request
 * 1)Post request body using Hshmap
 * 2)Post request body creation using Org.json
 * 3)Post reuest body creation by POJO class
 * 4)Post request using external json file data
 * @author rohit
 *
 */
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.Test;

public class DiffWayTOcreateRequestBody {

	//1)Post request body using hashmap
	
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
		
		HashMap data = new HashMap();
		data.put("name", "student6");
		data.put("roll number", "1005");
		data.put("grade", "a");
		data.put("class", 8);
		
		id=given()
		     .contentType("application/json")
		     .body(data)
		
		.when()
		      .post("http://localhost:3000/Student") 
		      .jsonPath().getInt("id");
		      
//		.then()
//		      .statusCode(200)
//		      .body("name",equalTo("student6"))
//		      .body("roll number",equalTo("1005"))
//		      .log().all();
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
