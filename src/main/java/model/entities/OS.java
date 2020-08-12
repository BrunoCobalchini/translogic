package model.entities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

public class OS extends BaseTest {

    @FindBy(how = How.CLASS_NAME, using = "TITULO_TEXTO_geral")
    public WebElement validaTelaSelecionada;

    @FindBy(how = How.NAME, using = "visao")
    public WebElement visao;

    @FindBy(how = How.NAME, using = "Data")
    public WebElement dataOS;

    @FindBy(how = How.ID, using = "b_Pesquisar")
    public WebElement pesquisar;

    @FindBy(how = How.CSS, using = "[src*='all_ico_novo.gif']")
    public WebElement btnNovaEscala;

    @FindBy(how = How.NAME, using = "prefixo")
    public WebElement prefixo;

    @FindBy(how = How.NAME, using = "origem")
    public WebElement origem;

    @FindBy(how = How.NAME, using = "destino")
    public WebElement destino;

    @FindBy(how = How.NAME, using = "rota")
    public WebElement rota;

    @FindBy(how = How.NAME, using = "datapartida")
    public WebElement dataPartida;

    @FindBy(how = How.NAME, using = "horapartida")
    public WebElement horaPartida;

    @FindBy(how = How.ID, using = "b_Salvar")
    public WebElement salvar;

    public OS () {
        PageFactory.initElements(driver, this);
    }

    public void validaTelaSelecionada(){
        existFrame("ext-gen113");
        Assert.assertTrue(getText(validaTelaSelecionada).equals("Visão"));
    }

    public void selecionaVisao(String tipoVisao){
        selectElement(visao, tipoVisao);
    }

    public void insereDataAtual(){
        dataOS.clear();
        sendKeys(dataOS, getCurrentDate());
    }

    public void pesquisaOS(){
        clickAndHighlight(pesquisar);
    }

    public void clicaBtnNovaEscala(){
        clickAndHighlight(btnNovaEscala);
    }

    public void setPrefixo(String prefixoOS){
        switchTab();
        sendKeys(prefixo, prefixoOS);
    }

    public void setOrigem(String origemOS){
        sendKeys(origem, origemOS);
    }

    public void setDestino(String destinoOS){
        sendKeys(destino, destinoOS);
    }

    public void setRota(String rotaOS){
        waitTime(4000);
        clickAndHighlight(rota);
        selectElement(rota, rotaOS);
    }

    public void setDataEHoraPartida(){
        sendKeys(dataPartida, getCurrentDate());
        sendKeys(horaPartida, "00:00");
    }

    public void salvaEscalaTrem(){
        clickAndHighlight(salvar);
    }


}
