import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// registrace na seznam emailu

public class ProcvicovaniSeznam {
    private WebDriver driver;
    private final String BASE_URL = "https://www.seznam.cz"; // bez konstanty pokud nazev v uvozovkach

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe"); // musi byt nadefinovane vzdy
        driver = new ChromeDriver();
    }
    @Test
    public void test(){
        driver.get(BASE_URL);

        driver.findElement(By.name("username")).sendKeys("tomas@seznam.cz");
        driver.findElement(By.name("password")).sendKeys("heslo");
        driver.findElement(By.cssSelector("div.input-w-button button")).click();

    }

    @After
    public void tearDown(){
        //driver.quit(); // zavreni prohlizece
    }

}
