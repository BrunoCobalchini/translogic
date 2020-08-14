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

    @FindBy(how = How.NAME, using = "list1")
    public WebElement listVagao;

    @FindBy(how = How.NAME, using = "hora")
    public WebElement setHora;

    @FindBy(how = How.CSS, using = "input[type='button'][value='Desce']")
    public WebElement btnDesce;

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
    }

    public void selecionaLocomotiva(){
        clickAndHighlight(abaAnxTracao);
        waitTime(12000);
    }

}
