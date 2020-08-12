package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import model.entities.Google;
import org.testng.Assert;
import utils.report.Reporter;

import static utils.properties.PropertiesHelper.*;

public class GoogleSteps extends Reporter {

    Google google = new Google();

    @Dado("a pagina inicial do google")
    public void paginaInicialGoogle(){
        google.acessarSistema(urlGoogle);
    }
    @Entao("eu valido o título")
    public void validoTitulo(){
        Assert.assertEquals(google.validarTitulo(), "Google");
        addScreenshotToReport("");
        System.out.println("**** Tread " + Thread.currentThread().getId());
    }

}
