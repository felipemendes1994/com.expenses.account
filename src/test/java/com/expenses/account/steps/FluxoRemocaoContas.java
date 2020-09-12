package com.expenses.account.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.expenses.account.utility.HttpCommonResponse;

import cucumber.api.java.pt.Quando;

public class FluxoRemocaoContas {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HttpHeaders defaultHeaders;
	
	@Autowired
	HttpCommonResponse result;
	
	@Quando("^a API de DELETE \"([^\"]*)\" for chamada$")
	public void a_API_de_DELETE_for_chamada(String uri) throws Throwable {
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.DELETE, new HttpEntity<>(defaultHeaders), String.class);
		result.setStatus(response.getStatusCode());
	}
}
