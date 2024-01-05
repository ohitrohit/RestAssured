package day8;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteUser {

	@Test()
	void test_deletedata(ITestContext context) {
		
		String bearerToken="371bec052fedc7a1fb49d5f432e1505a1c6776e3776e8c255aed1e9ffa52f12e";
		
//		int id =(Integer)context.getAttribute("user_id");
		int id =(Integer)context.getSuite().getAttribute("user_id");
		given()
		   .header("Authorization" , "Bearer "+bearerToken)
		   .pathParam("id",id)
		.when()
		   .delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		   .statusCode(204);
		
	}
	
}
