import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    // 1. Amazon.com'a gideceğiz.
// 2. Arama kutusuna "baby stroller"
// 3. 2. Sıradaki ürüne tıklayacağız.
// 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
// 5. Ürünün ortalama puanını (5 üzerinden) alacağız.

    @Test
    public void amazonTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("baby stroller");
        searchBox.submit();

        WebElement babyStroller2 = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        babyStroller2.click();


        WebElement toplamFiyat = driver.findElement(By.id("priceblock_saleprice"));
        Thread.sleep(2000);
        System.out.println(toplamFiyat.getText());

    }
    @Test
    public void test2(){
        //1. Google.com gecis yapalim (navigate().to.())
        //2. "selim akaslan" yazip arama yapalim
        //3. Karsimiza cikan sonuc sayisini ekrana yazdiralim.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driverı tam ekran yaptık.
        driver.manage().window().maximize();
        // webelementlerin yüklenmesini 10 saniyeye kadar bekleyebilirsin.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com");

        WebElement googleSearch = driver.findElement(By.name("q"));
        googleSearch.submit();
        googleSearch.sendKeys("Selim Akaslan");
        WebElement searchBox = driver.findElement(By.name("btnK"));
        searchBox.submit();
        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println("Sonuc: "+ sonucSayisi.getText());

    }
}
