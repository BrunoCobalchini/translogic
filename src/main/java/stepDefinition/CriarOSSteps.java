package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.OS;
import utils.report.Reporter;

import static utils.properties.PropertiesHelper.*;

public class CriarOSSteps extends Reporter {

    OS os = new OS();

    @E("Mudo a visão para {string}")
    public void mudo_a_visão_para(String tipoVisao) {
        os.selecionaVisao(tipoVisao);
        addScreenshotToReport(tipoVisao);
    }

    @E("Altero a data para a data atual")
    public void altero_a_data_para_a_data_atual() {
        os.insereDataAtual();
    }

    @Quando("Clico em pesquisar")
    public void clico_em_pesquisar() {
        os.clicaBtnPesquisaOS();
    }

    @Entao("O botão para preencher a escala do trem é apresentada")
    public void o_botão_para_preencher_a_escala_do_trem_é_apresentada() {
        os.clicaBtnNovaEscala();
        addScreenshotToReport("");
    }

    @Dado("Que eu esteja na tela para preencher a escala do trem")
    public void que_eu_esteja_na_tela_para_preencher_a_escala_do_trem() {
        //wip
    }

    @E("Informe o prefixo {string}")
    public void informe_o_prefixo(String prefixo) {
        os.setPrefixo(prefixo);
    }

    @E("Informe a origem {string}")
    public void informe_a_origem(String origem) {
        os.setOrigem(origem);
    }

    @E("Informe o destino {string}")
    public void informe_o_destino(String destino) {
        os.setDestino(destino);
    }

    @E("Selecione a rota {string}")
    public void selecione_a_rota(String rota) {
        os.setRota(rota);
    }

    @E("Informe a data e hora")
    public void informe_a_data_e_hora() {
        os.setData();
        os.setHora();
    }

    @Quando("Clico no botão salvar")
    public void clico_no_botão_salvar() {
        addScreenshotToReport("");
        os.salvaEscalaTrem();
    }

    @Entao("Visualizo a OS criada")
    public void visualizo_a_OS_criada() {
        os.handlingTable();
        addScreenshotToReport("");
    }

    @E("Pesquiso pela OS")
    public void pesquiso_pela_OS() {
        os.pesquisaOS();
    }

}
