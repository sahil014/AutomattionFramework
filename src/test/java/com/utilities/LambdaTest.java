package com.utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTest {

	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverlocal=new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitieslocal=new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver intializeLambda(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap();
        ltOptions.put("user", "sahilnarang014");
        ltOptions.put("accessKey", "LT_xadYDTT2QeeC85oEHW0cFKSIW60TicRc8Tno73MgfmiKSEC");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitieslocal.set(capabilities);
        WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitieslocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driverlocal.set(driver);
        return driverlocal.get();	
      }
	
	public static void quitSession() {
		if(driverlocal.get()!=null) {
			driverlocal.get().quit();
		}
	}
	
}
