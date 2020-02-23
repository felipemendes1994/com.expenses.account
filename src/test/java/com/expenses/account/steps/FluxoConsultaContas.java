package com.expenses.account.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.expenses.account.entity.Account;
import com.expenses.account.entity.AccountRepository;
import com.expenses.account.utility.AccountData;
import com.expenses.account.utility.HttpCommonResponse;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class FluxoConsultaContas {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HttpHeaders defaultHeaders;
	
	@Autowired
	HttpCommonResponse result;
	
	@Dado("^que nao existam registros de conta bancaria$")
	public void que_nao_existam_registros_de_conta_bancaria() throws Throwable {
		assertTrue(accountRepository.findAll().isEmpty());
	}

	@Quando("^a API de GET \"([^\"]*)\" for chamada$")
	public void a_API_de_GET_for_chamada(String uri) throws Throwable {
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(defaultHeaders), String.class);
		result.setBody(response.getBody());
		result.setStatus(response.getStatusCode());
	}

	@Entao("^a API retornara o status (\\d+)$")
	public void a_API_retornara_o_status(int status) throws Throwable {
		assertEquals(status, result.getStatus().value());
	}

	@Dado("^que o seguinte registro de conta bancaria exista$")
	public void que_o_seguinte_registro_de_conta_bancaria_exista(List<AccountData> accountData) throws Throwable {
		for(AccountData acc : accountData) {
			Account account = new Account();
			account.setAccountNumber(acc.getAccountNumber());
			account.setAgencyNumber(acc.getAgencyNumber());
			
			accountRepository.save(account);
		}
	}

	@Entao("^o payload$")
	public void o_payload(String payload) throws Throwable {
		System.out.println(result.getBody());
		JSONAssert.assertEquals(payload, result.getBody(), false);
	}
}
