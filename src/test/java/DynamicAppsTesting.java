import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicAppsTesting {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/tabulka.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);

        int row = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText()); // definice iteraceSS
        for (int i = 1; i < row+1; i++) {
            System.out.println(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText()); // pozor na plusy u indexace
            Assert.assertFalse("Je zde text" , driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText().isEmpty());
        }
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
