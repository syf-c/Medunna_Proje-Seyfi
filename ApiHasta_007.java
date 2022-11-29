package stepDefinitions.APİSteps;

import API.pojos.hastapojos007.CountryInn;
import API.pojos.hastapojos007.hasta;
import API.pojos.hastapojos007.userIn;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static utilities.Authentication.generateToken;

public class ApiHasta_007 {
    @Then("hasta api doğrulama")
    public void hastaApiDoğrulama() {

        String Url = "https://www.medunna.com/api/appointments/356037";

        CountryInn countryInn = new CountryInn(356037, "Turkiyee");
        userIn userIn = new userIn("anonymousUser",
                "2021-12-25T15:59:36.508061Z",
                3309, "jonathan", "Gok",
                "ahmet@gmail.com",
                "en",
                null,

                true,
                "128-65-1234");
        hasta expecData = new hasta("batch81", "2022-11-22T13:05:58.553491Z", 322339, "HASTA", "FAİK",
                "1979-11-21T21:00:00Z", "7678589939", "MALE",
                "Apositive", "ortaköy", "hastafaik@gmail.com",
                "boğaz enfeksiyon", userIn, null, null, countryInn,
                null);


        System.out.println(expecData);
        Response response = given().contentType(ContentType.JSON).
                headers("Authorization", "Bearer " + generateToken()).when().get(Url);
        response.prettyPrint();

        hasta actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), hasta.class);
        System.out.println(actualData);

        assertEquals(expecData.getCreatedDate(), actualData.getCreatedDate());
        assertEquals(expecData.getId(), actualData.getId());


    }
}
