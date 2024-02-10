package utilities;

import com.github.javafaker.Faker;

public class RandomUtilty {
	public String firstName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	public String lastName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	public String emailAddress() {
		Faker faker = new Faker();
		return faker.internet().emailAddress();
	}
	public String username() {
		Faker faker = new Faker();
		return faker.name().username();
	}
	public String password() {
		Faker faker = new Faker();
		return faker.internet().password(true);
	}
	
}
