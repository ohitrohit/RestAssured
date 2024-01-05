package day5;
import static io.restassured.RestAssured.given;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXmlResponse {

	//@Test()
	void testxmlResponsedata() {
		//approach 1
		/*given()
		
		.when()
		   .get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
		   .statusCode(200)
		   .header("Content-Type","application/xml; charset=utf-8")
		   .body("TravelerinformationResponse.page", equalTo("1"))
		   .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
		
		*/
		
		//approach 2
		
		Response res = given()
		   
		.when()
		   .get("http://restapi.adequateshop.com/api/Traveler");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		
		String pegno = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pegno, "1");
		System.out.println("pegno ==> "+pegno);
		
		 String travellername = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		 Assert.assertEquals(travellername, "Developer");
		 System.out.println("travellername ==> "+travellername);
		
	}
	
	@Test()
	void testxmlResponsebody() {
		
		Response res = given()
		
		.when()
		   .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlObj = new XmlPath(res.asString());
		
		//verify total number of travellers
		List<String> value =xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(value.size(), 10);
		
		//verify travells name is presend in response
		boolean status = false;
		List<String> traveller_name = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		for(String name:traveller_name) {
			
			if(name.equals("Developer")){
				status=true;
				break;
			}
			
			
		}
		Assert.assertEquals(status, true);
		
		
		   
	}
	
}
