package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        Thread.sleep(10000);
        driver.get("https://www.otto.de");
        String ottoTitle= driver.getTitle();
        String ottoUrl= driver.getCurrentUrl();

        if (ottoTitle.contains("OTTO") && ottoUrl.contains("OTTO")){
            System.out.println("OTTO yazisi ICERIYOR");
        }else {
            System.out.println("OTTO yazisi ICERMIYOR");
        }
        driver.navigate().to("https://wisequarter.com/");
        String wqTitle = driver.getTitle();
        System.out.println("wqTitle = " + wqTitle);
        String wqUrl = driver.getCurrentUrl();
        System.out.println("wqUrl = " + wqUrl);

        boolean isTrue = wqTitle.contains("Quarter");

        if (isTrue){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.close();
    }
}
