package day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {

	//approach1
	//@Test()
	void textjsonResponse() {
		
		given()
		   .contentType(ContentType.JSON)
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		   .statusCode(200)
		   .body("data[2].first_name",equalTo("Tobias"));
	}
	
	//aproach2
	
	//@Test()
		void textjsonResponse2() {
			
			Response res = given()
			   .contentType(ContentType.JSON)
			.when()
			   .get("https://reqres.in/api/users?page=2");
			

			Assert.assertEquals(res.statusCode(), 200);
			String name = res.jsonPath().get("data[2].first_name").toString();
			Assert.assertEquals(name, "Tobias");
			
		}
	
	//@Test()
	void getResponseBodyData() {
		
		Response res = given()
		   .contentType(ContentType.JSON)
		.when()
		   .get("https://reqres.in/api/users?page=2");
	    
		//java object class
		JSONObject js = new JSONObject(res.asString());    //converting response to javaobject class
		
		//print all the first name
		
//		for(int i =0; i<js.getJSONArray("data").length(); i++) {
//			String firstname = js.getJSONArray("data").getJSONObject(i).get("first_name").toString();
//			System.out.println(firstname);
//		}
	    
		
		//Compare the first name
		
		boolean status = true;
		for(int i =0; i<js.getJSONArray("data").length(); i++) {
			String firstname = js.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			
			if(firstname.equals("Tobias")) {
				status = true;
				System.out.println(firstname); 
				break;
			}
			
		}
	 
		
	   Assert.assertEquals(status, true);
	}	
	
	@Test()
	void getResponseBodyDatabybookapi() {
		
		Response res = given()
		   .contentType(ContentType.JSON)
		.when()
		   .get("https://reqres.in/api/unknown");
		
		//java object class
		JSONObject js = new JSONObject(res.asString());    //converting response to javaobject class
				
			    
				
	 //Compare the first name
				
	  int totalyear = 0; 
      for(int i =0; i<js.getJSONArray("data").length(); i++) {
	  String year = js.getJSONArray("data").getJSONObject(i).get("year").toString();
		
	  totalyear = totalyear+Integer.parseInt(year);
	    
					
      }
      System.out.println("total year==> "+totalyear);
      Assert.assertEquals(totalyear, 12015);
     }
	
}