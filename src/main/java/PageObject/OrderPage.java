package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * https://qa-scooter.praktikum-services.ru/order
 */
public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver, "https://qa-scooter.praktikum-services.ru/order");
    }

    public void createOrder(String firstName, String lastName, String address, String station, String phoneNumber, String date,String day,String colour, String comment,String expectedResult ){
        WebElement orderForm = driver.findElement(By.className("Order_Form__17u6u")); // форма заказа
        List<WebElement> orderFormInput = orderForm.findElements(By.className("Input_InputContainer__3NykH")); // текстовые поля формы заказа
        orderFormInput.get(0).findElement(By.tagName("input")).sendKeys(firstName); //Имя
        orderFormInput.get(1).findElement(By.tagName("input")).sendKeys(lastName); //Фамилия
        orderFormInput.get(2).findElement(By.tagName("input")).sendKeys(address); //Адрес: куда привезти
        orderForm.findElement(By.className("select-search__input")).sendKeys(station + Keys.ARROW_DOWN + Keys.ENTER); //Станция метро
        orderFormInput.get(3).findElement(By.tagName("input")).sendKeys(phoneNumber); // Телефон: на него позвонит курьер
        driver.findElement(By.className("Order_NextButton__1_rCA")).findElement(By.className("Button_Button__ra12g")).click();// кнопка Далее

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input")).sendKeys(date); //Когда привезти самокат
        setArenda(day);
        driver.findElement(By.className("Checkbox_Label__3wxSf")).findElement(By.xpath("//*[@id=\""+ colour +"\"]")).click(); // выбор цвета самоката
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input")).sendKeys(comment);// Комментарий для курьера
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]")).click(); // клик на кнопку Заказать
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]")).click();// Хотите оформить заказ? ДА
        String status = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[1]")).getText().split("\n")[0];// находим текст статуса заказа
        assertEquals(expectedResult,status); //проверка ожидаемого результата с фактическим

    }
    public void setArenda(String day){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/span")).click();// поле срок аренды
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']//div[text()='"+ day +"']")).click();// длительность аренды
    }


}
