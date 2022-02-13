import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySecondTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php"; // bez konstanty pokud nazev v uvozovkach

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe"); // musi byt nadefinovane vzdy
        driver = new ChromeDriver();
    }
    @Test
    public void test(){
        driver.get(BASE_URL); // nebo cely nazev do uvozovek
        // localhost : registrace
        //driver.findElement(By.id("clickMe")).click(); // najdu element lokatorem ID, teprve pote zadavam dalsi metodu
        driver.findElement(By.name("email")).sendKeys("halfelf@gmail.com"); // name se pouziva hlavne u formularu
        driver.findElement(By.name("name")).sendKeys("Petr");
        driver.findElement(By.tagName("button")).click();


        /*
        // seznam : registrace na email
        driver.findElement(By.name("username")).sendKeys("v.grulich@gmail.com");
        driver.findElement(By.name("password")).sendKeys("test");
        */

    }

    @After
    public void tearDown(){
        //driver.quit(); // zavreni prohlizece
    }

}
