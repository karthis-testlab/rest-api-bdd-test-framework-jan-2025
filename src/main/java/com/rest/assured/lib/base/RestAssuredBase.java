package com.rest.assured.lib.base;

import com.rest.assured.base.lib.design.ApiClient;
import com.rest.assured.base.lib.design.ResponseAPI;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class RestAssuredBase implements ApiClient {
	
	Response response;	

	@Override
	public ResponseAPI get(RequestSpecBuilder request, String endPoint) {
		response = given().spec(request.build())
		                  .when()
		                  .get(endPoint);		
		return new ResponseImpl(response);
	}

	@Override
	public ResponseAPI post(RequestSpecBuilder request, String endPoint, Object body) {
		response = given().spec(request.build())
				          .when()
				          .body(body)
				          .post(endPoint);
		return new ResponseImpl(response);
	}

	@Override
	public ResponseAPI put(RequestSpecBuilder request, String endPoint, Object body) {
		response = given().spec(request.build())
		                  .when()
		                  .body(body)
		                  .put(endPoint);
        return new ResponseImpl(response);
	}

	@Override
	public ResponseAPI patch(RequestSpecBuilder request, String endPoint, Object body) {
		response = given().spec(request.build())
                          .when()
                          .body(body)
                          .patch(endPoint);
        return new ResponseImpl(response);
	}

	@Override
	public ResponseAPI delete(RequestSpecBuilder request, String endPoint) {
		response = given().spec(request.build())
                          .when()
                          .delete(endPoint);
        return new ResponseImpl(response);
	}

}