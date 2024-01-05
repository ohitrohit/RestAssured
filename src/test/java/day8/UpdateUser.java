package day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import com.github.javafaker.Faker;

public class UpdateUser {

	@Test()
	void test_updatedata(ITestContext context) {
		
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken="371bec052fedc7a1fb49d5f432e1505a1c6776e3776e8c255aed1e9ffa52f12e";
		
//		int id =(Integer)context.getAttribute("user_id");
		int id =(Integer)context.getSuite().getAttribute("user_id");
		given()
		   .header("Authorization" , "Bearer "+bearerToken)
		   .contentType("application/json")
		   .pathParam("id",id)
		   .body(data.toString())
		.when()
		    .put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		   .statusCode(200)
		   .log().all();
		 
		
		
		
	}
}
