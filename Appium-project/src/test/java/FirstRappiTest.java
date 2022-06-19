import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstRappiTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Android Emulator");

        driver = new AndroidDriver(new URL("http://localhost:4720/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test01_click_restaurant_button() throws InterruptedException {
        //code
        driver.findElement(By.id("com.grability.rappi:id/item_content")).click();

    }

    @Test
    public void test03_click_sort_by() {
        driver.findElement(By.id("com.grability.rappi:id/activeFiltersNewStyleChipGroup"))
                .findElement(By.className("android.widget.Button")).click();

    }

    @Test
    public void test04_order_by_delivery_time() {
        driver.findElements(By.id("com.grability.rappi:id/check")).get(2).click();

    }

    @Test
    public void test02_filter_by_food() {
        driver.findElements(By.id("com.grability.rappi:id/constraintLayout")).get(1).click();
    }

    @Test
    public void test05_enter_store() {
        driver.findElements(By.id("com.grability.rappi:id/textView_store_name")).get(0).click();

    }

    @Test
    public void test06_select_product() {
        driver.findElement(By.id("com.grability.rappi:id/rippleForeground")).click();

    }

    @Test
    public void test07_select_topping_and_confirm() {
        driver.findElement(By.id("com.grability.rappi:id/checkbox_topping")).click();
        driver.findElement(By.id("com.grability.rappi:id/addButton")).click();
    }

    @Test
    public void test08_view_order() {
        driver.findElement(By.id("com.grability.rappi:id/basketui_text_view_proceed_label")).click();

    }

    @Test
    public void test09_confirm_order() {
        driver.findElement(By.id("com.grability.rappi:id/basketui_text_view_proceed_label")).click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
