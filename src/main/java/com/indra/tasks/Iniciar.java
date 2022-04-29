package com.indra.tasks;

import com.indra.user_interfaces.LoginUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Iniciar {

    public static Performable sesionConLasCredenciales(String usuario, String password){
        return Task.where("{0} inicia sesion con sus credenciales #usuario",
                Llenar.elFormularioDeLogin(usuario, password),
                Click.on(LoginUI.LOGIN)
                );
    }
}
