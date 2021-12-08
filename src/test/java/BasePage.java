import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage extends BaseTest{

    @Step("<wait> saniye bekle")
    public void waitForsecond(int wait) throws InterruptedException {
    Thread.sleep(1000*wait);
    System.out.println(wait +  " saniye beklendi");

}

    @Step("<selectorid> id'li elemente tıkla")
    public void clickByid(String selectorid){
    appiumDriver.findElement(By.id(selectorid)).click();
    System.out.println(selectorid +  " Elementine tiklandi !!!");
}
    @Step("<selectorclass> class'li elemente tıkla")
    public void clickByclass(String selectorclass){
        appiumDriver.findElement(By.id(selectorclass)).click();
        System.out.println(selectorclass +  " Elementine tiklandi !!!");
    }
    @Step("<selectorxpath> xpath'li elemente tıklattır")
    public void clickByXpath(String selectorxpath) {
        appiumDriver.findElement(By.xpath(selectorxpath)).click();
        System.out.println(selectorxpath + "Elementine tıklattır !!!");
    }
    @Step("<id> id'li elemente <text> text değerini yaz")
    public void sendKeysbyid(String id, String text){
    appiumDriver.findElement(By.id(id)).sendKeys(text);
    System.out.println(text + "Değeri yazıldı");
    }
    @Step("<key> id'li element <keyword> text değerini içerdiğini kontrol et")
    public void textContol(String key,String keyword) {
    Assert.assertFalse("Elementi içermiyor", appiumDriver.findElement(By.id(key)).getText().contains(keyword));
    }
    @Step("<keys> xpath'li element <keywords> text değerini içerdiğini kontrol et")
    public void Cont(String keys,String keywords) {
        Assert.assertFalse("Elementi içermiyor", appiumDriver.findElement(By.xpath(keys)).getText().contains(keywords));

    }
    @Step("Scroll Yap")
    public void swipeUp() {
        int startA = 530;
        int startB = 1950;
        int endA = 540;
        int endB = 30;
        (new TouchAction(appiumDriver))
                .press(point(startA, startB))
                .moveTo(point(endA,endB))
                .release()
                .perform();
        System.out.println("Scroll Yapildi");
    }

    @Step("Sayfadan rastgele urun secilir")
    public void rasgeleUrunSec() throws InterruptedException {
        List<String> rastegeleUrunler =new LinkedList<String>();
        Thread.sleep(2000);
        for(int i=0;i<4;i++){
            rastegeleUrunler.add("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+(i+1)+"]/android.view.ViewGroup/android.widget.ImageView");
        }
        Random random = new Random();
        int r = random.nextInt(4);
        appiumDriver.findElement(By.xpath(rastegeleUrunler.get(r))).click();
    }
    @Step("login sayfa kontrol")
    public void loginControl(){
        System.out.println(appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/btnFacebook")).getText());
        Assert.assertEquals("Facebook ile Bağlan",  appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/btnFacebook")).getText());
        System.out.println("Login sayfasi geldi");

    }

    }





