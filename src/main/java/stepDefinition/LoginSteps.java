package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.entities.Login;
import utils.report.Reporter;

import static utils.properties.PropertiesHelper.*;

public class LoginSteps extends Reporter {

    Login login = new Login();

    @Dado("Que eu esteja na tela de admin do Translogic")
    public void que_eu_esteja_na_tela_de_admin_do_Translogic() {
        login.acessarTranslogic(urlTranslogic);
        login.login(username, password);
        addScreenshotToReport("");
    }

    @Entao("O login foi realizado com sucesso")
    public void o_login_foi_realizado_com_sucesso() {
        login.validarPaginaInicial();
        addScreenshotToReport("");
    }

}
