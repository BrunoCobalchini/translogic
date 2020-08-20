package model.entities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.baseTest.BaseTest;

import java.text.NumberFormat;
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

    @FindBy(how = How.NAME, using = "dataSaida")
    public WebElement dataSaida;

    @FindBy(how = How.NAME, using = "saidaPrevista")
    public WebElement saidaPrevista;

    @FindBy(how = How.NAME, using = "horaSaida")
    public WebElement horaSaida;

    @FindBy(how = How.ID, using = "b_Salvar")
    public WebElement btnSalvar;

    @FindBy(how = How.ID, using = "b_Sair")
    public WebElement btnSair;

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
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(2);

        if (!horaChegada.getAttribute("value").isEmpty()) {
            String horaChegadaPrevista = chegadaPrevista.getAttribute("value");
            horaChegadaPrevista = horaChegadaPrevista.substring(11);

            String[] horaChegadaPrevistaSplit = horaChegadaPrevista.split(":");

            int a = Integer.parseInt(horaChegadaPrevistaSplit[0]);
            int b = Integer.parseInt(horaChegadaPrevistaSplit[1]);
            int c = Integer.parseInt(horaChegadaPrevistaSplit[2]) + 1;

            sendKeys(horaChegada,nf.format(a) + nf.format(b) + nf.format(c));
        } else {
            System.out.println("Primeira movimentação do trem já foi realizada");
        }
    }

    public void setDataSaida(){
        exist(dataSaida);
        sendKeys(dataSaida, getCurrentDate());
    }

    public void setHoraSaida(){
        String horaSaidaPrevista = saidaPrevista.getAttribute("value");
        horaSaidaPrevista = horaSaidaPrevista.substring(11);
        sendKeys(horaSaida,horaSaidaPrevista);
    }

    public void salvarMovimentacaoTrem(){
        clickAndHighlight(btnSalvar);
    }

    public void sairMovimentacaoTrem(){
        exist(btnSair);
        clickAndHighlight(btnSair);
    }

    public void validaMovimentacaoTrem(){
        boolean dadosMovimentacaDoTrem = false;
        String dadosMovimentacao = "ZBV-PC 19/08/2020 00:05:05 19/08/2020 00:07:04";
        System.out.println("**** VALIDA MOVIMENTAÇÃO DE TREM ****");
        for (int i = 0; i < tableRoteiroTrem.size(); i++){
            if (tableRoteiroTrem.get(i).getText().contains(dadosMovimentacao)){
                System.out.println("Movimentação: " + tableRoteiroTrem.get(i).getText());
                dadosMovimentacaDoTrem = true;
                break;
            }
        }
        Assert.assertTrue(dadosMovimentacaDoTrem, "Dados de movimentação inválidos");
    }

}
