package model.entities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.baseTest.BaseTest;

public class Maven extends BaseTest {

    @FindBy(how = How.ID, using = "query")
    public WebElement searchInputTextMaven;

    public Maven (){
        PageFactory.initElements(driver, this);
    }

    public void acessarSistema(String url){
        goToURL(url);
    }

    public void realizarBusca(){
        sendKeys(searchInputTextMaven,"Selenium");
    }



}
