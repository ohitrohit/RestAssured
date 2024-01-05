package day6;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class Jsonfileschemavalidation {

	@Test()
	void testjsonvalidation() {
		
		given()
		
		.when()
		    .get("https://reqres.in/api/users/2")
		.then()
		   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("reqrusschema.json"));
	}
	
}
