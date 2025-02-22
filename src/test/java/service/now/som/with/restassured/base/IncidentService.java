package service.now.som.with.restassured.base;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.rest.assured.base.lib.design.ResponseAPI;
import com.rest.assured.lib.base.RestAssuredBase;

import io.restassured.builder.RequestSpecBuilder;

public class IncidentService {
	
	ResponseAPI response;
	RestAssuredBase base = new RestAssuredBase();
	
	public void createIncident(RequestSpecBuilder request, String requestPayload) {
		response = base.post(request, "/incident", requestPayload);
	}
	
	public void createIncident(RequestSpecBuilder request, Object requestPayload) {
		response = base.post(request, "/incident", requestPayload);
	}
	
	public void getIncident(RequestSpecBuilder request) {
		response = base.get(request, "/incident");
	}
	
	public void getIncident(RequestSpecBuilder request, String sysId) {
		response = base.get(request, "/incident"+"/"+sysId);
	}
	
	public void validateResponse(int statusCode, String statusLine) {		
		assertThat(response.getStatusCode(), equalTo(statusCode));
		assertThat(response.getStatusMessage(), equalTo(statusLine));
	}
	
	public void validateResponse(int statusCode, String statusLine, String contentType) {		
		assertThat(response.getStatusCode(), equalTo(statusCode));
		assertThat(response.getStatusMessage(), equalTo(statusLine));
		assertThat(response.getContentType(), equalTo(contentType));
	}

}