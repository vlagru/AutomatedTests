import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForCyklusDryPristup {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        /**
         * pred upravou
         */
        driver.findElement(By.id("clickMe")).click();
        System.out.println(driver.findElement(By.id("clicks")).getText()); // vypise pocet kliku
        Assert.assertEquals("1",driver.findElement(By.id("clicks")).getText()); // porovnava hodnoty JUnit
        driver.findElement(By.id("clickMe")).click();
        System.out.println(driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("2",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        System.out.println(driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("3",driver.findElement(By.id("clicks")).getText());
    }

    @After
    public void tearDown(){

    }

}
