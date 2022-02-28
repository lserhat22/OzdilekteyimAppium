package com.ozdilek.steps;

import com.ozdilek.driver.BaseTest;
import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Actions extends BaseTest {

        Wait wait = new FluentWait(appiumDriver)
            .withTimeout(10, TimeUnit.SECONDS)
            .pollingEvery(250, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class)
            .ignoring(TimeoutException.class);


    @Step("Uygulamanın açıldığı kontrol edilir")
    public void CheckApp() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingMarket")));
        String checkText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingMarket")).getText();
        Assert.assertEquals("TESLİMAT BÖLGESİ SEÇ", checkText);
        System.out.println("Uygulama acildi.");
        Logger.info("Uygulama acildi");
    }

    @Step("Alışverişe başla butonuna tıklanır")
    public void ClickButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")));
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")).click();
        System.out.println("Alisverise basla butonuna basildi.");
        Logger.info("Alisverise basla butonuna basildi.");
    }

    @Step("Alışveriş sayfasının açıldıgı doğrulanır")
    public void checkHomePage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/tvMarketName")));
        String checkHomePageText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tvMarketName")).getText();
        Assert.assertEquals("Market", checkHomePageText);
        System.out.println("Anasayfa acildi");
        Logger.info("Anasayfa acildi");

    }

    @Step("Katogiriler Sayfası Açılır")
    public void clickCategory() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/nav_categories")));
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/nav_categories")).click();
        Logger.info("Kategoriler sayfasi acilir.");
    }

    @Step("Katogoriler Sayfasının açıldıgı doğrulanır")
    public void checkCategoryPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc='Kategoriler']/android.widget.TextView")));
        String checkCategoryText = appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Kategoriler']/android.widget.TextView")).getText();
        Assert.assertEquals("Kategoriler", checkCategoryText);
        System.out.println("Kategoriler sayfasi acildi.");
        Logger.info("Kategoriler sayfasinin acildigi kontrol edilir.");

    }

    @Step("Menüden Kadın Seçeneğine tıklanır")
    public void clickWoman() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout[@index='1']")));
        appiumDriver.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']")).click();
        System.out.println("Kategorilerden kadin secenegi secildi.");
        Logger.info("Kategorilerden kadin secenegi secilir.");

    }

    @Step("Pantalon kategorisi acilir")
    public void clickpant() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout[@index='13']")));
        appiumDriver.findElement(By.xpath("//android.widget.RelativeLayout[@index='13']")).click();
        System.out.println("Pantalon secenegi secildi.");
        Logger.info("Pantalon secenegi secilir.");

    }

    @Step("scroll")
    public void scrollyap() throws InterruptedException {
        Thread.sleep(1500);
        TouchAction scroll = new TouchAction(appiumDriver);
        scroll.press(PointOption.point(538, 1538)).moveTo(PointOption.point(538, 420)).release().perform();
        System.out.println("Sayfada kaydirma yapildi.");
        Logger.info("Sayfada scroll yapilir.");

    }

    @Step("urunlerden rastgele urun secilir")
    public void randomproduct() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']")));
        List<MobileElement> productList = appiumDriver.findElementsByXPath("//android.widget.ImageView[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']");
        int size = productList.size();
        Random rnd = new Random();
        int randomsayi = rnd.nextInt(size);
        productList.get(randomsayi).click();
        System.out.println("Rastgele bir urun secildi.");
        Logger.info("Rastgele bir urun secilir.");

    }

    @Step("Urun detay sayfasi acilir")
    public void checkProductDetail() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/tvSizeDesc")));
        String checkProductText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tvSizeDesc")).getText();
        Assert.assertEquals("Beden:", checkProductText);
        System.out.println("Urun Detayina Girildi");
    }

    @Step("Urun favorilere eklenir")
    public void addToFav() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/imgFav")));
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/imgFav")).click();
        System.out.println("Favorilere ekle butonuna basildi.");
        Logger.info("Favorilere ekle butonuna basildi.");

    }

    @Step("Giris yap sayfasi acildigi kontrol edilir")
    public void checkLogInPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/btnLogin")));
        String checkLogInText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/btnLogin")).getText();
        Assert.assertEquals("Giriş Yap", checkLogInText);
        System.out.println("Giris yapma sayfasi acildi.");
        Logger.info("Giris yapma sayfasi acildi.");

    }

    @Step("Kullanici adi girilir")
    public void inputID() throws InterruptedException {
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/etEposta")).sendKeys("s_buyukada@testinium.com");
        System.out.println("Kullanici adi girildi.");
        Logger.info("Kullanici adi girildi.");

    }

    @Step("Sifre girilir")
    public void inputPassword() throws InterruptedException {
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/etPassword")).sendKeys("1q2w3e4r5t");
        System.out.println("Sifre girildi.");
        Logger.info("Sifre girildi.");

    }

    @Step("Geri git")
    public void prevPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/ivBack")));
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/ivBack")).click();
        System.out.println("Onceki sayfaya gidildi.");
        Logger.info("Onceki sayfaya gidilir.");

    }

    @Step("Sepete ekle")
    public void addToCart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ozdilek.ozdilekteyim:id/imgCart")));
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/imgCart")).click();
        System.out.println("Sepete ekle butonuna basildi.");
        Logger.info("Sepete ekle butonuna basildi");
        Thread.sleep(2000);

    }
}