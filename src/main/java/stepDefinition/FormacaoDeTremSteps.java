package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.FormacaoDeTrem;
import utils.report.Reporter;

public class FormacaoDeTremSteps extends Reporter {

    FormacaoDeTrem formacaoDeTrem = new FormacaoDeTrem();

    @Dado("Que eu esteja na tela para formar o Trem")
    public void que_eu_esteja_na_tela_para_formar_o_Trem() {
        formacaoDeTrem.validaAbaAnxPedido();
    }

    @E("Selecione o vagão")
    public void selecione_o_vagão() {
        formacaoDeTrem.selecionaVagao();
        waitTime(5000);
    }

    @E("Selecione a locomotiva")
    public void selecione_a_locomotiva() {
        formacaoDeTrem.selecionaLocomotiva();
    }

    @E("selecione o maquinista")
    public void selecione_o_maquinista() {
        // wip
    }

    @Quando("Clicar em liberar")
    public void clicar_em_liberar() {
        // wip
    }

}
