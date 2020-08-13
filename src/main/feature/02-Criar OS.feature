#language: pt

  @CRIAROS
  Funcionalidade: Criar OS

    Cenário: 02-Criar OS
      Dado Que eu esteja na tela de admin do Translogic
      Quando informo o código da tela "433"
      Entao Visualizo a tela Controle de Pré-OS e OS
      E Mudo a visão para "OS"
      E Altero a data para a data atual
      Quando Clico em pesquisar
      Entao O botão para preencher a escala do trem é apresentada
      Dado Que eu esteja na tela para preencher a escala do trem
      E Informe o prefixo "AA6"
      E Informe a origem "ZBL"
      E Informe o destino "ZAC"
      E Selecione a rota "ZBL-ZBV-ZAC"
      E Informe a data e hora
      Quando Clico no botão salvar
      Entao Visualizo a OS criada