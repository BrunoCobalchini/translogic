package model.entities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

import java.util.List;

public class OS extends BaseTest {

    private static String validaOrigemOS;

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

    @FindBy(how = How.CSS, using = "div[id='linhasGrid']>table[class='TABELA'] :nth-child(1)")
    public List<WebElement> tableOS;

    @FindBy(how = How.NAME, using = "OS")
    public WebElement pesquisaOS;

    @FindBy(how = How.ID, using = "b_Pesquisar")
    public WebElement btnPesquisaOS;

    public OS () {
        PageFactory.initElements(driver, this);
    }

    public void selecionaVisao(String tipoVisao){
        selectElement(visao, tipoVisao);
    }

    public void insereDataAtual(){
        dataOS.clear();
        sendKeys(dataOS, getCurrentDate());
    }

    public void clicaBtnPesquisaOS(){
        clickAndHighlight(pesquisar);
    }

    public void clicaBtnNovaEscala(){
        clickAndHighlight(btnNovaEscala);
    }

    public void setPrefixo(String prefixoOS){
        switchTabX();
        exist(prefixo);
        sendKeys(prefixo, prefixoOS);
    }

    public void setOrigem(String origemOS){
        sendKeys(origem, origemOS);
        this.validaOrigemOS = origemOS;
    }

    public void setDestino(String destinoOS){
        sendKeys(destino, destinoOS);
    }

    public void setRota(String rotaOS){
        waitTime(4000);
        clickAndHighlight(rota);
        selectElement(rota, rotaOS);
    }

    public void setData(){
        sendKeys(dataPartida, getCurrentDate());
    }

    public void setHora(){
        sendKeys(horaPartida, "00:00");
    }

    public void salvaEscalaTrem(){
        clickAndHighlight(salvar);
        waitTime(3500);
        if(driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void handlingTable(){
        switchTabX();
        existFrame("ext-gen113");
        Assert.assertTrue(getText(validaTelaSelecionada).equals("Visão"));
        String resultData = tableOS.get(0).getText().trim();
        Assert.assertTrue(resultData.contains(validaOrigemOS));
    }

    public void pesquisaOS(){
        sendKeys(pesquisaOS,"1736689");
        clickAndHighlight(btnPesquisaOS);
    }

}
