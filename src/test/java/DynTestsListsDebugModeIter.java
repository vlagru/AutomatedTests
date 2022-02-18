import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynTestsListsDebugModeIter {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/tabulka.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test(){
        driver.get(BASE_URL);

        /*

        //vytvoreni listu
        List<WebElement> row = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println(row); // debug mode: kontrola, co je v row, run debug test, evaluate, zjistim pocet polozek

        */

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        //System.out.println(rows);
        //zkratka 'iter' iterovani jednotlivych polezek listu, tedy radku dynamicke tabulky
        for (WebElement row : rows) {
            //System.out.println(row.getText());

            //najdu si element z listu, teckou se odkazu na xpath, v indexu 3 hledam prijmeni
            System.out.println(row.findElement(By.xpath("./td[3]")).getText());
            //mohu si overit, zda se v danych elementech nachazi text
            Assert.assertFalse("V danych elementech se nenachazi text" , row.findElement(By.xpath("./td[3]")).getText().isEmpty());
        }
    }


    @After
    public void tearDown(){
        //driver.quit(); // zavreni prohlizece
    }

}
