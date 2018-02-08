package com.CTrain.CtrainTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddStations {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://admin.phenix.train.uat.qa.nt.ctripcorp.com/phenix-admin/Login");
        driver.findElement(By.id("txt_account")).sendKeys("test_user");
        driver.findElement(By.id("txt_password")).sendKeys("123456");
        driver.findElement(By.id("login_button")).click();
        // 直接使用driver.wait（）异常
        synchronized (driver)
        {
            driver.wait(2000);
            System.out.println(driver.getPageSource());
            // 跳转至测试环境刷数据页
            driver.findElement(By.xpath("//a[@href='/phenix-admin/SystemManage/SetTestData/Index']")).click();
            driver.wait(3000);
            // 切换为右侧页面，无此句无法定位后面元素
            driver.switchTo().frame("iframecygj-01");
            driver.findElement(By.id("from")).sendKeys("上海虹桥");
            driver.findElement(By.id("to")).sendKeys("重庆北");
            driver.findElement(By.id("departDate")).clear();//清除默认的当前日期
            driver.findElement(By.id("departDate")).sendKeys("20180222");
            //刷入站站车次数据
            driver.findElement(By.id("btn_set")).click();
            driver.wait(2000);
            //刷入跨站抢数据
            driver.findElement(By.id("btn_set_stagger_grab")).click();
            driver.wait(5000);

        }
        driver.quit();
    }

}
