#language: pt

  @GRID
  Funcionalidade: Validar um consulta via API com RestAssured

  Esquema do Cenario: <CT> - Visualiza a página com o id <ID_API>
    Quando informo o "<ID_API>" da API
    Entao visualizo os resultados do id

    Exemplos:
      | CT   | ID_API |
      | CT01 | 1    |
      | CT02 | 2    |
