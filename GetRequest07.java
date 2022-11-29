package stepDefinitions.APİSteps;

import API.baseURL.MedunnaBaseUrl;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.Authentication.generateToken;

public class GetRequest07 extends MedunnaBaseUrl {


    @Test
    public void test1(){

        spec.pathParams("first","patient","second","322339");
        Response response =given().spec(spec).
                header("Authorization","Bearer", generateToken()).when().get("/{first}/{second}");
        response.prettyPrint();

        //MATCHERS CLASS İLE
        response.then().assertThat().body("id",equalTo(322339)
                ,"firstName",equalTo("HASTA")
                ,"lastName",equalTo("FAİK")
                ,"phone",equalTo("767-858-9939")
                ,"gender",equalTo("MALE")
                ,"user.login",equalTo("jonathan")
                ,"user.email",equalTo("ahmet@gmail.com")
                ,"user.ssn",equalTo("128-65-1234")
               ,"speciality",equalTo("NUCLEAR_MEDICINE"));


        // JSON PATH İLE

        JsonPath json =response.jsonPath();
        Assert.assertEquals(322339,json.getInt("id"));
        Assert.assertEquals("HASTA",json.getInt("firstName"));
        Assert.assertEquals("FAİK",json.getInt("lastName"));
        Assert.assertEquals("767-858-9939",json.getInt("phone"));
        Assert.assertEquals("MALE",json.getInt("gender"));
        Assert.assertEquals("jonathan",json.getInt("user.login"));
        Assert.assertEquals("ahmet@gmail.com",json.getInt("user.email"));
        Assert.assertEquals("NUCLER_MEDICINE",json.getInt("speciality"));
    }
}
