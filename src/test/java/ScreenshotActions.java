/*
A simple class used to demonstrate Selenium's WebDriver: TakeScreenshot casting and WebElement object capabilities to
create screenshots of the renaissance.com home page and logo and save the images as files.
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotActions {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver theDriver = new ChromeDriver();
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        theDriver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        theDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        theDriver.get("https://www.renaissance.com/?utm_source=sigstr&utm_medium=email&utm_content=rli_logo&utm_campaign=general");
        File screenShot = ((TakesScreenshot)theDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("./screenshot.png"));
        WebElement element = theDriver.findElement(By.className("logo-main"));
        File logo = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(logo,new File("./logo.png"));
        
    }//end of main
}//end of class
