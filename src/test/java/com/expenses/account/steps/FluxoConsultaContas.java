package com.expenses.account.steps;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.expenses.account.entity.AccountRepository;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class FluxoConsultaContas {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Dado("^que nao existam registros de conta bancaria$")
	public void que_nao_existam_registros_de_conta_bancaria() throws Throwable {
		assertTrue(accountRepository.findAll().isEmpty());
	}

	@Quando("^a API de GET \"([^\"]*)\" for chamada$")
	public void a_API_de_GET_for_chamada(String uri) throws Throwable {
		
	}

	@Entao("^a API retornara o status (\\d+)$")
	public void a_API_retornara_o_status(int status) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que o seguinte registro de conta bancaria exista$")
	public void que_o_seguinte_registro_de_conta_bancaria_exista(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@Entao("^o payload$")
	public void o_payload(String payload) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
