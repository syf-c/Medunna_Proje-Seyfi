package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.medunnaPage007;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US007_HastaStepDefinition {

    medunnaPage007 medunna = new medunnaPage007();


    @Then("{int} saniye bekler")
    public void saniyeBekler(int sn) {
        ReusableMethods.waitFor(sn);
    }


    @Given("Hasta Medunna Ana sayfasına gider")
    public void hastaMedunnaAnaSayfasınaGider() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @When("Hasta Make an Appointment butonunu basar")

    public void hastaMakeAnAppointmentButonunuBasar() {

        medunna.Appointment.click();
    }

    @And("Hasta First Name {string} girer")

    public void hastaFirstNameGirer(String isim) {

        medunna.FirstName.sendKeys(isim);
    }

    @And("Hasta SSN {string} girer")
    public void hastaSSNGirer(String ssn) {

        medunna.SSN.sendKeys(ssn);
    }

    @And("Hasta Phone {string} girer")
    public void hastaPhoneGirer(String arg0) {

        medunna.Phone.sendKeys(arg0);
    }

    @And("Hasta Last Name {string} girer")
    public void hastaLastNameGirer(String lastname) {

        medunna.LastName.sendKeys(lastname);
    }

    @And("Hasta Email {string} girer")
    public void hastaEmailGirer(String email) {

        medunna.Email.sendKeys(email);
    }

    @And("Hasta Appointment DateTime{string} girer")
    public void hastaAppointmentDateTimeGirer(String tarih) {

        ReusableMethods.jsScroll(medunna.Date);
        medunna.Date.sendKeys(tarih);
    }


    @And("sayfayi kapatir")
    public void sayfayiKapatir() {

        Driver.quitDriver();
    }

    @And("Hasta doğru tarih  girmiş ise kayıt butonu tıklayarak kayıt olabilir")
    public void hastaDoğruTarihGirmişIseKayıtButonuTıklayarakKayıtOlabilir() {

        medunna.Sent.click();


    }
}
