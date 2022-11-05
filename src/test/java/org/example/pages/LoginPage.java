package org.example.pages;

import org.example.methods.Methods;
import org.example.constants.Elements;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.example.constants.Elements.*;

public class LoginPage {
    Methods methods;
    public LoginPage(){
        methods =new Methods();
    }
    public void login(){
        methods.Click(anaSayfaGirisYapButonu);
        methods.waitBySecond(3);
        methods.sendKeys((loginMailAlani),"furkan.guven@testinium.com");
        methods.waitBySecond(5);
        methods.sendKeys((loginPasswordAlani),"Fg1234567.");
        methods.waitBySecond(5);
        methods.Click(loginGirisYapButonu);
        methods.waitBySecond(10);
        Assert.assertTrue(methods.isElementVisible(hesabimYazisi));
        methods.waitBySecond(5);
        methods.Click(logoAnasayfa);
    }
}
