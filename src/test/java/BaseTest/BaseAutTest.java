package BaseTest;

import DataGenerator.UserGenerator;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import pages.LkPage;
import pages.LoginPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

abstract public class BaseAutTest {

    String AUTH_PAGE_URL = /*"https://localhost:5001/Account/Login";*/
            "https://dashboard.cryptadium.dev/Account/Login";

    protected static LkPage lkPage;
    protected static LoginPage loginPage;
    protected static UserGenerator userGenerator;
    protected static RegistrationPage registrationPage;

    protected String CORRECT_LOGIN = "alisher.nurgaliev64@gmail.com";
    protected String CORRECT_PASSWORD = "1q2w3e4rFrog%";

    protected void setUp() {
        open(AUTH_PAGE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        lkPage = page(LkPage.class);
        loginPage = page(LoginPage.class);
        userGenerator = page(UserGenerator.class);
        registrationPage = page(RegistrationPage.class);

    }

    @Before
    public void init() {
        setUp();
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
