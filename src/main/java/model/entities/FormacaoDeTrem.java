package model.entities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

import java.util.List;

public class FormacaoDeTrem extends BaseTest {

    @FindBy(how = How.ID, using = "aba1")
    public WebElement abaAnxPedido;

    @FindBy(how = How.ID, using = "aba2")
    public WebElement abaAnxTracao;

    @FindBy(how = How.ID, using = "aba3")
    public WebElement abaEquipagem;

    @FindBy(how = How.NAME, using = "list1")
    public WebElement listVagao;

    @FindBy(how = How.NAME, using = "list2")
    public WebElement listVagaoDesce;

    @FindBy(how = How.CSS, using = "select[name='list2'] :nth-child(1)")
    public WebElement vagaoSelecionado;

    @FindBy(how = How.NAME, using = "hora")
    public WebElement setHora;

    @FindBy(how = How.CSS, using = "input[type='button'][value='Desce']")
    public WebElement btnDesce;

    @FindBy(how = How.ID, using = "b_Salvar")
    public WebElement btnSalvar;

    @FindBy(how = How.CSS, using = "input[type='button'][value='>>']")
    public WebElement insereLoco;

    @FindBy(how = How.CSS, using = "[src*='all_ico_novo.gif']")
    public WebElement btnNovoMaquinista;

    @FindBy(how = How.NAME, using = "matricula")
    public WebElement matriculaMaquinista;

    @FindBy(how = How.CSS, using = "iframe[name='frEquipagem']")
    public WebElement frameTest;

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
        switchTabX();
        System.out.println("Frame props: " + frameTest.getAttribute("src"));
        exist(matriculaMaquinista);
        sendKeys(matriculaMaquinista,"123456");
    }

    public void setHora(){
        sendKeys(setHora,"00:00:03");
    }

    public void salvaNovoMaquinista(){
        clickAndHighlight(btnSalvar);
        alertManagement();
/*        waitTime(3500);
        if(driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }*/
    }

    public void validaMaquinistaSalvo(){
        waitTime(5000);
        switchTabX();
        exist(btnNovoMaquinista);
    }

    @FindBy(how = How.CSS, using = "input[name'matricula']")
    public WebElement tableOS;

    public void teste(){
        clickAndHighlight(abaEquipagem);
        exist(btnNovoMaquinista);
        clickAndHighlight(btnNovoMaquinista);

        switchTabX();

        String url = frameTest.getAttribute("src");

        System.out.println("Frame props: " + frameTest.getAttribute("src"));
        //System.out.println("Frame props: " + frameTest.getTagName());
        waitTime(5000);

        exist(matriculaMaquinista);
        sendKeys(matriculaMaquinista,"123456");

        sendKeys(setHora,"00:00:03");

        clickAndHighlight(btnSalvar);
        alertManagement();

        waitTime(5000);
        switchTabX();
        exist(btnNovoMaquinista);
    }

}
