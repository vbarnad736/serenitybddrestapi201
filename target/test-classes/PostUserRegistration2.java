package com.serenitybddrestapi.testcases;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.serenitybddrestapi.model.User2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class PostUserRegistration2 {
	
	static String firstName = "RestAPI";
	static String lastName = "SerenityBDD";
	static String userName= "RestAPISerenityBDD";
	static String email = "restapi@mailinator.com";
	static String password= "mindtree_01";
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://restapi.demoqa.com/";
	}
	
	@Test
	public void registerNewMember() {
		
		User2 user = new User2();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setUserName(userName);
		
		
		SerenityRest.rest().given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(user)
		.post("/customer/register")
		.then()
		.log()
		.all()
		.statusCode(201);
	}
}
