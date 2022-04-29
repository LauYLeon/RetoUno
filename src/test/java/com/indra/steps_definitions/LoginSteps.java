package com.indra.steps_definitions;

import com.indra.enums.Direccion;
import com.indra.interactions.Swipe;
import com.indra.user_interfaces.LoginUI;
import com.indra.user_interfaces.ProductosUI;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.Stage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;

import java.time.Duration;

public class LoginSteps {

    @Managed(driver = "appium")
    private AppiumDriver driver;
    private Actor laura = Actor.named("Laura");

    @Before
    public void inicializarEscenario() {
        Stage stage = OnStage.setTheStage(new OnlineCast());
        laura.can(BrowseTheWeb.with(driver));
    }

    @Given("el esta en la pantalla de inicio de sesion")
    public void elEstaEnLaPantallaDeInicioDeSesion() {
        laura.attemptsTo();

    }

    @When("el ingresa el usuario {string} y el password {string}")
    public void elIngresaElUsuarioYElPassword(String usuario, String password) {
        // elvis.attemptsTo(WaitUntil.the(LoginUI.USERNAME, isVisible()).forNoMoreThan(Duration.ofSeconds(20)));
        Swipe.toElement(LoginUI.STANDARD_USER.resolveFor(laura), BrowseTheWeb.as(laura).getDriver(), Direccion.ABAJO);
        laura.attemptsTo(Click.on(LoginUI.STANDARD_USER));
        Swipe.toElement(LoginUI.STANDARD_USER.resolveFor(laura), BrowseTheWeb.as(laura).getDriver(), Direccion.ARRIBA);
        laura.attemptsTo(Click.on(LoginUI.LOGIN));
    }

    @Then("el deberia poder ingresar a la aplicacion")
    public void elDeberiaPoderIngresarALaAplicacion() {
        laura.attemptsTo(Ensure.that(ProductosUI.TITULO_SECCION.waitingForNoMoreThan(Duration.ofSeconds(20))).isDisplayed());

    }

    @Given("que el usuario se encuentra en el catalogo de productos")
    public void queElUsuarioSeEncuentraEnElCatalogoDeProductos() {
        elEstaEnLaPantallaDeInicioDeSesion();
        elIngresaElUsuarioYElPassword("", "");
        elDeberiaPoderIngresarALaAplicacion();
    }

}
