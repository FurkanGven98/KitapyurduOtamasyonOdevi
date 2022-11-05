package org.example.test;

import org.example.driver.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.junit.Test;

import static org.example.constants.Elements.*;

public class ProductTest extends BaseTest {
    @Test
    public void productTest(){
        LoginPage loginPage=new LoginPage();
        ProductPage productPage=new ProductPage();
        loginPage.login();
        productPage.scrollAndSelect();
        //productPage.dortUrunFavoriEkle();
        //productPage.randomClickFav();
        productPage.favoriKontrol();
        productPage.clickElement(logoAnasayfa);
        productPage.clickElement(puanKatologu);
        productPage.clickElement(turkKlasikleri);
        productPage.filtreleme();
        productPage.clickElement(tumKitaplar);
        productPage.clickElement(hobiKitaplar);
        productPage.randomClick();
        productPage.clickElement(sepeteEkle);
        productPage.favoriKontrol();
        productPage.clickElement(favorilerdenSil);
        productPage.clickElement(sepet);
        productPage.clickElement(sepeteGit);
        productPage.urunArtir();
        productPage.clickElement(satinAl);
        productPage.adresEkle();
        productPage.sonAdresiSil();
        productPage.logout();

    }
}
