package com.indra.interactions;

import com.indra.enums.Direccion;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

import static com.indra.enums.Direccion.ABAJO;
import static com.indra.enums.Direccion.ARRIBA;


public class Swipe {
    public static void down(WebDriver facede) {
        WebDriver driver = ((WebDriverFacade) facede).getProxiedDriver();
        TouchAction action = new TouchAction((PerformsTouchActions) driver);

        int puntoInicialX = facede.manage().window().getSize().width / 2;
        int puntoInicialY = (int) (facede.manage().window().getSize().height * 0.8);
        int puntoFinalY = facede.manage().window().getSize().height / 2;

        action
                .longPress(PointOption.point(puntoInicialX, puntoInicialY))
                .moveTo(PointOption.point(puntoInicialX, puntoFinalY))
                .release()
                .perform();
    }

    public static void up(WebDriver facede) {
        WebDriver driver = ((WebDriverFacade) facede).getProxiedDriver();
        TouchAction action = new TouchAction((PerformsTouchActions) driver);

        int puntoInicialX = facede.manage().window().getSize().width / 2;
        int puntoInicialY = facede.manage().window().getSize().height / 2;
        int puntoFinalY = (int) (facede.manage().window().getSize().height * 0.8);

        action
                .longPress(PointOption.point(puntoInicialX, puntoInicialY))
                .moveTo(PointOption.point(puntoInicialX, puntoFinalY))
                .release()
                .perform();
    }

    public static void toElement(WebElementFacade element, WebDriver driver, Direccion direccion) {

        int contador = 0;

        while (!element.isVisible() && contador < 5) {
            if (direccion == ARRIBA) {
                up(driver);
            } else if (direccion == ABAJO) {
                down(driver);
            }
            contador++;
        }
    }


}
