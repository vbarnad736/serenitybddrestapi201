package com.serenitybddrestapi.testcases;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class GetCountryResponse {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://restcountries.eu/rest/v1";
	}
	
	@Test
	public void getCountryResponse() {
		SerenityRest.rest().given()
		.when()
		.get("/name/INDIA")
		.then()
		.log()
		.all()
		.statusCode(200)
		.assertThat()
		.body("[1].altSpellings", hasItem("Republic of India"));
	}
	
	@Test
	public void getCountryErrorNotFound() {
		SerenityRest.rest().given()
		.when()
		.get("/name/xyz")
		.then()
		.log()
		.all()
		.statusCode(404)
		.assertThat()
		.body("message", equalTo("Not Found"));

	}
}
