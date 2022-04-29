package com.indra.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductosUI {

    public static final Target TITULO_SECCION = Target.the("titulo de la seccion")
            .locatedBy("//android.view.ViewGroup[@content-desc='test-Zona de ca\u00EDda del carrito de compras']/android.view.ViewGroup/android.widget.TextView");
}
