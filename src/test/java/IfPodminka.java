import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IfPodminka {
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
        Assert.assertEquals("Pocatecni pocet kliku", "0", driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("klikov", driver.findElement(By.className("description")).getText());

        for (int i = 1; i < 11; i++) {
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals(String.valueOf(i), driver.findElement(By.id("clicks")).getText());
                if (i==1) {
                    System.out.println("Overujeme 'klik'");
                    Assert.assertEquals("klik", driver.findElement(By.className("description")).getText());
                }
                else if (i>=2 && i<=4) {
                    System.out.println("Overujeme 'kliky'");
                    Assert.assertEquals("kliky" , driver.findElement(By.className("description")).getText());
                }
                else {
                    System.out.println("Overujeme 'klikov'");
                    Assert.assertEquals("klikov", driver.findElement(By.className("description")).getText());
                }
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
