package in.com.mongo.config;

import java.util.ArrayList;
import java.util.List;

import in.com.mongo.config.UserDto;

public class UserModelTest {

	public static void main(String[] args) {

//		UserModel userModel = new UserModel();
//
//		UserDto user = new UserDto();
//
//		user.setName("Niketan");
//		user.setGender("Male");
//		user.setAge(22);
//
//		userModel.add(user);
//
//		System.out.println("Test completed");
		
		
		UserModel userModel1 = new UserModel();

		List<UserDto> users = new ArrayList<>();

		users.add(new UserDto("Rahul", "Male", 22));
		users.add(new UserDto("Amit", "Male", 25));
		users.add(new UserDto("Rohit", "Male", 21));
		users.add(new UserDto("Pooja", "Female", 24));
		users.add(new UserDto("Raj", "Male", 23));
		users.add(new UserDto("Neha", "Female", 27));
		users.add(new UserDto("Karan", "Male", 26));
		users.add(new UserDto("Suresh", "Male", 30));
		users.add(new UserDto("Priya", "Female", 28));
		users.add(new UserDto("Manish", "Male", 29));

		
		userModel1.manyInsert(users);

		System.out.println("Test completed");

	}
			
	}
