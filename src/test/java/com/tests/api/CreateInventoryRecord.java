package com.tests.api;

import java.util.Map;

import org.asynchttpclient.request.body.Body;
import org.testng.annotations.Test;

import com.api.common.RequestSpecificationUtil;
import com.utils.ReadTokensFromFile;

import io.restassured.RestAssured;

public class CreateInventoryRecord {
	
	Map<String, String> tokens;	
	
	CreateInventoryRecord(){
		tokens = ReadTokensFromFile.getTokens();
		RestAssured.baseURI = "";
	}
	
	@Test
	public void createInventory(Body body) {
		RestAssured.basePath = "";		
		RestAssured.given()
			.spec(RequestSpecificationUtil.gettReqSpecificationWithAuth())
			.body(body)
		.when()
			.post()
		.then()
			.statusCode(201)
			.extract().response();
	}
	

}
