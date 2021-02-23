package com.applicateAI.cool;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.web.server.LocalServerPort;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
class CoolApplicationTests {

	@Test
	void getCatalog() {
		Response response = given()
                .contentType(ContentType.JSON)
                .param("keyword", "ing")
                .when()
                .get("http://localhost:8090/getCatalogs")
                .then()
                .extract().response();
	System.out.println(response.getBody().asString());
	}

 	@Test
    	public void postRequest() {
        	given()
		.param("sku_name","HELLO")
		.param("sku_description","HELLO")
		.param("brand_name","HELLO")
		.param("brand_description","HELLO")
		.param("supplier_id","2")
		.header("Accept", ContentType.JSON.getAcceptHeader())
                .post("http://localhost:8090/addCatalog")
                .then();

}
}