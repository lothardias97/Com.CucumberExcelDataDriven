package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlLocal = new ThreadLocal<>();

    /*This method is used to initialize the threadLocal driver on the basis of given browser*/
    public WebDriver init_browser(String browser) {

        System.out.println("The name of the browser is " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlLocal.set(new ChromeDriver());
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlLocal.set(new FirefoxDriver());
        }
        else if (browser.equals("microsoft edge")) {
            WebDriverManager.edgedriver().setup();
            tlLocal.set(new EdgeDriver());
        }
        else if (browser.equals("safari")) {
            tlLocal.set(new SafariDriver());
        }
        else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }


    /*This is to used to get the driver with ThreadLocal @return
    making it Synchronized just for parallel execution
    */
    public static synchronized WebDriver getDriver() {
        return tlLocal.get();
    }

}
