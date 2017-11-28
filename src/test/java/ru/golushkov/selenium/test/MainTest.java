package ru.golushkov.selenium.test;

        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.List;
        import java.util.concurrent.TimeUnit;

        import static org.openqa.selenium.Keys.*;

public class MainTest {

    @Test
    public void mainTest() throws InterruptedException, MalformedURLException {
        //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        // Создаем экземпляр WebDriver
        // Следует отметить, что скрипт работает с интерфейсом,
        // а не с реализацией.


        // Переход в полный экран
        driver.manage().window().maximize();
        // Переход в Яндекс, используя драйвер
        driver.get("https://www.yandex.ru");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        //driver.get("http://www.google.com");

        // По-другому это можно сделать так:
        //driver.navigate().to("http://www.google.com");
        // Находим элемент по атрибуту name “click/clickAndWait”
        //WebElement element = driver.findElement(By.cssSelector("body > div.container.rows > div.row.rows__row.rows__row_main > div.col.main.widgets.i-bem.widgets_js_inited > div.container.container__search.container__line > div > div.col.col_home-arrow > div > div.home-arrow__tabs > div > a:nth-child(5)"));
        //Маркет
        WebElement element;
        element = driver.findElement(By.cssSelector("a.home-link[data-id=market]"));
        element.click();
        System.out.println(driver.getTitle());
        //Компьютеры
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element = driver.findElement(By.cssSelector("body > div.main > div.topmenu.i-bem.topmenu_js_inited > noindex > ul > li:nth-child(2) > a"));
        element.click();
        //Планшеты
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element = driver.findElement(By.cssSelector("body > div.main > div:nth-child(4) > div.layout-grid__col.layout-grid__col_width_2 > div > div:nth-child(1) > div > a:nth-child(1)"));
        element.click();
        //Ко всем фильтрам
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[30]/div[2]/a"));
        element.click();
        // от 20 000 до 25 000
        element = driver.findElement(By.xpath("//*[@id='glf-pricefrom-var']"));
        element.sendKeys("20000"); // от 20 000
        element = driver.findElement(By.xpath("//*[@id='glf-priceto-var']"));
        element.sendKeys("50000"); // до 50 000
        //Все производители
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/button"));
        element.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Выбор Aser и dell
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element = driver.findElement(By.xpath("//*[@for='glf-7893318-267101']")); // Aser
       //<label class="checkbox__label" for="glf-7893318-267101">Acer</label>
        element.click();
        element = driver.findElement(By.xpath("//body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div/span/span/input")); // Ввод Dell
        element.sendKeys("Dell");
/*        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element.sendKeys(TAB);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element.sendKeys(SPACE);
*/      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element = driver.findElement(By.xpath("//span[@for=glf-7893318-153080]")); // Dell
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        element.click();
        //Подобрать
        element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[4]/a[2]")); // Подбор
        element.click();
        // Подсчет элемнтов //input[@id='passwd-id']"

        List<WebElement> list  = driver.findElements(By.className("link n-link_theme_blue link_type_cpc i-bem link_js_inited")); // /html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[3]
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println(list.size());



        // Закрываем браузер
        //driver.quit();
        //WebElement element = driver.findElement(By.xpath("xpath=//a[data-id=market]"));
        //element.click();
        // element.clickandwait; drive.clickandwait(element);
        // Проверка заголовка // driver.verifyTitle(glob:*Film*Television*);
/*
        // Вводим текст
        element.sendKeys("Selenium");

        // Отправляем форму, при этом драйвер сам определит как отправить форму по элементу
        element.submit();

        // Проверяем тайтл страницы
        System.out.println("Page title is: " + driver.getTitle());

        // Страницы гугл динамически отрисовываются с помощью javascript
        // Ждем загрузки страницы с таймаутом в 10 секунд
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("selenium");
            }
        });

        // Ожидаем увидеть: "Selenium - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        // Закрываем браузер
        driver.quit();
*/
    }
}
