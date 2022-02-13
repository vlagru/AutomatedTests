import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathTesting {
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
        // localhost Tabulka
        // /html/body/div/div/table/thead/tr/th[3] // 3 je indexace, zkopirovana XPath
        // www.seznam.cz
        //driver.findElement(By.xpath("//*[@id=\"boxik-26\"]/div/div/div[3]/div[1]/div/h3/a")).click();
        driver.findElement(By.xpath("//*[@id=\"boxik-184\"]/div/div/div[3]/div/form/div[1]/label/input")).sendKeys("Lukas");
        driver.findElement(By.xpath("//*[@id=\"boxik-184\"]/div/div/div[3]/div/form/div[2]/div/label/input")).sendKeys("heslo");
        driver.findElement(By.xpath("//*[@id=\"boxik-184\"]/div/div/div[3]/div/form/div[2]/div/button")).click();
    }

    @After
    public void tearDown(){
        //driver.quit(); // zavreni prohlizece
    }

}
