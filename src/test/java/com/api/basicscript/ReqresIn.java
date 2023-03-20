package com.api.basicscript;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqresIn {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in/";
		
		 Response response = RestAssured.given().when().get("api/users/2").
		 then().log().all().extract().response(); int statusCode =
		 response.getStatusCode(); System.out.println("statuscode is "+statusCode);
		  String a = response.asPrettyString();
		 System.out.println("The response is "+a);
		 
		
		
		

}
}


