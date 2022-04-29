package com.indra.steps_definitions;

import com.indra.enums.Direccion;
import com.indra.interactions.Swipe;
import com.indra.user_interfaces.CompraArticuloUI;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
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

public class CompraArticulosSteps {
    @Managed(driver = "appium")
    private AppiumDriver driver;
    private Actor laura = Actor.named("Laura");

    @Before
    public void inicializarEscenario() {
        Stage stage = OnStage.setTheStage(new OnlineCast());
        laura.can(BrowseTheWeb.with(driver));
    }

    @When("el selecciona el producto (.*)$")
    public void elSeleccionaElProducto(String articulo) {
        Swipe.toElement(CompraArticuloUI.ARTICULO.resolveFor(laura), BrowseTheWeb.as(laura).getDriver(), Direccion.ABAJO);
        laura.attemptsTo(Click.on(CompraArticuloUI.ARTICULO));
        Swipe.toElement(CompraArticuloUI.AGREGAR.resolveFor(laura), BrowseTheWeb.as(laura).getDriver(), Direccion.ABAJO);
        laura.attemptsTo(Click.on(CompraArticuloUI.AGREGAR));
    }

    @Then("el usuraio deberia poder verlo en el carrito de compras")
    public void elUsuraioDeberiaPoderVerloEnElCarritoDeCompras() {
        laura.attemptsTo(Click.on(CompraArticuloUI.CARRITO_CANTIDAD));
        laura.attemptsTo(Ensure.that(CompraArticuloUI.DESCRIPCION_ARTICULO).text().isEqualTo("Mochila Sauce Labs"));
    }
}
