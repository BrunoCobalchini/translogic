#language: pt

  @FORMACAODETREM @MASSA
  Funcionalidade: Formação de Trem

    Cenário: 03-Formação de Trem
      Dado Que eu esteja na tela de admin do Translogic
      Quando informo o código da tela "300"
      Entao Visualizo o item "Pesquisar" na tela "Formação Trem"
      E Pesquiso pela OS
      Dado Que eu esteja na tela para formar o Trem
      E Selecione o vagão
      E Selecione a locomotiva
      E selecione o maquinista
      Quando Clicar em liberar
      Entao O trem estará liberado