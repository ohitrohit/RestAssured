package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserialization {

	//@Test()
	void javaTojsonconversion() throws JsonProcessingException {
		
		POJOClassforserialization data = new POJOClassforserialization();
		data.setName("kamal");
		data.setAge(30);
		
		//convert java object into json ->serialisation
		ObjectMapper obj = new ObjectMapper();
		String jsondata = obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);
	}
	
	
	@Test()
	
	void jsonTOjava() throws JsonMappingException, JsonProcessingException {
		
		String JsonData ="{\r\n"
				+ "  \"name\" : \"kamal\",\r\n"
				+ "  \"age\" : 30\r\n"
				+ "}";
		
		ObjectMapper obj = new ObjectMapper();
		POJOClassforserialization d = obj.readValue(JsonData, POJOClassforserialization.class);
		System.out.println(d.getName());
		System.out.println(d.getAge());
		
	}
}
