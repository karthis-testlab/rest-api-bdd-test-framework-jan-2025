package com.rest.assured.lib.base;

import java.util.Map;

import com.rest.assured.base.lib.design.ResponseAPI;

import io.restassured.response.Response;

public class ResponseImpl implements ResponseAPI {
	
	Response response;
	
	public ResponseImpl(Response response) {
		this.response = response;
	}

	@Override
	public int getStatusCode() {		
		return response.getStatusCode();
	}

	@Override
	public String getStatusMessage() {
		String[] strings = response.getStatusLine().split(" ", 3);
		return strings[2];
	}

	@Override
	public String getBody() {		
		return response.asPrettyString();
	}

	@Override
	public Map<String, String> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {		
		return response.getContentType().split(";", 2)[0];
	}

}