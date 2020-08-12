package stepDefinition;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.db.DataBaseTest;
import utils.report.Reporter;

public class DataBaseTestSteps extends Reporter {

    DataBaseTest dataBaseTest = new DataBaseTest();

    @Quando("informo um id valido")
    public void informoID(){
        dataBaseTest.dbTest("41");
    }

    @Entao("visualizo o item Acidente")
    public void visualizoItem(){
        System.out.println("Acidente");
    }

}
