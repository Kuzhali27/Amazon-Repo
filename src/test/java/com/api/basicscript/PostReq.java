package com.api.basicscript;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostReq {
public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response response = RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morp\",\r\n"
				+ "    \"job\": \"lead\"\r\n"
				+ "}").when().post("api/users").then().log().all().extract().response();
		
		int statusCode = response.getStatusCode();
		System.out.println("statuscode is "+statusCode);
		String s = response.asPrettyString();
		System.out.println("response is "+s);
}
		
}
