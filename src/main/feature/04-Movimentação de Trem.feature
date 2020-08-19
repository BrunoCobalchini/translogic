#language: pt

  @MOVIMENTACAODETREM @MASSA
  Funcionalidade: Movimentação de Trem

    Cenário: 04-Movimentação de Trem
      Dado Que eu esteja na tela de admin do Translogic
      Quando informo o código da tela "301"
      Entao Visualizo o item "Pesquisar" na tela "Movimentação Trem"
      E Pesquiso pela OS
      Dado Que eu esteja na tela para movimentar o Trem
      E Seleciono a estação clicando na lupa
      E Preencho a data de chegada
      E Preencho a hora de chegada
      E Preencho a data de saída
      E Preencho a hora de saída
      Quando Eu clicar no botão salvar
      E Eu clicar no botão sair
      Entao Visualizo a movimentação do Trem