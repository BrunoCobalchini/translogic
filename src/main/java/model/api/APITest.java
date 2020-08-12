package model.api;

import utils.baseTest.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class APITest extends BaseTest {

    public void apiTest(String idAPI){
        String url = "https://reqres.in/api/users";

        given().
                param("page", idAPI).
        when().
                get(url).
        then().
                log().all().
                statusCode(200).
                body("page", equalTo(1));
    }

}
