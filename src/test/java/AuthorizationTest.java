import BaseTest.BaseAutTest;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

public class AuthorizationTest extends BaseAutTest {

    //Тест с корректным логином и паролем
    @Test
    @Epic("Авторизация")
    @Feature("Авторизация пользователя")
    @Story("Успешная авторизация")
    @Description("Успешная авторизация с корректными данными логин и пароль")
    @Severity(SeverityLevel.BLOCKER)
    public void testSuccessfulAuthorizationWithCorrectData() {
        loginPage.filLoginAndAuth(CORRECT_LOGIN, CORRECT_PASSWORD);
        String actualResult = lkPage.userNameIsExist();
        Assert.assertEquals("Успешная авторизация", "Test Cool", actualResult);
    }
    //Тест с корректным логином и рандомным паролем
    @Test
    @Story("Неудачная авторизация")
    @Description("Неудачная авторизация с корректным логином и некорректным паролем")
    public void testAuthorizationWithIncorrectPassword() {
        loginPage.filLoginAndAuth(CORRECT_LOGIN, userGenerator.password);
        String actualResult = loginPage.getFailedEmptyPasswordMessage();
        Assert.assertEquals("Неудачная авторизация с некорректным паролем", "Неверный e-mail или пароль.", actualResult);
    }
    //Тест с некорректным логином и корректным паролем
    @Test
    @Story("Неудачная авторизация")
    @Description("Неудачная авторизация с корректным паролем и некорректным логином")
    public void testAuthorizationWithIncorrectLogin() {
        loginPage.filLoginAndAuth(userGenerator.email, CORRECT_PASSWORD);
        String actualResult = loginPage.getFailedEmptyPasswordMessage();
        Assert.assertEquals("Неудачная авторизация с некорректным логином", "Неверный e-mail или пароль.", actualResult);
    }
    //Тест на попытку авторизации без пароля
    @Test
    @Story("Неудачная авторизация")
    @Description("Неудачная авторизация с корректным логином и пустым полем пароля")
    public void testAuthorizationWithoutPassword() {
        loginPage.filLoginAndAuth(CORRECT_LOGIN,"");
        String actualResult = loginPage.getFailedEmptyPasswordMessage();
        Assert.assertEquals("Пустой пароль", "Введите пароль", actualResult);
    }
    //Тест на попытку авторизации без логина
    @Test
    @Story("Неудачная авторизация")
    @Description("Неудачная авторизация с пустым логином и корректным паролем")
    public void testAuthorizationWithoutLogin() {
        loginPage.filLoginAndAuth("",CORRECT_PASSWORD);
        String actualResult = loginPage.getFailedEmptyLoginMessage();
        Assert.assertEquals("Пустой логин", "Введите логин", actualResult);
    }
    //Тест на кликабельность кнопки регистрации
    @Test
    @Story("Проверка кликабельности кнопки 'Регистрации'")
    @Description("Клик на кнопку 'Регистрация' для создания нового пользователя")
    public void testClickRegistrationButton(){
        loginPage.clickRegButton();
        Assert.assertTrue("Кнопка не найдена", registrationPage.registrationButtonIsDisplayed());
    }
    //Тест на кликабельность кнопки забыл пароль
    @Test
    @Story("Проверка кликабельностьти кнопки 'Забыл пароль?'")
    @Description("Клик на кнопку 'Забыл пароль?' для восстановления пароля")
    public void testClickPasswordRecoveryButton(){
        loginPage.clickPasRecButton();
        Assert.assertTrue("Кнопка не найдена", loginPage.passwordRecoveryButtonIsDisplayed());
    }
    //Тест на проверку глаза у поля пароль
    @Test
    @Story("Проверка глаза у поля пароль")
    @Description("Нажатие на кнопку глаза делает видимым поле пароль и появляется возможность сделать getValue")
    public void testPasswordAuthorizationVisabilityTest(){
        loginPage.setPassword(CORRECT_PASSWORD);
        loginPage.clickEyeVisibleInvisible();
        String actualResult = loginPage.getPasswordFromPasswordField();
        Assert.assertEquals("Пароль показан", CORRECT_PASSWORD, actualResult);
    }
}
