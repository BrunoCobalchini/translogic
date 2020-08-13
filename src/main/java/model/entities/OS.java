package model.entities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

import java.util.Arrays;
import java.util.List;

public class OS extends BaseTest {

    private static String validaOrigemOS;
    private static String currentWindow;
    private static String newWindow;

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

    @FindBy(how = How.CSS, using = "[src*='all_ico_lupa.gif']")
    public WebElement lupa;

    public OS () {
        PageFactory.initElements(driver, this);
    }

    public void validaTelaSelecionada(){
        existFrame("ext-gen113");
        Assert.assertTrue(getText(validaTelaSelecionada).equals("Visão"));
        currentWindow = driver.getWindowHandle();
        System.out.println("Current handle: " + currentWindow);
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
        newWindow = driver.getWindowHandle();
        System.out.println("new handle: " + newWindow);
        driver.switchTo().window(newWindow);
        //switchTab();
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
        waitTime(2500);
    }

    public void handlingTable(){
        waitTime(5000);
        driver.switchTo().window(currentWindow);
        //switchTab();
        waitTime(5000);
        clickAndHighlight(lupa);
        String resultData = tableOS.get(0).getText().trim();
        Assert.assertTrue(resultData.contains(validaOrigemOS));
    }


}
