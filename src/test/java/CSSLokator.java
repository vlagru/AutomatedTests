import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLokator {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php"; // bez konstanty pokud nazev v uvozovkach

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe"); // musi byt nadefinovane vzdy
        driver = new ChromeDriver();
    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        //localhost : registrace
        //driver.findElement(By.cssSelector(".btn-success")).click(); // css lokator podle tridy - tecka
        //driver.findElement(By.cssSelector("#count")).click(); // # je oznaceni pro ID
        //localhost : CLICKMEBABY!
        //driver.findElement(By.cssSelector("div.row button")).click(); // pokud neni k dispozici class ani ID, lze se odkazat na rodice a pote pripojit tag
        //driver.findElement(By.cssSelector("div.row>button")).click(); // > lze pouzit pro PRIMEHO rodice, nikoli pro predka
        //driver.findElement(By.cssSelector("div.container button")).click(); // sem nelze dat >, jelikoz se nejedna o primeho rodice
        driver.findElement(By.cssSelector("div.container>button")).click();
    }

    @After
    public void tearDown(){
        //driver.quit(); // zavreni prohlizece
    }

}
