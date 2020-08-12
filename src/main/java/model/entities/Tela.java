package model.entities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.baseTest.BaseTest;

public class Tela extends BaseTest {

    @FindBy(how = How.ID, using = "codigo-tela")
    public WebElement codigoTela;

    public Tela () {
        PageFactory.initElements(driver, this);
    }

    public void selecionaTela(String codTela){
        sendKeys(codigoTela, codTela);
        codigoTela.sendKeys(Keys.ENTER);
    }

}
