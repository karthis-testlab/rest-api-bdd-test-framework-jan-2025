package com.rest.assured.base.lib.design;

import io.restassured.builder.RequestSpecBuilder;

public interface ApiClient {	

	ResponseAPI get(RequestSpecBuilder request, String endPoint);	
	ResponseAPI post(RequestSpecBuilder request, String endPoint, Object body);
	ResponseAPI put(RequestSpecBuilder request, String endPoint, Object body);
	ResponseAPI patch(RequestSpecBuilder request, String endPoint, Object body);
	ResponseAPI delete(RequestSpecBuilder request, String endPoint);

}
