package model.entities;

import org.openqa.selenium.support.PageFactory;
import utils.baseTest.BaseTest;

public class Google extends BaseTest {

    public Google () {
        PageFactory.initElements(driver, this);
    }

    public void acessarSistema(String url){
        goToURL(url);
    }

    public String validarTitulo(){
        return driver.getTitle();
    }

}
