/*
A simple class used to demonstrate Selenium's WebDriver: get, navigate, getCurrentUrl, getTitle, back, forward,
refresh, and switchTo methods
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver theDriver = new ChromeDriver();
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        theDriver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        theDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        theDriver.get("https://www.renaissance.com/?utm_source=sigstr&utm_medium=email&utm_content=rli_logo&utm_campaign=general");
        String originalWindow = theDriver.getWindowHandle();
        theDriver.navigate().to("https://www.renaissance.com/about-us/");
        System.out.println(theDriver.getCurrentUrl());//Print out the url to the console
        System.out.println(theDriver.getTitle()); //Print out the title to the console
        theDriver.navigate().back();//Navigate back
        Thread.sleep(2000);//Not a best practice just used for demonstration purposes
        theDriver.navigate().forward();//Navigate forward
        Thread.sleep(2000);
        theDriver.navigate().refresh(); //Refresh the page

        theDriver.switchTo().newWindow(WindowType.TAB); //Creates a new tab
        theDriver.switchTo().newWindow(WindowType.WINDOW); //Creates a new window
        theDriver.switchTo().window(originalWindow); //Switching to the original window
        Thread.sleep(2000);
        theDriver.quit();
       //theDriver.close();
    }//end of main

}//end of class
