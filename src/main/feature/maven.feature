#language: pt

@GRID @MAVEN
Funcionalidade: Pesquisa de algum repositório no Maven

  Cenário: Pesquisa de repositório no Maven
    Dado a pagina de pesquisa do Maven Repository
    Quando insiro o termo Selenium
    Entao eu valido o resultado esperado
