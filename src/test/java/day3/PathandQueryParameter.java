package day3;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class PathandQueryParameter {

	//https://reqres.in/api/users?page=2?id=5
	
	@Test()
	void pathAndQuerryparameter() {
		
		given()
		   .pathParam("path1","api")
		   .pathParam("path2", "users")
		   .queryParam("page","2")
		   .queryParam("id", "5")
		.when()
		    .get("https://reqres.in/{path1}/{path2}")
		.then()
		    .statusCode(200)
		    .log().all();
	}
	
}
