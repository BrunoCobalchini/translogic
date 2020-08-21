package model.entities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

public class Tela extends BaseTest {

    @FindBy(how = How.ID, using = "codigo-tela")
    public WebElement codigoTela;

    @FindBy(how = How.CLASS_NAME, using = "TITULO_TEXTO_geral")
    public WebElement validaTelaOS;

    @FindBy(how = How.ID, using = "b_Pesquisar")
    public WebElement validaTelaFormacaoTrem;

    FrameManager frameManager = new FrameManager();

    public Tela () {
        PageFactory.initElements(driver, this);
    }

    public void selecionaTela(String codTela){
        sendKeys(codigoTela, codTela);
        codigoTela.sendKeys(Keys.ENTER);
    }

    public void validaTelaSelecionada(String item, String telaApresentada){

        frameManager.setFrameName(telaApresentada);
        existFrame(frameManager.getFrameName());

        if (telaApresentada.equals("Controle de Pré-OS e OS")){
            Assert.assertTrue(getText(validaTelaOS).equals(item));
        } else if (telaApresentada.equals("Formação Trem")) {
            Assert.assertTrue(getText(validaTelaFormacaoTrem).equals(item));
        } else if (telaApresentada.equals("Movimentação Trem")) {
            Assert.assertTrue(getText(validaTelaFormacaoTrem).equals(item));
        } else if (telaApresentada.equals("Paradas Trem")) {
            Assert.assertTrue(getText(validaTelaFormacaoTrem).equals(item));
        } else if (telaApresentada.equals("Encerramento Trem")) {
            Assert.assertTrue(getText(validaTelaFormacaoTrem).equals(item));
        }
    }

}
