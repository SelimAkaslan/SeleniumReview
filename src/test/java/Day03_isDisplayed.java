import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class Day03_isDisplayed {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Ignore
    @Test
    public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        //*[.="Dynamic Controls"]
        //h4
        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyorMu = baslik.isDisplayed(); // true false
        System.out.println("Gorunuyor mu : " + gorunuyorMu);
    }
    @Test
    public void isSelected(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement secimElementi = driver.findElement(By.xpath("//input[@type='checkbox']"));
        boolean seciliMi1 = secimElementi.isSelected();
        System.out.println("Secili mi: "+seciliMi1);
        secimElementi.click();
        boolean seciliMi2 = secimElementi.isSelected();
        System.out.println("Secili mi: "+seciliMi2);
    }
    @Test
    public void isEnable() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputKutusu = driver.findElement(By.xpath("//input[@type='text']"));
        boolean aktifMi1 = inputKutusu.isEnabled();
        System.out.println("Aktif mi: "+ aktifMi1);

        WebElement enableButton = driver.findElement(By.xpath("//*[.='Enable']"));
        enableButton.click();
        Thread.sleep(5000);
        boolean aktifMi2 = inputKutusu.isEnabled();
        System.out.println("Aktif mi: "+ aktifMi2);
    }
}
