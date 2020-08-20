package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.ParadaDeTrem;
import utils.report.Reporter;

public class ParadaDeTremSteps extends Reporter {

    ParadaDeTrem paradaDeTrem = new ParadaDeTrem();

    @Dado("Que eu esteja na tela para parar o Trem")
    public void que_eu_esteja_na_tela_para_parar_o_Trem() {
        paradaDeTrem.validaTelaParadaTrem();
        addScreenshotToReport("");
    }

    @E("Seleciono a estação que o trem está parado clicando na lupa")
    public void seleciono_a_estação_que_o_trem_está_parado_clicando_na_lupa() {
        paradaDeTrem.selecionaEstacaoParaParadaTrem();
    }

    @E("Valido os dados de data e hora de saída e data e hora de chegada")
    public void valido_os_dados_de_data_e_hora_de_saída_e_data_e_hora_de_chegada() {
        paradaDeTrem.validaDadosDeChegadaESaida();
    }

    @Quando("Clico em salvar")
    public void clico_em_salvar() {
        paradaDeTrem.salvarParadaDoTrem();
    }

    @Entao("Valido que o Trem está parado")
    public void valido_que_o_Trem_está_parado() {
        paradaDeTrem.validaTremParado();
    }

}
