package com.ravi.sampleapp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.bind.annotation.PathVariable;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.ravi.sampleapp.controllers.CustomerController;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class CustomerControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		RestAssuredMockMvc.standaloneSetup(new CustomerController());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void getCustomerByNameTest() {
		
		//given().param("name", "Name").
		when().get("/customer/Name").
		then().body("name", hasItem("Name"));
/*		
		Response res = get("/customer/Name");
		assertEquals(200, res.getStatusCode());
		String json = res.asString();
		 		 
		JsonPath jp = new JsonPath(json);
		assertEquals("[read@wrtie.com]", jp.getString("email"));
		assertEquals("[Name]", jp.getString("name"));
*/	}

}
