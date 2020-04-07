package com.practice.hibernate.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.hibernate.beans.Salesman;

public class Client {

	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
	private static final String PORT = "http://localhost:8080/";
	public static void main(String[] args) {
		
		LOGGER.info("1. getAll()\n2. getById()");
		try (Scanner scan = new Scanner(System.in)) {
			
			int input = scan.nextInt();
			switch(input) {
			
			case 1: 
				TypeReference<List<Salesman>> typeReference = new TypeReference<List<Salesman>>() {};
				List<Salesman> salesmen = callGETMethod("salesmen/all", typeReference);
				salesmen.stream()
				.forEach(salesman -> LOGGER.info(salesman.toString()));
				break;
			}
		}
	}

	private static void callDELETEMethod(String uri, int countryID) {
		/*
		 * 
		 * HttpClient client = HttpClientBuilder.create().build(); HttpDelete
		 * deleteRequest = new HttpDelete(PORT.concat(uri));
		 * deleteRequest.setEntity(createHttpEntity(countryID)); try { HttpResponse
		 * response = client.execute(deleteRequest); return
		 * convertJsonToObject(Boolean.class, response); } catch (IOException e) {
		 * Log.logInfo("Exception while getting response from server {0}", e); } return
		 * false;
		 */}
	/*
	private static boolean callPOSTMethod(String uri, Country newCountry) {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(PORT.concat(uri));
		postRequest.setEntity(createHttpEntity(newCountry));
		try {
			HttpResponse response = client.execute(postRequest);
			return convertJsonToObject(Boolean.class, response);
		} catch (IOException e) {
			LOGGER.error("Exception while getting response from server {0}", e);
		}
		return false;
	}
	*/
	private static <T> boolean callPUTMethod(String uri, T toUpdateObject) {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut putRequest = new HttpPut(PORT.concat(uri));
		putRequest.setEntity(createHttpEntity(toUpdateObject));
		try {
			HttpResponse response = client.execute(putRequest);
			return false;//convertJsonToObject(Boolean.class, response);
		} catch (IOException e) {
			LOGGER.error("Exception while getting response from server", e);
		}
		return false;
	}
	private static <T> HttpEntity createHttpEntity(T toUpdateObject) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String value = mapper.writeValueAsString(toUpdateObject);
			StringEntity entity = new StringEntity(value);
			entity.setContentType(ContentType.APPLICATION_JSON.toString());
			return entity;
		} catch (JsonProcessingException | UnsupportedEncodingException e) {
			LOGGER.error("Exception while creating HttpEntity object", e);
		}
		return null;
	}
	private static <T> T callGETMethod(String uri, TypeReference<List<Salesman>> typeReference) {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet  getRequest = new HttpGet(PORT.concat(uri));
		try {
			HttpResponse response = client.execute(getRequest);
			return convertJsonToObject(typeReference, response);
		} catch (IOException e) {
			LOGGER.error("Exception while getting response from server", e);
		}
		return null;
	}
	private static <T> T convertJsonToObject(TypeReference<List<Salesman>> typeReference,
			HttpResponse response) throws IOException, JsonParseException, JsonMappingException {
		HttpEntity entity = response.getEntity();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(entity.getContent(), typeReference);
	}
}
