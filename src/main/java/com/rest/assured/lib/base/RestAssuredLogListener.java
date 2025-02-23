package com.rest.assured.lib.base;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RestAssuredLogListener implements Filter {

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		Response response = ctx.next(requestSpec, responseSpec);
		System.out.println("=================Request Log=================");
		System.out.println("Base URI: "+requestSpec.getBaseUri());
		System.out.println("Base Path: "+requestSpec.getBasePath());
		System.out.println("Headers: "+requestSpec.getHeaders());
		System.out.println("=================Response Log=================");
		System.out.println("Status Line: "+ response.getStatusLine());
		System.out.println("Body: "+ response.getBody().asPrettyString());
		return response;
	}

}