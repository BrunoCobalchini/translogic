#language: pt

  @ENCERRAMENTODETREM @MASSA
  Funcionalidade: Encerramento de Trem

    Cenário: 06-Encerramento de Trem
      Dado Que eu esteja na tela de admin do Translogic
      Quando informo o código da tela "303"
      Entao Visualizo o item "Pesquisar" na tela "Encerramento Trem"
      E Pesquiso pela OS para encerramento do Trem
      Dado Que eu esteja na tela para encerrar o Trem
      E Seleciono a ordem de serviço clicando na lupa
      E Informo a hora
      E Informo o motivo "Destino"
      E Informo a linha "L999"
      Quando Clicar em salvar encerramento
      Entao Valido que o encerramento ocorreu com sucesso