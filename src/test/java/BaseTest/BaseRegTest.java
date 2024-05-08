package BaseTest;

import DataGenerator.UserGenerator;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import pages.LkPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BaseRegTest {

    protected static RegistrationPage registrationPage;
    protected static UserGenerator userGenerator;
    private static LkPage lkPage;
    private static String REGISTRATION_PAGE_URL = /*"https://cryptadium.dev/Account/RegisterCompany"*/ "https://localhost:5001/Account/RegisterCompany";
    protected static String EXISTED_EMAIL = "alisher.nurgaliev64@gmail.com";
    protected static String EXISTED_PHONE = "9603456621";

    @Before
    public void setUp() {
        open(REGISTRATION_PAGE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage = page(RegistrationPage.class);
        lkPage = page(LkPage.class);
        userGenerator = page(UserGenerator.class);
    }


    @After
    public void tearDown() {
        // Закрытие браузера после каждого теста
        // Можно также добавить дополнительные действия, например, сохранение скриншота или очистку cookies
        // Пример: Selenide.screenshot("screenshot_name");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
