package Steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Tc001 {
    @Test
    public void TC001() throws MalformedURLException{
        setUp();



    }

    public void setUp() throws MalformedURLException {
        File apk = new File("../../../testData/apk/exampleApk.apk");
        String deviceName = "Galaxy_Nexus_API_24";
        String udid = "emulator-5554";
        String platformName = "Android";
        String platformVersion = "7.0";
        String skipUnlock = "true";
        String appPackage = "com.example.work.thetestingworld";
        String appActivity = "com.example.work.thetestingworld.Splash";
        String noReset = "false";
        final String autoGrantPermissions = "true";
        String apkName = "exampleApk.apk";
        File classpathRoot = new File(System.getProperty("user.dir"));
        // /Users/josemiguel/IdeaProjects/ioappium/src/testData/apk
        File appDir = new File(classpathRoot,"//src//testData//apk");
        File app = new File(appDir, apkName);
        String appiumServer = "http://127.0.0.1:4723/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Capabilities test
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

        AndroidDriver driver = new AndroidDriver(new URL(appiumServer), capabilities);
    }
}
