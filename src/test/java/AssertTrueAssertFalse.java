import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssertTrueAssertFalse {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/vybersi.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);

        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");//text, idex, value
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        Assert.assertTrue("Slovo se zde nenachazi", driver.findElement(By.xpath("//div/h3")).getText().contains("Pikachu"));
        new Select(driver.findElement(By.className("form-control"))).selectByIndex(1);
        Assert.assertTrue("Slovo se zde nenachazi" , driver.findElement(By.xpath("//div/h3")).getText().contains("Charmander"));
        /*
        new Select(driver.findElement(By.className("form-control"))).selectByValue("05");
        Assert.assertTrue("Slovo se zde nenachazi" , driver.findElement(By.xpath("//div/h3")).getText().contains("People"));
        */
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Squirtle");
        Assert.assertFalse("Slovo se zde nachazi", driver.findElement(By.xpath("//div/h3")).getText().contains("People"));//kdyby true, tak to spadne a vypise se hlaska


    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
