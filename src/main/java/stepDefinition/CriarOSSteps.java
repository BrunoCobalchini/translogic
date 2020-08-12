package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.Login;
import model.entities.OS;
import model.entities.Tela;
import utils.report.Reporter;

import static utils.properties.PropertiesHelper.*;

public class CriarOSSteps extends Reporter {

    Login login = new Login();
    Tela tela = new Tela();
    OS os = new OS();

    @Dado("Que eu esteja na tela de admin do Translogic")
    public void que_eu_esteja_na_tela_de_admin_do_Translogic() {
        login.acessarTranslogic(urlTranslogic);
        login.login(username, password);
        addScreenshotToReport("");
    }

    @Quando("informo o código da tela {string}")
    public void informo_o_código_da_tela(String cod) {
        tela.selecionaTela(cod);
        addLogToReport(cod);
    }

    @Entao("Visualizo a tela Controle de Pré-OS e OS")
    public void visualizo_a_tela_Controle_de_Pré_OS_e_OS() {
        os.validaTelaSelecionada();
    }

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
        os.pesquisaOS();
    }

    @Entao("O botão para preencher a escala do trem é apresentada")
    public void o_botão_para_preencher_a_escala_do_trem_é_apresentada() {
        os.clicaBtnNovaEscala();
    }

    @Dado("Que eu esteja na tela para preencher a escala do trem")
    public void que_eu_esteja_na_tela_para_preencher_a_escala_do_trem() {
        //wip
    }

    @E("Informe o prefixo {string}")
    public void informe_o_prefixo(String prefixo) {
        waitTime(3000);
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
        os.setDataEHoraPartida();
    }

    @Quando("Clico no botão salvar")
    public void clico_no_botão_salvar() {
        os.salvaEscalaTrem();
    }

    @Entao("Visualizo a OS criada")
    public void visualizo_a_OS_criada() {
        //wip
    }

}
