package model.entities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

public class FormacaoDeTrem extends BaseTest {

    @FindBy(how = How.ID, using = "aba1")
    public WebElement abaAnxPedido;

    @FindBy(how = How.ID, using = "aba2")
    public WebElement abaAnxTracao;

    @FindBy(how = How.ID, using = "aba3")
    public WebElement abaEquipagem;

    @FindBy(how = How.NAME, using = "list1")
    public WebElement listVagao;

    @FindBy(how = How.CSS, using = "select[name='list2'] :nth-child(1)")
    public WebElement vagaoSelecionado;

    @FindBy(how = How.NAME, using = "hora")
    public WebElement setHora;

    @FindBy(how = How.CSS, using = "input[type='button'][value='Desce']")
    public WebElement btnDesce;

    @FindBy(how = How.ID, using = "b_Salvar")
    public WebElement btnSalvar;

    @FindBy(how = How.ID, using = "b_Liberar")
    public WebElement btnLiberar;

    @FindBy(how = How.CSS, using = "input[type='button'][value='>>']")
    public WebElement insereLoco;

    @FindBy(how = How.CSS, using = "[src*='all_ico_novo.gif']")
    public WebElement btnNovoMaquinista;

    @FindBy(how = How.NAME, using = "matricula")
    public WebElement matriculaMaquinista;

    @FindBy(how = How.NAME, using = "HoraLib")
    public WebElement setHoraoraLiberacao;

    @FindBy(how = How.NAME, using = "ate")
    public WebElement validaLiberacao;

    public FormacaoDeTrem () {
        PageFactory.initElements(driver, this);
    }

    public void validaAbaAnxPedido(){
        exist(abaAnxPedido);
        Assert.assertTrue(getText(abaAnxPedido).equals("Anx Pedido"));
    }

    public void selecionaVagao(){
        sendKeys(setHora,"00:00:01");
        selectElementByIndex(listVagao,3);
        clickAndHighlight(btnDesce);
        clickAndHighlight(btnSalvar);
        exist(vagaoSelecionado);
        Assert.assertEquals(colorRGBAToHex(vagaoSelecionado), "#c0c0c0");
    }

    public void selecionaLocomotiva(){
        clickAndHighlight(abaAnxTracao);
        exist(insereLoco);
        sendKeys(setHora,"00:00:02");
        selectElementByIndex(listVagao,3);
        clickAndHighlight(insereLoco);
        clickAndHighlight(btnSalvar);
        alertManagement(); //dismiss
        alertManagement(); //accept
        exist(vagaoSelecionado);
        Assert.assertEquals(colorRGBAToHex(vagaoSelecionado), "#c0c0c0");
    }

    public void clicaBtnNovoMaquinista(){
        clickAndHighlight(abaEquipagem);
        exist(btnNovoMaquinista);
        clickAndHighlight(btnNovoMaquinista);
    }

    public void setMatriculaMaquinista(){
        waitTime(7000);
        switchTabX();
        existFrame("frEquipagem");
        driver.switchTo().activeElement();
        exist(matriculaMaquinista);
        sendKeys(matriculaMaquinista,"123456");
    }

    public void setHora(){
        sendKeys(setHora,"00:00:03");
    }

    public void salvaNovoMaquinista(){
        clickAndHighlight(btnSalvar);
        switchTabX();
        waitTime(5000);
        alertManagement();
        waitTime(3000);
    }

    public void validaMaquinistaSalvo(){
        driver.switchTo().frame("ext-gen113");
        exist(btnNovoMaquinista);
        Assert.assertTrue(btnNovoMaquinista.getAttribute("src").contains("all_ico_novo.gif"));
    }

    public void liberaTrem(){
        exist(btnLiberar);
        clickAndHighlight(btnLiberar);
        alertManagement(); //TBC-limite do trecho
        setHoraoraLiberacao.clear();
        sendKeys(setHoraoraLiberacao,"00:00:04");
        exist(btnLiberar);
        clickAndHighlight(btnLiberar);
        alertManagement(); //Erro ao consultar OS:
        //alert "travas"
        alertManagement(); //Justifique o motivo do atraso
        waitTime(4000);
        alertManagement(); //Liberar Trem
    }

    public void validaLiberacaoTrem(){
        waitTime(5000);
        exist(validaLiberacao);
        Assert.assertTrue(validaLiberacao.isDisplayed());
    }

}
