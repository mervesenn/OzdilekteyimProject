import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;


public class BasePage extends BaseTest {


    @Step("<wait> saniye kadar bekle")
    public void waitForSeconds(int wait) throws InterruptedException {
        Thread.sleep(wait * 1000);
    }

    @Step("id<id> li elemente tıkla")
    public void clickById(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("id<id> li elementi kontrol et")
    public void checkText(String id) {
        String chectText = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA", chectText);
    }

    @Step("id<id> li elementli kontrol et")
    public void checkText1(String id) {
        String chectText1 = appiumDriver.findElement(By.id(id)).getText();
        Logger.info("Alisveris sayfasi basariyla acildi.");
    }

    @Step("id<id> kategoriye tıkla")
    public void clickBykategori(String id) {
        appiumDriver.findElement(By.id(id)).click();
        Logger.info("Kategoriler sayfasina tiklandi");
    }

    @Step("xpath<xpath> kadın kategorisine tıkla")
    public void clickBykadın(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        Logger.info("Kadin kategorisine tiklandi.");
    }


    @Step("xpath<xpath> pantolon kategorisine tıkla")
    public void clickBypantolon(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        Logger.info("Pantolon kategorisine tiklandi.");
    }

    @Step("scroll et")
    public void scrollEt() {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(538, 1538)).moveTo(PointOption.point(538, 420)).release().perform();
        Logger.info("Scroll yapildi.");
    }

    @Step("Rastgele bir ürün seçme")
    public void selectRandomproduct() {
        Random random = new Random();
        List<MobileElement> randomUrun = appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        System.out.println("randomUrunSecme" + randomUrun);
        MobileElement element = randomUrun.get(random.nextInt(randomUrun.size()));
        System.out.println("element" + element);
        element.click();
        Logger.info("Rastele bir urun secildi.");
    }


    @Step("id<id> urun detay kontrolü")
    public void urunDetay(String id) {
        String urunDetay = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Beden:", urunDetay);
        Logger.info("Urun detay kontrolu yapildi.");
    }

    @Step("xpath <xpath> favoriye ekle")
    public void favorilereEkle(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
        Logger.info("Urun favorilere eklendi.");
    }

    @Step("id<id> giris kontrolü")
    public void girisKontrol(String id) {
        String girisKontrol = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Beni Hatırla", girisKontrol);
        Logger.info("Giris kontrolu yapildi.");
    }


    @Step("<id> id'li elemente <mail> mail adresi girme")
    public void kullaniciAdi(String mailId,String mailText){
        appiumDriver.findElement(By.id(mailId)).sendKeys(mailText);
        Logger.info("Mail adresi girildi");
    }

    @Step("<id> 'li elemente <sifre> sifre girme")
    public void kullaniciSifre(String sifreId, String sifreText){
        appiumDriver.findElement(By.id(sifreId)).sendKeys(sifreText);
        Logger.info("Sifre girildi");
    }

    @Step("id<id> geri tusuna tıkla")
    public void clickBygeri(String id) {
        appiumDriver.findElement(By.id(id)).click();
        Logger.info("Geri tusuna basildi.");
    }

    @Step("<id> sepete ekleme yap")
    public  void AddToCart(String sepetId){
        appiumDriver.findElement(By.id(sepetId)).click();
        Logger.info("Sepete ekle tusuna basildi");
    }

}
