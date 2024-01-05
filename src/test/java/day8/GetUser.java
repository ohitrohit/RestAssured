package day8;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetUser {

	@Test()
	void test_getData(ITestContext context) {
	
//		int id=(Integer)context.getAttribute("user_id");   // thios should come from create user
		int id=(Integer)context.getSuite().getAttribute("user_id"); 
		String bearerToken ="371bec052fedc7a1fb49d5f432e1505a1c6776e3776e8c255aed1e9ffa52f12e";
		
		given()
		   .header("Authorization", "Bearer "+bearerToken)
		   .pathParam("id",id)
		.when()
		   .get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		    .statusCode(200)
		    .log().all();
	}
}
