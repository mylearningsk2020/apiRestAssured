/**
 * 
 */
package com.qa.restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * This class is created as part of reading values from json response file using responsegetter class
 *
 */
public class responseGetValues {
	static responseJsonObject robj = new responseJsonObject();	
		
	@Test(priority=1)
	public void getResponseData() {
	
//	responseJsonObject robj = new responseJsonObject();	
//	robj.setId(2);
//	robj.setAge(45);
//	robj.setLast("kate");
//	robj.setName("Morgan");
//	robj.setGender("F");
//	
	
	 robj = get("http://v2eok.mocklab.io/customer/a").as(responseJsonObject.class);
	 System.out.println(robj.getId());
	 if(robj.getId()<1) {
		 System.out.println("Id is invalid");}
		 else {
			 System.out.println("Received Id as defined");
		 }
	 
	 System.out.println(robj.getGender());
	 
	 System.out.println(robj.getLast());
	 if(robj.getLast().length()>10) {
		 System.out.println("Last Name should allow 10 char maximuum");
	 }
	 else {
		 System.out.println("Last name contains characters within expected threshold");
	 }
	 
	 
//	 System.out.println(robj.getName());
//	 if(robj.getName().length()>10) {
//		 System.out.println("Name should only accept 10 alpha characters");
//	 }
//	 else {
//		 System.out.println("Name field value meets the threshold defined");
//	 }
	 System.out.println(robj.getAge());
	 
	  if(robj.getAge()>0 || robj.getAge() <=120) {
		 System.out.println("Age is within the threshold");}
	 else {
		 System.out.println("Age is not in the threshold");
	 }
	  
	  
		}
	
	@Test(priority=2)
	public static boolean isNameAlpha() {
		 robj = get("http://v2eok.mocklab.io/customer/a").as(responseJsonObject.class);
		 if(robj.getName().matches("[a-zA-Z]+") &&robj.getName().length()<10) {
			 return true;
			 }
		 else {
			 return false;
		 }
	}
	
	@Test(priority=3)
	public  static boolean isLastAlpha1() {
		 robj = get("http://v2eok.mocklab.io/customer/a").as(responseJsonObject.class);
		 if(robj.getLast().matches("[a-zA-Z]+") &&robj.getLast().length()<10) {
			 return true;
			 }
		 else {
			 return false;
		 }
	}
	
	
	


}