package com.expenses.account.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

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

public class FluxoCriacaoContas {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HttpHeaders defaultHeaders;
	
	@Autowired
	HttpCommonResponse result;
	
	@Quando("^a API de POST \"([^\"]*)\" for chamada com o payload$")
	public void a_API_de_POST_for_chamada_com_o_payload(String uri, String payload) throws Throwable {
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(payload, defaultHeaders), String.class);
		result.setStatus(response.getStatusCode());
	}

	@Entao("^havera o seguinte registro no banco de dados$")
	public void havera_o_seguinte_registro_no_banco_de_dados(List<AccountData> accountData) throws Throwable {
		List<Account> account = accountRepository.findAll();
		
		assertEquals(account.size(), 1);
		
		for(AccountData acc : accountData) {
			assertEquals(acc.getAccountNumber(), account.get(0).getAccountNumber());
			assertEquals(acc.getAgencyNumber(), account.get(0).getAgencyNumber());
			assertEquals(acc.getBankNumber(), account.get(0).getBankNumber());
			assertEquals(acc.getBankName(), account.get(0).getBankName());
		}
	}
	
	@Dado("^que o seguinte registro de conta bancaria ja exista$")
	public void que_o_seguinte_registro_de_conta_bancaria_ja_exista(List<AccountData> accountData) throws Throwable {
		for(AccountData acc : accountData) {
			accountRepository.save(acc.toAccount());
		}
	}
}
