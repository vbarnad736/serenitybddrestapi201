//package com.serenitybddrestapi.testcases;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import com.serenitybddrestapi.model.User;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.serenitybdd.rest.SerenityRest;
//
//@RunWith(SerenityRunner.class)
//public class PostUserRegistration {
//	
//	static String firstName = "RestAPI";
//	static String lastName = "SerenityBDD";	
//	static String email = "restapi@mailinator.com";
//	
//	@BeforeClass
//	public static void init() {
//		RestAssured.baseURI = "https://reqres.in/api/users";
//	}
//	
//	@Test
//	public void registerNewMember() {
//		
//		User user = new User();
//		user.setFirstName(firstName);
//		user.setLastName(lastName);
//		user.setEmail(email);
//		
//		
//		SerenityRest.rest().given()
//		.contentType(ContentType.JSON)
//		.log()
//		.all()
//		.when()
//		.body(user)
//		.post("/users")
//		.then()
//		.log()
//		.all()
//		.statusCode(201);
//	}
//}
