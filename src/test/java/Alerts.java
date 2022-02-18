import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/redalert.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);

        /*
        //nejdrive si najdu alert a kliknu na nej
        driver.findElement(By.id("alert1")).click();
        //je zde trida Alert, proto si vytvorim objekt Alert a jako instanci se do nej prepnu
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());
        */


        driver.findElement(By.id("alert1")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div[@class = 'result']/h1")).getText());

        //dismiss
        driver.findElement(By.id("alert2")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());//ziskani hlasky ze samotneho alertu, hlasky
        // potvrzeni hlasky alertu
        Assert.assertEquals("Second alert!",alert1.getText()); //porovnani hlasky alertu
        alert1.dismiss(); //vyonuti hlasky
        System.out.println(driver.findElement(By.xpath("//div[@class = 'result']/h1")).getText());


        //treti alert s polem k vyplneni
        driver.findElement(By.id("alert3")).click();
        Alert alert2  = driver.switchTo().alert();
        alert2.sendKeys("Mista");
        alert2.accept(); //potvrzeni kliku

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'result']/h1")).getText().contains("Mista"));



    }


    @After
    public void tearDown() {
        //driver.quit();
    }

}
