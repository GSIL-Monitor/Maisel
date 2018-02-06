package com.CTrain.CtrainTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddStations {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/yanglu/Downloads/selenium-java-3.8.1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://admin.phenix.train.uat.qa.nt.ctripcorp.com/phenix-admin/Login");
        driver.findElement(By.id("txt_account")).sendKeys("test_user");
        driver.findElement(By.id("txt_password")).sendKeys("123456");
        driver.findElement(By.id("login_button")).click();
        synchronized (driver)
        {
            driver.wait(2000);
            System.out.println(driver.getPageSource());
            driver.findElement(By.xpath("//a[@href='/phenix-admin/SystemManage/SetTestData/Index']")).click();
            driver.wait(2000);
            System.out.println(driver.getPageSource());
            System.out.println("*************");
            driver.switchTo().frame("iframecygj-01");
            System.out.println(driver.getPageSource());
            System.out.println("*************");
//            System.out.println(driver.getWindowHandle());
//            System.out.println("*************");
            driver.findElement(By.id("from")).sendKeys("上海");
            driver.findElement(By.id("to")).sendKeys("昆山");
            driver.findElement(By.id("departDate")).clear();
            driver.findElement(By.id("departDate")).sendKeys("20180227");
            driver.findElement(By.id("btn_set")).click();

        }
//        try {
//            driver.wait(3000);
//            System.out.println(driver.getPageSource());
//            driver.findElement(By.xpath("/c/a[@href='/phenix-admin/SystemManage/SetTestData/Index']")).click();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        driver.findElement(By.xpath("a[text()='测试环境数据']")).click();
//        driver.findElement(By.xpath("//a[text()='测试环境数据']")).click();
//        driver.findElement(By.linkText("测试环境数据")).click();
//        driver.findElement(By.xpath("//a[@href='/phenix-admin/SystemManage/SetTestData/Index']")).click();
//        driver.findElement(By.xpath("text='测试环境数据'")).click();
//        driver.findElement(By.cssSelector("a[data-id=\"cygj-01\"]")).click();
//        driver.findElement(By.id("cygj-01")).click();
//        driver.wait(30);

//        driver.quit();

    }

}
