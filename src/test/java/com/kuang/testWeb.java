package com.kuang;



import static org.junit.Assert.assertTrue;

import org.junit.Test;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.*;

public class testWeb {

    public static WebDriver webDriver;

    public static String  baseUrl = "http://www.baidu.com/";

    @Before
    public void beforeMethod() {

        /** 第二个参数为 Chromedriver 镜像下载目录地址 */
        System.setProperty("webdriver.chrome.driver", "D:\\java\\jdk-11.0.8\\bin\\chromedriver.exe");

        /** 新建一个WebDriver 的对象，但是 new 的是 FirefoxDriver 的驱动 */
        webDriver = new ChromeDriver();
    }

    @Test
    public void testBiduSearch() {

        /** 打开指定的网站 */
        webDriver.get(baseUrl);

        /** 找到 id 为 kw 的元素 */
        WebElement inputBox = webDriver.findElement(By.id("kw"));

        /** 判断是否为 true */
        assertTrue(inputBox.isDisplayed());

        /** 输入 CSDN */
        inputBox.sendKeys("CSDN");

        /** 点击按钮 */
        webDriver.findElement(By.id("su")).click();
    }



    @After
    public void afterMethod() throws InterruptedException {

        /** 线程睡眠 3 秒 */
        Thread.sleep(3000);

        /** 关闭浏览器 */
        webDriver.quit();
    }
}
