package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static common.Util.getUrl;
import static common.Util.readPropertiesFile;

public class Hooks {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;
    public static AppiumServiceBuilder builder;
    public static DesiredCapabilities cap;

    @Before
    public void androidSetUpAppium() {
        System.out.println("setup driver");
        String appPath= readPropertiesFile().get("appPath");
        URL appiumUrl = getUrl(readPropertiesFile().get("appiumURL"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability("appPackage", readPropertiesFile().get("appPackage"));
        capabilities.setCapability("appActivity", readPropertiesFile().get("appActivity"));
        capabilities.setCapability("autoGrantPermissions ", true);
        driver = new AndroidDriver(appiumUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.removeApp(readPropertiesFile().get("appPackage"));
//        driver.installApp(appPath);
//        driver.launchApp();
    }
}
