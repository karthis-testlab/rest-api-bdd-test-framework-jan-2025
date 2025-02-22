package service.now.som;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class IncidentService {
	
	Response response;
	
	public void createIncident(RequestSpecBuilder request, String requestPayload) {
		response = given().spec(request.build())
		                  .when()
		                  .body(requestPayload)
		                  .post("/incident");
	}
	
	public void createIncident(RequestSpecBuilder request, Object requestPayload) {
		response = given().spec(request.build())
		                  .when()
		                  .body(requestPayload)
		                  .post("/incident");
	}
	
	public void getIncident(RequestSpecBuilder request) {
		response = given().spec(request.build())
	                      .when()	      
	                      .get("/incident");
	}
	
	public void getIncident(RequestSpecBuilder request, String sysId) {
		response = given().spec(request.build())
	                      .when()	      
	                      .get("/incident"+"/"+sysId);
	}
	
	public void validateResponse(int statusCode, String statusLine) {
		response.then().statusCode(statusCode)
		               .statusLine(Matchers.containsString(statusLine));
	}

}