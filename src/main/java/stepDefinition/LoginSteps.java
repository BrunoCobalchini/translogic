package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.Login;
import utils.report.Reporter;

import static utils.properties.PropertiesHelper.*;

public class LoginSteps extends Reporter {

    Login login = new Login();

    @Dado("Que eu esteja na tela de login do Translogic")
    public void que_eu_esteja_na_tela_de_login_do_Translogic() {
        login.acessarTranslogic(urlTranslogic);
        addScreenshotToReport("");
    }

    @Quando("Eu insiro credenciais válidas")
    public void eu_insiro_credenciais_válidas() {
        login.login(username, password);
        addLogToReport("Username: " + username);
    }

    @Entao("Tenho acesso a área restrita")
    public void tenho_acesso_a_área_restrita() {
        login.validarPaginaInicial();
        addScreenshotToReport("");
    }
}
