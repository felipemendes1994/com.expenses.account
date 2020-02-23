#language: pt
Funcionalidade: Fluxo de Criacao de Conta

	Cenario: Requisicao de criacao de conta que nao existe
		Dado que nao existam registros de conta bancaria
		Quando a API de POST "/accounts" for chamada com o payload
		"""
			{
				"bankName": "Banco Intermedium S/A",
				"bankNumber": "077",
				"agencyNumber": "0001-9",
				"accountNumber": "19977530"
			}
		"""
		Entao a API retornara o status 201
		E havera o seguinte registro no banco de dados
		| agencyNumber | accountNumber | bankName 						 | bankNumber |
		| 0001-9  		 | 19977530      | Banco Intermedium S/A | 077    		|
	
	Cenario: Requisicao de criacao de conta que ja existe
		Dado que o seguinte registro de conta bancaria ja exista
		| agencyNumber | accountNumber | bankName 						 | bankNumber |
		| 0001-9  		 | 19977530      | Banco Intermedium S/A | 077    		|
		Quando a API de POST "/accounts" for chamada com o payload
		"""
			{
				"bankName": "Banco Intermedium S/A",
				"bankNumber": "077",
				"agencyNumber": "0001-9",
				"accountNumber": "19977530"
			}
		"""
		Entao a API retornara o status 409