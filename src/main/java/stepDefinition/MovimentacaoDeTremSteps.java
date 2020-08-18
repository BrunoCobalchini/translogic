package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import model.entities.MovimentacaoDeTrem;
import utils.report.Reporter;

public class MovimentacaoDeTremSteps extends Reporter {

    MovimentacaoDeTrem movimentacaoDeTrem = new MovimentacaoDeTrem();

    @Dado("Que eu esteja na tela para movimentar o Trem")
    public void que_eu_esteja_na_tela_para_movimentar_o_Trem() {
        movimentacaoDeTrem.validaTelaMovimentacaoTrem();
        addScreenshotToReport("");
    }

    @E("Seleciono a estação clicando na lupa")
    public void seleciono_a_estação_clicando_na_lupa() {
        movimentacaoDeTrem.selecionaEstacaoParaMovimentacao();
    }

    @E("Preencho a data de chegada")
    public void preencho_a_data_de_chegada() {
        movimentacaoDeTrem.setDataChegada();
    }

    @E("Preencho a hora de chegada")
    public void preencho_a_hora_de_chegada() {
        movimentacaoDeTrem.setHoraChegada();
    }

}
