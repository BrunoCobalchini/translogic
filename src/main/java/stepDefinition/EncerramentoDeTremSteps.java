package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.EncerramentoDeTrem;
import utils.report.Reporter;

public class EncerramentoDeTremSteps extends Reporter {

    EncerramentoDeTrem encerramentoDeTrem = new EncerramentoDeTrem();

    @E("Pesquiso pela OS para encerramento do Trem")
    public void pesquiso_pela_OS_para_encerramento_do_Trem() {
        encerramentoDeTrem.pesquisaOSEncerramentoTrem();
        addScreenshotToReport("");
    }

    @Dado("Que eu esteja na tela para encerrar o Trem")
    public void que_eu_esteja_na_tela_para_encerrar_o_Trem() {
        encerramentoDeTrem.validaTelaEncerramentoTrem();
    }

    @E("Seleciono a ordem de serviço clicando na lupa")
    public void seleciono_a_ordem_de_serviço_clicando_na_lupa() {
        encerramentoDeTrem.selecionaOSParaEncerramentoTrem();
    }

    @E("Informo a hora")
    public void informo_a_hora() {
        encerramentoDeTrem.setHora();
    }

    @E("Informo o motivo {string}")
    public void informo_o_motivo(String motivo) {
        encerramentoDeTrem.setMotivo(motivo);
    }

    @E("Informo a linha {string}")
    public void informo_a_linha(String linha) {
        encerramentoDeTrem.setLinha(linha);
        addScreenshotToReport("");
        waitTime(5000);
    }

    @Quando("Clicar em salvar encerramento")
    public void clicar_em_salvar_encerramento() {
        //encerramentoDeTrem.salvarEncerramento();
    }

    @Entao("Valido que o encerramento ocorreu com sucesso")
    public void valido_que_o_encerramento_ocorreu_com_sucesso() {
        // wip
    }

}
