package stepDefinition;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.api.APITest;
import utils.report.Reporter;

public class ApiTestSteps extends Reporter {

    APITest apiTest = new APITest();

    @Quando("informo o {string} da API")
    public void informoIDAPI(String idAPI){
        apiTest.apiTest(idAPI);
    }

    @Entao("visualizo os resultados do id")
    public void visualizoOsResultadosDoID(){
        //wip
    }

}
