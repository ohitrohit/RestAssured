package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDatagenerator {

	@Test()
	void genrateFakeData() {
		
		Faker faker = new Faker();
		
		String fullname = faker.name().fullName();
		String username = faker.name().username();
		String password = faker.internet().password();
		String phonenum = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		
		System.out.println(fullname);
		System.out.println(username);
		System.out.println(password);
		System.out.println(phonenum);
		System.out.println(email);
	}
}
