package com.serenitybddrestapi.testcases;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class GetCountryCapital {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://restcountries.eu/rest/v1";
	}
	
	@Test
	public void verifyCountryCapital() {
		SerenityRest.rest().given()
		.when()
		.get("/name/norway")
		.then()
		.log()
		.all()
		.statusCode(200)
		.assertThat()
		.body("[0].capital", equalTo("Oslo"));
	}
	
}
