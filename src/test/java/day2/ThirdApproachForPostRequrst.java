package day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ThirdApproachForPostRequrst {

	//1)Post request body using POJO class 
	
	int id;
	
	@Test(priority = 2)
    void gethuman() {
     
	  	given()
		
		.when()
		  .get("http://localhost:3000/human")
		  
		.then()
		.statusCode(200)
		.log().all();
    	
    }
	
	@Test(priority = 1)
	void Createhuman() {
		
		POJOClass data = new POJOClass();
		data.setName("praval");
		data.setAge(28);
		
		id=given()
		  .contentType("application/json")
		  .body(data)
		.when()
		  .post("http://localhost:3000/human")
		  .jsonPath().getInt("id");
		
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
