package com.api.common.Inventory;

import org.testng.Assert;

import com.api.common.BaseAPI;
import com.api.common.RequestSpecificationUtil;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Inventory extends BaseAPI{

	
	ExtentTest extentTest;
	
	public Inventory(ExtentTest extentTest){
		super();
		RestAssured.baseURI = "https://api.github.com";		
		this.extentTest = extentTest;		
	}

	
	public Response createInventory() throws Exception{
		RestAssured.basePath = "/users/rest-assured";
		Response response = null; 
		try {
			response= RestAssured.given()				
					.spec(RequestSpecificationUtil.gettReqSpecificationWithAuth())
//					.body(body)
				.when()
					.get()
				.then()
					.log().all()
					.statusCode(201)
					.extract().response();			
		}catch(Exception oExp) {
			Assert.fail("Failed to create a new inventory: " + oExp.getMessage());
		}		
		return response;
	}

}
