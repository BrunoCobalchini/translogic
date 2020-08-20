#language: pt

  @PARADADETREM @MASSA
  Funcionalidade: Parada de Trem

    Cenário: 05-Parada de Trem
      Dado Que eu esteja na tela de admin do Translogic
      Quando informo o código da tela "302"
      Entao Visualizo o item "Pesquisar" na tela "Movimentação Trem"
      E Pesquiso pela OS
      Dado Que eu esteja na tela para parar o Trem
      E Seleciono a estação que o trem está parado clicando na lupa
      E Valido os dados de data e hora de saída e data e hora de chegada
      Quando Clico em salvar
      Entao Valido que o Trem está parado