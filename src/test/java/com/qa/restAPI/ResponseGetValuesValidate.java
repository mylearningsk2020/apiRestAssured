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
public class ResponseGetValuesValidate {
			
	@Test(priority=1)
	public void isLastNameAlphaTest() {
		responseGetValues rgvalues = new responseGetValues();
		Assert.assertTrue(rgvalues.isLastAlpha1(), "LastName");
	
	}	 
	
	@Test(priority=2)
	public void isNameAlphaNameTest() {
		responseGetValues rgvalues = new responseGetValues();
		Assert.assertTrue(rgvalues.isNameAlpha(), "Name");
	
	}	 
	
	
	


}