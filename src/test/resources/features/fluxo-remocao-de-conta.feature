#language: pt
Funcionalidade: Fluxo de Remocao de Conta

	Cenario: Requisicao de remocao de conta que nao existe
		Dado que nao existam registros de conta bancaria
		Quando a API de DELETE "/accounts/19977530/agencies/0001-9" for chamada
		Entao a API retornara o status 404
		
	Cenario: Requisicao de remocao de conta existente
		Dado que o seguinte registro de conta bancaria ja exista
		| agencyNumber | accountNumber | bankName 						 | bankNumber |
		| 0001-9  		 | 19977530      | Banco Intermedium S/A | 077    		|
		Quando a API de DELETE "/accounts/19977530/agencies/0001-9" for chamada
		Entao a API retornara o status 204