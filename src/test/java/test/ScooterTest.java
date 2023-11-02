package test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObject.MainPage;
import PageObject.OrderPage;

@RunWith(Parameterized.class) // добавили раннер Parameterized

public class ScooterTest {
    String firstName;
    String lastName;
    String address;
    String station;
    String phoneNumber;
    String date;
    String day;
    String colour;
    String comment;
    String expectedResult;
    // поля класса:
    // WebDriver driver = new ChromeDriver(); // драйвер для хрома
    WebDriver driver = new FirefoxDriver(); // драйвер для файрфокса
    MainPage mainPage = new MainPage(driver); // главная страница
    OrderPage orderPage = new OrderPage(driver); // страница заказа


    // конструктор с параметрами
    public ScooterTest(String firstName, String lastName, String address, String station, String phoneNumber, String date,String day,String colour, String comment, String expectedResult) {
        this.firstName = firstName; // заполняем поле Имя
        this.lastName = lastName;// заполняем поле Фамилия
        this.address = address;// заполняем поле Адрес: куда привезти заказ
        this.station = station;// заполняем поле Станция метро
        this.phoneNumber = phoneNumber;// заполняем поле Телефон: на него позвонит курьер
        this.date = date;// заполняем поле Когда привезти самокат
        this.day = day;// заполняем поле Срок аренды
        this.colour = colour;// заполняем поле Цвет самоката
        this.comment = comment;// заполняем поле Комментарий для курьера
        this.expectedResult = expectedResult;// проверяем результат
    }

    // метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Александр", "Федоров", "Адрес.дом", "Сокольники", "89103335577", "11.09.2025", "двое суток", "black", "Нет","Заказ оформлен"},// первый набор данных
                {"Вася", "Пупкин", "Дом.адрес", "Сходненская", "73216667799", "26.04.1986", "пятеро суток", "grey", "Да", "Заказ оформлен"}// второй набор данных

        };
    }

    @Test
    public void test() {
        mainPage.openPage();// открыли страницу

        mainPage.clickButtonOrder();//жмем кнопку заказать
        orderPage.createOrder(firstName, lastName, address, station, phoneNumber, date, day, colour, comment, expectedResult);//вводим данные

    }

    @After
    public void tearDown() {
        driver.quit();
    } // закрыть браузер
}
