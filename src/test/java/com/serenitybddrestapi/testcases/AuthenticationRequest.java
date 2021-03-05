package com.serenitybddrestapi.testcases;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class AuthenticationRequest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://postman-echo.com";
	}
	
	@Test
	public void ValidUserAuthentication() {
		SerenityRest.rest().given()
		.auth()
		.basic("postman", "password")
		.log()
		.all()
		.when()
		.get("/basic-auth")
		.then()
		.log()
		.all()
		.statusCode(200)
		.assertThat()
		.body("authenticated", equalTo(true));
	}

	@Test
	public void InValidValidUserAuthentication() {
		SerenityRest.rest().given()
		.auth()
		.basic("invaliduser", "invalidpassword")
		.log()
		.all()
		.when()
		.get("/basic-auth")
		.then()
		.log()
		.all()
		.statusCode(401)
		.assertThat()
		.body(Matchers.containsString("Unauthorized"));
	}
}