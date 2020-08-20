package model.entities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

import java.util.List;

public class ParadaDeTrem extends BaseTest {

    @FindBy(how = How.CSS, using = "[src*='all_ico_lupa.gif']")
    public List<WebElement> lupa;

    @FindBy(how = How.CSS, using = "tr[class='TABELA_cor_linha']")
    public List<WebElement> tableRoteiroTrem;

    @FindBy(how = How.CSS, using = "form[name='formBase']>table+table>tbody :nth-child(4)")
    public List<WebElement> tableDadosChegadaESaida;

    @FindBy(how = How.ID, using = "b_Salvar")
    public WebElement btnSalvar;

    @FindBy(how = How.CSS, using = "[src*='all_ico_novo.gif']")
    public WebElement btnTremParado;

    public ParadaDeTrem () {
        PageFactory.initElements(driver, this);
    }

    public void validaTelaParadaTrem(){
        exist(lupa.get(0));
        Assert.assertTrue(lupa.get(0).getAttribute("src").contains("all_ico_lupa.gif"));
    }

    public void selecionaEstacaoParaParadaTrem(){

        String estacao = "ZBI-PC";

        for (int i = 0; i < tableRoteiroTrem.size(); i++){
            if (tableRoteiroTrem.get(i).getText().contains(estacao)){
                System.out.println("Estação de Parada: " + tableRoteiroTrem.get(i).getText() + "; i: " + i);
                clickAndHighlight(lupa.get(i));
                break;
            }
        }
    }

    public void validaDadosDeChegadaESaida(){
        boolean dadosEncontrados = false;
        String dadosChegadaESaida = "19/08/2020 00:09:04";
        for (int i = 0; i < tableDadosChegadaESaida.size(); i++){
            if (tableDadosChegadaESaida.get(i).getText().contains(dadosChegadaESaida)){
                System.out.println("Dados de chegada e saída: " + tableDadosChegadaESaida.get(i).getText());
                dadosEncontrados = true;
                break;
            }
        }
        Assert.assertTrue(dadosEncontrados,"Dados de chegada e saída inválidos");
    }

    public void salvarParadaDoTrem(){
        clickAndHighlight(btnSalvar);
    }

    public void validaTremParado(){
        Assert.assertTrue(btnTremParado.isDisplayed());

    }

}
