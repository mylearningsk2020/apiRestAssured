/**
 * 
 */
package com.qa.restAPI;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * GET REQUEST USING REST ASSURED--EQUIFAX
 *
 */
public class TC001_GETRequest {
	
	JSONObject jsonObj;
	
	@Test
	void getequiFaxAPITest() {		
				
		//Specify Base URI;
		RestAssured.baseURI = "http://v2eok.mocklab.io/customer";
		
			
		//Create Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/a");
		
		
		//Print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		//Status code validation
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		//Status Line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is : "+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		String contentType=response.header("Content-Type");
		System.out.println("Contenet Type is: " + contentType);
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
		
		Headers allHeaders = response.headers();//This will capture all the headers returned from Response;
		
		for(Header header:allHeaders)
		{
			
			System.out.println(header.getName()+"       "+header.getValue());
		}
	
		
		JsonPath jsonpath = response.jsonPath();
//		int id = Integer.parseInt((String) jsonObj.get("id"));
		System.out.println(jsonpath.get("id"));
		System.out.println(jsonpath.get("name"));
		
		System.out.println(jsonpath.get("last"));
		System.out.println(jsonpath.get("age"));
		System.out.println(jsonpath.get("gender"));
		
		Assert.assertEquals(jsonpath.get("id"),1);
		
		Assert.assertEquals(response.getTimeIn(TimeUnit.MILLISECONDS),response.getTime());
		
		System.out.println(response.getSessionId());
		
		
		
		
		
	}
		
	
	@Test
	public void consoleDisplay() {
		System.out.println("Print Message");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
