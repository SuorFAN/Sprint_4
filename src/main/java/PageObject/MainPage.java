package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

/**
 * https://qa-scooter.praktikum-services.ru/
 */
public class MainPage extends BasePage {


    public MainPage(WebDriver driver) {
        super(driver, "https://qa-scooter.praktikum-services.ru/");
    }

    /**
     * Нажать кнопу Заказать
     */
    public void clickButtonOrder(){
        driver.findElement(By.className("Header_Nav__AGCXC")).findElement(By.className("Button_Button__ra12g")).click();

    }
    public void checkQuestion(int id, String expected){
        WebElement element = driver.findElement(By.id("accordion__heading-" + id ));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-" + id)).click();
        String text = driver.findElement(By.id("accordion__panel-" + id)).getText();
        assertEquals(expected,text);


    }
}
