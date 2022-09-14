package InviulTest;

import org.junit.*;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "B:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.inviul.com");
        String actualTitle = driver.getTitle();
        driver.manage().window().maximize();
        String expectedTitle = "DevMedia | Plataforma para Programadores";
        if(actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("O título está correto");
        else
            System.out.println("Favor, corrigir o título (ou não, o site nem é teu).");
        driver.close();
        driver.quit();

    }

}