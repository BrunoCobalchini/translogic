package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.Maven;
import utils.report.Reporter;

import static utils.properties.PropertiesHelper.*;

public class MavenSteps extends Reporter {

    Maven maven = new Maven();

    @Dado("a pagina de pesquisa do Maven Repository")
    public void paginaDePesquisaDoGoogle(){
        maven.acessarSistema(urlMvn);
        maven.realizarBusca();
        addScreenshotToReport("");
        addLogToReport("Página inicial do Maven - Template");
        System.out.println("**** Tread " + Thread.currentThread().getId());
    }
    @Quando("insiro o termo Selenium")
    public void insiroOTermoSelenium(){
        //wip
    }
    @Entao("eu valido o resultado esperado")
    public void euValidoOResultadoEsperado(){
        //wip
    }
}
