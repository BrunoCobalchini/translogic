package stepDefinition;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.Tela;
import utils.report.Reporter;

public class TelaSteps extends Reporter {

    Tela tela = new Tela();

    @Quando("informo o código da tela {string}")
    public void informo_o_código_da_tela(String cod) {
        tela.selecionaTela(cod);
        addLogToReport(cod);
    }

    @Entao("Visualizo o item {string} na tela {string}")
    public void visualizo_o_item_na_tela(String item, String telaApresentada) {
        tela.validaTelaSelecionada(item, telaApresentada);
        addScreenshotToReport(telaApresentada);
    }

}
