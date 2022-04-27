package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.time.Duration;

public class Utils {

    public static WebDriver createChromeDriver() {
        return createDriver("chrome");
    }

    public static WebDriver createEdgeDriver() {
        return createDriver("edge");
    }

    public static WebDriver createDriver(String driverName) {
        WebDriver driver;

        if (driverName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (driverName.equals("edge")) {
            System.setProperty("webdriver.edge.driver",
                    "src/main/resources/drivers/msedgedriver.exe");

            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else {
            throw new IllegalArgumentException("Driver name " + driverName +
                    " is not supported");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return driver;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
