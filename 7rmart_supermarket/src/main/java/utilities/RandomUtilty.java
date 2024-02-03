package utilities;

import com.github.javafaker.Faker;

public class RandomUtilty {
	public void firstName(String firstName) {
		Faker faker = new Faker();
		firstName = faker.name().firstName();
	}
	public void lastName(String lastName) {
		Faker faker = new Faker();
		lastName = faker.name().lastName();
	}
	public void emailAddress(String email) {
		Faker faker = new Faker();
		email = faker.internet().emailAddress();
	}
	public void username(String username) {
		Faker faker = new Faker();
		username = faker.name().username();
	}
	public void password(String password) {
		Faker faker = new Faker();
		password = faker.internet().password(true);
	}
	
}
