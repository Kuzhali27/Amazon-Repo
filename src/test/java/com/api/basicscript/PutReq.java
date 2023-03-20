package com.api.basicscript;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutReq {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").when().put("api/users/2").then().log().all().extract().response();
		
		int statusCode = response.getStatusCode();
		System.out.println("statuscode is "+statusCode);
		String s = response.asPrettyString();
		System.out.println("response is "+s);
		
	}

}
