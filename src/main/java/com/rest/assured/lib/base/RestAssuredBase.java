package com.rest.assured.lib.base;

import com.rest.assured.base.lib.design.ApiClient;
import com.rest.assured.base.lib.design.ResponseAPI;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBase implements ApiClient {
	
	Response response;	
	
	private RequestSpecification preCondition(RequestSpecBuilder request) {
		return given()
				 .spec(request.build())
				 .filter(new RestAssuredLogListener());
	}

	@Override
	public ResponseAPI get(RequestSpecBuilder request, String endPoint) {
		response = preCondition(request).get(endPoint);
		return new ResponseImpl(response);
	}

	@Override
	public ResponseAPI post(RequestSpecBuilder request, String endPoint, Object body) {
		response = preCondition(request)
				          .body(body)
				          .post(endPoint);
		return new ResponseImpl(response);
	}

	@Override
	public ResponseAPI put(RequestSpecBuilder request, String endPoint, Object body) {
		response = preCondition(request)
		                  .body(body)
		                  .put(endPoint);
        return new ResponseImpl(response);
	}

	@Override
	public ResponseAPI patch(RequestSpecBuilder request, String endPoint, Object body) {
		response = preCondition(request)
                          .body(body)
                          .patch(endPoint);
        return new ResponseImpl(response);
	}

	@Override
	public ResponseAPI delete(RequestSpecBuilder request, String endPoint) {
		response = preCondition(request)
                          .delete(endPoint);
        return new ResponseImpl(response);
	}

}