package day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import com.github.javafaker.Faker;

public class CreateUser {

	@Test()
	void create_data(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken="371bec052fedc7a1fb49d5f432e1505a1c6776e3776e8c255aed1e9ffa52f12e";
		
		int id=given()
		   .header("Authorization" , "Bearer "+bearerToken)
		   .contentType("application/json")
		   .body(data.toString())
		.when()
		    .post("https://gorest.co.in/public/v2/users")
		    .jsonPath().getInt("id");
		
		System.out.println("ID==> "+id);
	//	context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
	}
}
