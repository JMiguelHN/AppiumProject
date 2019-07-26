package Driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private AndroidDriver driver;
    private String deviceName;
    private String platformName;
    private String platformVersion;
    private String skipUnlock;
    private String appPackage ;
    private String appActivity;
    private String noReset;
    private String autoGrantPermissions;
    private String apkName;
    private String appDir;
    private File app;
    private String appiumServer = "http://127.0.0.1:4723/wd/hub";

    public Driver(String platformName) throws MalformedURLException{

        switch(platformName.toLowerCase()){
            case "android":
                setUpAndroid();
                break;
            case "ios":
                setUpIOS();
                break;
            case "hybrid":
                setUpHybrid();
                break;
                default:
                    System.out.println("No valid platform");

        }

    }

    private void setUpAndroid() throws MalformedURLException {

        deviceName = "Galaxy_Nexus_API_24";
        platformName = "Android";
        platformVersion = "7.0";
        skipUnlock = "true";
        appPackage = "com.example.work.thetestingworld";
        appActivity = "com.example.work.thetestingworld.Splash";
        noReset = "false";
        autoGrantPermissions = "true";
        apkName = "exampleApk.apk";
        appDir = System.getProperty("user.dir") + "//src//testData//Application//Android";
        File app = new File(appDir, apkName);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Capabilities for device
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity",appActivity);
        capabilities.setCapability("deviceReadyTimeout", "450");
        capabilities.setCapability("noReset",noReset);
        capabilities.setCapability("autoGrantPermissions", autoGrantPermissions);
        capabilities.setCapability("skipUnlock",skipUnlock);
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("avd", deviceName);

        System.out.println("Starting appium for android...");
        driver = new AndroidDriver(new URL(appiumServer), capabilities);

    }

    private void setUpIOS() throws MalformedURLException {
        System.out.println("Starting appium for IOS...");
    }
    private void setUpHybrid() throws MalformedURLException {
        System.out.println("Starting appium for Hybrid applications...");
    }

    public AndroidDriver getDriver(){
        return driver;
    }

}
