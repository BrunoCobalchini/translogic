package model.entities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

import java.util.List;

public class MovimentacaoDeTrem extends BaseTest {

    @FindBy(how = How.CSS, using = "[src*='all_ico_lupa.gif']")
    public List<WebElement> lupa;

    @FindBy(how = How.CSS, using = "tr[class='TABELA_cor_linha']")
    public List<WebElement> tableRoteiroTrem;

    @FindBy(how = How.NAME, using = "dataChegada")
    public WebElement dataChegada;

    @FindBy(how = How.NAME, using = "chegadaPrevista")
    public WebElement chegadaPrevista;

    @FindBy(how = How.NAME, using = "horaChegada")
    public WebElement horaChegada;

    public MovimentacaoDeTrem () {
        PageFactory.initElements(driver, this);
    }

    public void validaTelaMovimentacaoTrem(){
        exist(lupa.get(0));
        Assert.assertTrue(lupa.get(0).getAttribute("src").contains("all_ico_lupa.gif"));
    }

    public void selecionaEstacaoParaMovimentacao(){

        String estacao = "ZBV-PC";

        for (int i = 0; i < tableRoteiroTrem.size(); i++){
            //System.out.println("Items: " + tableRoteiroTrem.get(i).getText());
            if (tableRoteiroTrem.get(i).getText().contains(estacao)){
                System.out.println("Items: " + tableRoteiroTrem.get(i).getText() + "; i: " + i);
                clickAndHighlight(lupa.get(i));
                break;
            } else if (estacao.equals("fullTrip")) {
                if (tableRoteiroTrem.get(i).getText().contains("-PC")) {
                    System.out.println("Items: " + tableRoteiroTrem.get(i).getText() + "; i: " + i);
                } else {
                    System.out.println("Não foram encontradas estações Centrais");
                }
            }
        }
    }

    public void setDataChegada(){
        exist(dataChegada);
        sendKeys(dataChegada, getCurrentDate());
    }

    public void setHoraChegada(){
        String horaChegadaPrevista = chegadaPrevista.getAttribute("value");
        System.out.println("Hora da chegada prevista: " + horaChegadaPrevista.substring(17));
        waitTime(5000);
    }

}
