#language: pt
Funcionalidade: Fluxo de consulta de conta bancaria

	Cenario: Consulta de conta bancaria inexistente
		Dado que nao existam registros de conta bancaria
		Quando a API de GET "/accounts/19977530/agencies/0001-9" for chamada
		Entao a API retornara o status 404
	
	Cenario: Consulta de conta bancaria existente
		Dado que o seguinte registro de conta bancaria exista
		| agency | account  |
		| 0001-9 | 19977530 |
		Quando a API de GET "/accounts/19977530/agencies/0001-9" for chamada
		Entao a API retornara o status 200
		E o payload
		"""
		
		"""