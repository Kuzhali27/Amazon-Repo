package com.api.basicscript;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DelReq {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().when().delete("api/users/2").then().log().all().extract().response();
		int statusCode = response.getStatusCode();
		System.out.println("statuscode is "+statusCode);
		String s = response.asPrettyString();
		System.out.println("response is "+s);
		
	}

}
