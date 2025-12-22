package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {//predefined cls hlps in generating fake datas 
	Faker faker = new Faker();

	public String createRandomUserName() {
		return faker.name().username();
	}

	public String createFakePassword() {
		return faker.internet().password();
	}

	public String createRandomEmail() {
		return faker.internet().emailAddress();
	}

	public String createRandomFullName() {
		return faker.name().fullName();
	}

	public String createRandomAddress() {
		return faker.address().fullAddress();
	}
}
