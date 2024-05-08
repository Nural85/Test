import BaseTest.BaseRegTest;
import DataGenerator.UserGenerator;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.LkPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPageTest extends BaseRegTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная регистрация с корректными данными")
    public void testSuccessfulRegistration() {
        registrationPage.registration(userGenerator.company, userGenerator.firstName, userGenerator.lastName, userGenerator.siteUrl, userGenerator.email, userGenerator.phoneNumber, userGenerator.password, userGenerator.password);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Успешная регистрация", "Подтвердите регистрацию. Мы отправили Вам письмо с инструкцией.", actualResult);
    }
    @Test
    @DisplayName("Регистрация с уже зарегистрированным Email")
    @Description("Регистрация с уже зарегистрированным Email, но остальные данные корректны")
    public void testRegistrationWithExistingEmail() {
        registrationPage.registration(userGenerator.company, userGenerator.firstName, userGenerator.lastName, userGenerator.siteUrl, EXISTED_EMAIL, userGenerator.phoneNumber, userGenerator.password, userGenerator.password);
        String actualResult = registrationPage.getErrorTextEmailMessage();
        Assert.assertEquals("Ошибка регистрации", "Пользователь с указанным Email уже существует.", actualResult);
    }
    @Test
    @DisplayName("Регистрация с уже зарегистрированным номером телефона")
    @Description("Регистрация с уже зарегистрированным номером телефона, но остальные данные корректны")
    public void testRegistrationWithExistingPhone() {
        registrationPage.registration(userGenerator.company, userGenerator.firstName, userGenerator.lastName, userGenerator.siteUrl, userGenerator.email, EXISTED_PHONE, userGenerator.password, userGenerator.password);
        String actualResult = registrationPage.getErrorPhoneMessage();
        Assert.assertEquals("Успешная регистрация", "Пользователь с указанным номером телефона уже существует.", actualResult);
    }
    @Test
    @DisplayName("Регистрация с некорректным повторением пароля")
    @Description("Регистрация с уже некорректным повторением пароля, но остальные данные корректны")
    public void testInvalidRepeatPasswords() {
        registrationPage.registration(userGenerator.company, userGenerator.firstName, userGenerator.lastName, userGenerator.siteUrl, userGenerator.email, userGenerator.phoneNumber, userGenerator.password," ");
        String actualResult = registrationPage.getErrorPasswordMessage();
        Assert.assertEquals("Текст не совпадает", "", actualResult);
    }
    @Test
    @DisplayName("Регистрация с пустым полем номера телефона")
    @Description("Регистрация с пустым полем номера телефона, но остальные данные корректны")
    public void testMissingPhoneField() {
        registrationPage.registration(userGenerator.company, userGenerator.firstName, userGenerator.lastName, userGenerator.siteUrl, userGenerator.email," ", userGenerator.password, userGenerator.password);
        String actualResult = registrationPage.getErrorPhoneMessage();
        Assert.assertEquals("Текст не совпадает", "Введите валидный номер", actualResult);
    }
}
