package com.indra.tasks;

import com.indra.user_interfaces.LoginUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

public class Llenar implements Task {

    private String usuario;
    private String password;

    public Llenar(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    @Step("{0} ingresa las credenciales del usuario #usuario")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginUI.USERNAME.waitingForNoMoreThan(Duration.ofSeconds(15))),
                Enter.theValue(password).into(LoginUI.PASSWORD),
                Click.on("siguiente"),
                Enter.theValue("dad").into("otp")
        );
    }

    public static Llenar elFormularioDeLogin(String usuario, String password){
        return Tasks.instrumented(Llenar.class,usuario,password);
    }
}
