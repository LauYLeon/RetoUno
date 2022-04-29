package com.indra.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CompraArticuloUI {
    public static final Target ARTICULO = Target.the("campo usuario")
            .locatedForAndroid(By.xpath("//*[@text='Mochila Sauce Labs']"))
            .locatedForIOS(By.xpath("//foo[]"));
    public static final Target AGREGAR = Target.the("campo usuario")
            .locatedForAndroid(By.xpath("//android.view.ViewGroup[@content-desc='test-A\u00D1ADIR A CARRITO']"))
            .locatedForIOS(By.xpath("//foo[]"));
    public static final Target CARRITO_CANTIDAD = Target.the("campo usuario")
            .locatedForAndroid(By.xpath("//android.view.ViewGroup[@content-desc='test-Carrito']"))
            .locatedForIOS(By.xpath("//foo[]"));
    public static final Target DESCRIPCION_ARTICULO = Target.the("campo usuario")
            .locatedForAndroid(By.xpath("//android.view.ViewGroup[@content-desc='test-Descripci\u00F3n']/android.widget.TextView[1]"))
            .locatedForIOS(By.xpath("//foo[]"));

}
