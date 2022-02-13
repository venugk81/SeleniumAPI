package com.api.common.Inventory;

import java.util.Map;

import org.asynchttpclient.request.body.Body;
import com.api.common.RequestSpecificationUtil;
import com.utils.ReadTokensFromFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Inventory {

	Map<String, String> tokens;

	Inventory() {
		tokens = ReadTokensFromFile.getTokens();
		RestAssured.baseURI = "";
	}
	
	public void prepareNewInventoryPojo() {
		
	}

	
	public Response createInventory(Body body) {
		RestAssured.basePath = "";
		Response response = RestAssured.given()
					//.queryParam(, parameterValues)					
					.spec(RequestSpecificationUtil.gettReqSpecificationWithAuth())
					.body(body)
				.when()
					.post()
				.then()
					.statusCode(201)
					.extract().response();

		return response;
	}

}
