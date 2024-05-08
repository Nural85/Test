package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class LoginPage {

    //Локатор поля ввода логина
    private SelenideElement loginField = $x("//input[@name='Email']");
    //Локатор поля ввода пароля
    private SelenideElement passwordField = $x("//input[@name='Password']");
    //Локатор кнопки входа в приложение
    private SelenideElement enterLoginButton = $("button.modal__button-new");
    //Локатор кнопки регистрации на странице авторизации
    private SelenideElement registrationButton = $x("//a[@class='modal__href']");
    //Локатор для поиска красного текста ошибки отсутствия пароля
    private SelenideElement emptyPasswordErrorMessage = $("div.validation-summary-errors");
    //Локатор для поиска красного текста ошибки отсутствия логина
    private SelenideElement emptyLoginErrorMessage = $("div.validation-summary-errors");
    //Локатордля глаза видимый/невидимый пароль
    private SelenideElement eyeVisibleInvisible = $("div.modal__input-icon");
    //Локатор кнопки забыли пароль на странице авторизации
    private SelenideElement passwordRecoveryButton = $x("//a[@class='modal__password']");

    private SelenideElement getPasswordRecoveryButton = $("body > div > section > form > button");

    //Клик по глазу видимости
    public void clickEyeVisibleInvisible(){
        eyeVisibleInvisible.click();
    }
    //Получение кнопки регистрации
    public boolean registrationButtonIsDisplayed(){ return registrationButton.exists(); }
    //Получение кнопки забыли пароль
    public boolean passwordRecoveryButtonIsDisplayed(){ return getPasswordRecoveryButton.exists(); }
    //Получение текста ошибки под полем логин
    public String getFailedEmptyLoginMessage(){
        emptyLoginErrorMessage.shouldBe(visible);
        return emptyLoginErrorMessage.getText();
    }
    //Метод получение текста ошибки под полем пароль
    public String getFailedEmptyPasswordMessage(){
        emptyPasswordErrorMessage.shouldBe(visible);
        return emptyPasswordErrorMessage.getText();
    }
    //Получение Value из поля пароль
    public String getPasswordFromPasswordField(){
        passwordField.shouldBe(visible);
        return passwordField.getValue();
    }

    //Заполнение поля логин значением {username}
    public void setUsername(String username) {

        loginField.setValue(username);
    }

    //Заполнение поля пароль значением {password}
    public void setPassword(String password) {

        passwordField.setValue(password);
    }

    //Клик по кнопке Войти
    public void clickSignInButton() {

        enterLoginButton.click();
    }

    //Клик по кнопке Регистрация
    public void clickRegButton() {

        registrationButton.click();
    }
    //Клик по кнопке забыли пароль
    public void clickPasRecButton() {

        passwordRecoveryButton.click();
    }

    //Заполнение полей Логин и Пароль и клик по кнопке Войти
    public void filLoginAndAuth(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }

}
