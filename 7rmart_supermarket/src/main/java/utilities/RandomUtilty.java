package utilities;

import com.github.javafaker.Faker;

public class RandomUtilty {
	Faker faker;
	public String firstName() {
		faker = new Faker();
		return faker.name().firstName();
	}
	public String lastName() {
		faker = new Faker();
		return faker.name().lastName();
	}
	public String emailAddress() {
		faker = new Faker();
		return faker.internet().emailAddress();
	}
	public String username() {
		faker = new Faker();
		return faker.name().username();
	}
	public String password() {
		faker = new Faker();
		return faker.internet().password(true);
	}
	
}
