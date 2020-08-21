package model.entities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

import java.util.List;

public class EncerramentoDeTrem extends BaseTest {

    @FindBy(how = How.CSS, using = "input[name='ordemForm']")
    public WebElement pesquisaOSTela303;

    @FindBy(how = How.ID, using = "b_Pesquisar")
    public WebElement btnPesquisar;

    @FindBy(how = How.CSS, using = "[src*='all_ico_lupa.gif']")
    public List<WebElement> lupa;

    @FindBy(how = How.CSS, using = "tr[class='TABELA_cor_linha']")
    public List<WebElement> tableOSTrem;

    @FindBy(how = How.CSS, using = "input[name='hora']")
    public WebElement horaEncerramento;

    @FindBy(how = How.NAME, using = "motivo")
    public WebElement motivo;

    @FindBy(how = How.CSS, using = "input[name='linha']")
    public WebElement linha;

    @FindBy(how = How.ID, using = "b_Salvar")
    public WebElement btnSalvar;

    public EncerramentoDeTrem () {
        PageFactory.initElements(driver, this);
    }

    public void pesquisaOSEncerramentoTrem(){
        exist(pesquisaOSTela303);
        sendKeys(pesquisaOSTela303,"1736708");
        clickAndHighlight(btnPesquisar);
    }

    public void validaTelaEncerramentoTrem(){
        exist(lupa.get(0));
        Assert.assertTrue(lupa.get(0).getAttribute("src").contains("all_ico_lupa.gif"));
    }

    public void selecionaOSParaEncerramentoTrem(){

        String OS = "1736708";

        for (int i = 0; i < tableOSTrem.size(); i++){
            if (tableOSTrem.get(i).getText().contains(OS)){
                System.out.println("OS para encerramento: " + tableOSTrem.get(i).getText() + "; i: " + i);
                clickAndHighlight(lupa.get(i));
                break;
            }
        }
    }

    public void setHora(){
        String horaAtual = getCurrentHour();
        System.out.println("Hora atual: " + horaAtual);
        exist(horaEncerramento);
        sendKeys(horaEncerramento, horaAtual);
    }

    public void setMotivo(String motivoParam){
        selectElement(motivo, motivoParam);
    }

    public void setLinha(String linhaParam){
        sendKeys(linha, linhaParam);
    }

    public void salvarEncerramento(){
        clickAndHighlight(btnSalvar);
    }

    public void validaEncerramentoDoTrem(){
        //wip
    }

}
