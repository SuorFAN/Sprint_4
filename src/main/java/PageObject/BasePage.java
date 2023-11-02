package PageObject;


import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    String url;
    WebDriver driver;
    protected BasePage(WebDriver driver,String url){
        this.url = url;
        this.driver = driver;
    }
    public void openPage() {
        driver.get(url);
    }
}
