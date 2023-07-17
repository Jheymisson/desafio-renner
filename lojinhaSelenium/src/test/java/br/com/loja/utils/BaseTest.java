package br.com.loja.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver inicializacao(String browser) {
		try {
			if (browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver());
			} else if (browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());
			} else if (browser.equals("safari")) {
				tlDriver.set(new SafariDriver());
			} else {
				System.out.println("Informe o nome do navegador corretamente: " + browser);
			}

			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			getDriver().get("https://automationexercise.com/");

			return getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Runtime.getRuntime().addShutdownHook(new Thread(this::encerrarDriver));
		}

		return null;
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	private void encerrarDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
		}
	}
}
