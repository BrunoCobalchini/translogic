package model.entities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

public class Login extends BaseTest {

    @FindBy(how = How.ID, using = "info_Usuario")
    public WebElement user;

    @FindBy(how = How.ID, using = "info_Senha")
    public WebElement password;

    @FindBy(how = How.CLASS_NAME, using = "button-primary")
    public WebElement conectar;

    @FindBy(how = How.ID, using = "timeout-info")
    public WebElement sessaoExpira;

    public Login () {
        PageFactory.initElements(driver, this);
    }

    public void acessarTranslogic(String url){
        goToURL(url);
    }

    public void login(String usuario, String senha){
        sendKeys(user, usuario);
        sendKeys(password, senha);
        clickAndHighlight(conectar);
    }

    public void validarPaginaInicial() {
        Assert.assertTrue(getText(sessaoExpira).contains("Sessão expira em:"));
    }
}
