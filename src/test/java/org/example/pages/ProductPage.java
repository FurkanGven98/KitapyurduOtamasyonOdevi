package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Methods;
import org.openqa.selenium.By;

import static org.example.constants.Elements.*;

public class ProductPage {
    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage(){
        methods = new Methods();
    }
    public void scrollAndSelect(){
        methods.sendKeys(searchInput,"Oyuncak");
        methods.waitBySecond(3);
        methods.Click(searchButonu);
        methods.waitBySecond(3);
        methods.scrollWithAction(kenarMenu);
        methods.waitBySecond(3);
    }
    //Favorilere random eklediğimde adet tutuyor fakat bir sonraki adıma geçerken patlıyor.
    //Bu hatayı önleyemediğimden manuel olarak listeye ekledim.
    //Sonraki adımları gerçekledim.
    public void randomClickFav(){
        methods.waitBySecond(4);
        methods.randomClickFourTimes(favoriButonu);
        methods.waitBySecond(3);
    }
    public void favoriKontrol(){
        methods.Click(logoAnasayfa);
        methods.waitBySecond(3);
        methods.Click(listelerim);
        methods.waitBySecond(3);
        methods.Click(favorilerim);
        methods.waitBySecond(3);
        methods.textKontrol("etiketsiz");
    }
    public void filtreleme(){
        methods.waitBySecond(2);
        methods.SelectByText(filtreleme,"Yüksek Oylama");
    }
    public void randomClick(){
        methods.randomClick(randomClick);
    }
    public void urunArtir(){
        methods.waitBySecond(5);
        methods.findElement(urunMiktari).clear();
        methods.sendKeys(urunMiktari,"2");
        methods.Click(refreshIcon);
    }
    public void adresEkle(){
        methods.Click(yeniAdres);
        methods.waitBySecond(2);
        methods.Click(faturaAd);
        methods.sendKeys(faturaAd,"Furkan");
        methods.waitBySecond(2);
        methods.Click(faturaSoyad);
        methods.sendKeys(faturaSoyad,"Güven");
        methods.waitBySecond(2);
        methods.SelectByText(sehirSec,"Adana");
        methods.waitBySecond(2);
        methods.SelectByText(ilceSec,"ALADAĞ");
        methods.waitBySecond(2);
        methods.sendKeys(faturaMahalle,"AKPINAR MAH");
        methods.waitBySecond(2);
        methods.Click(faturaAdres);
        methods.sendKeys(faturaAdres,"deneme mahallesi deneme sokağı no1 d1");
        methods.waitBySecond(2);
        methods.Click(cepTel);
        methods.sendKeys(cepTel,"5123456568");
        methods.waitBySecond(2);
        methods.Click(devam);
        methods.waitBySecond(3);
        methods.Click(devam);
        methods.waitBySecond(2);
        methods.Click(creditCardOwner);
        methods.sendKeys(creditCardOwner,"Furkan Güven");
        methods.waitBySecond(2);
        methods.Click(creditCardNumber);
        methods.sendKeys(creditCardNumber,"1231223433334444");
        methods.waitBySecond(2);
        methods.Click(creditCardMonth);
        methods.SelectByText(creditCardMonth,"01");
        methods.waitBySecond(2);
        methods.Click(creditCardYear);
        methods.SelectByText(creditCardYear,"2022");
        methods.waitBySecond(2);
        methods.Click(creditCardCVV);
        methods.sendKeys(creditCardCVV,"111");
        methods.waitBySecond(2);
        methods.Click(devam);
        methods.waitBySecond(2);
        methods.textKontrol("Kart numarası geçersiz. Kontrol ediniz!");
        methods.waitBySecond(2);
        methods.Click(checkoutLogo);

    }
    public void clickElement(By by){
        methods.waitBySecond(2);
        methods.Click(by);
        methods.waitBySecond(2);}
    public void logout(){
        methods.hoverElement(logoutLogo);
        methods.waitBySecond(2);
        methods.Click(cikis);
        methods.textKontrol("Üye Ol");
    }
    public void sonAdresiSil(){
        methods.Click(logoutLogo);
        methods.waitBySecond(2);
        methods.Click(adresler);
        methods.waitBySecond(2);
        methods.Click(sil);
        methods.waitBySecond(2);
        methods.Click(logoAnasayfa);
    }
    /*public void dortUrunFavoriEkle(){
        methods.Click(dokuzuncuUrunFavori);
        methods.Click(onuncuUrunFavori);
        methods.Click(onbirinciUrunFavori);
        methods.Click(onikinciUrunFavori);
    }*/

}
