package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class RegistrationPage {

    private final String REGISTRATION_PAGE_URL = "https://cryptadium.dev/Account/RegisterCompany";

    //Локатор для поля компании
    private SelenideElement companyField = $("#company");
    //Локатор для поля Имя
    private SelenideElement firstNameField = $("#firstname");
    //Локатор для поля Фамилия
    private SelenideElement lastNameField = $("#lastname");
    //Локатор для поля сылки на сайт
    private SelenideElement siteUrlField = $("#SiteUrl");
    //Локатор для выпадающего списка тип бизнеса
    private SelenideElement businessTypeIdBox = $("#BusinessTypeId");
    //Локатор для поля Email
    private SelenideElement emailField = $("#email");
    //Локатор для выпадающего списка флага страны
    private SelenideElement countryFlag = $x("//div[@class='flag-container']");
    //Локатор для поля номера
    private SelenideElement phoneField = $("#phone");
    //Локатор для поля пароля
    private SelenideElement passwordField = $("#password");
    //Локатор для поля повторить пароль
    private SelenideElement passwordConfirmField = $("#passwordConfirm");
    //Локатор для иконки глаза сокрытия пароля
    private SelenideElement inputIconField = $("div.modal__input-icon");
    //Локатор для чек-бокса персональных данных
    private SelenideElement personalButton = $("#personal");
    //Локатор для кнопки Зарегестрироваться
    private SelenideElement registrationButton = /*$("body > div > section > form > button");*/ $x("//button[@class=\"modal__button-new\"]");
    //Локатор для кнопки Войти
    private SelenideElement singInButton = $x("//a[@class='modal__href']");
    //Локатор сообщения под полем email
    private SelenideElement errorEmailMessage = $x("//p[text()='Некорректный email']");
    //Локатор сообщения под полем email что данный пользователь уже сужествует
    private SelenideElement errorTextEmailMessage = $x("//p[text()='Пользователь с указанным Email уже существует.']");
    //Локатор сообщения под полем телефон
    private SelenideElement errorPhoneMessage = $x("//p[text()='Пользователь с указанным номером телефона уже существует.']");
    //Локатор сообщения под полем чек-боксом Пользовательского соглашения
    private SelenideElement errorPersonalMessage = $x("//p[text()='Установите флажок, если хотите продолжить']");
    //Локатор для оповещения "Ошибка авторизации"
    private SelenideElement wrongRegistrationMessage = $("body > div > section > form > p");
    //Локатор подсвечивания поля пароля красным
    private SelenideElement errorPasswordMessage = $x("//input[@class='modal__form-input error']");

    //Установка полю Имя значения {company}
    public void setCompanyField(String company) {

        companyField.setValue(company);
    }
    //Установка полю Имя значения {firstName}
    public void setFirstNameField(String firstName) {

        firstNameField.setValue(firstName);
    }
    //Установка полю Фамилия значения {lastName}
    public void setLastNameField(String lastName) {

        lastNameField.setValue(lastName);
    }
    //Установка полю сылка на сайт компании значения {siteUrl}
    public void setSiteUrlField(String siteUrl) {

        siteUrlField.setValue(siteUrl);
    }
    //Раскрытие выпадающего списка "вид бизнеса"
    public void clickBusinessTypeIdBox() {

        businessTypeIdBox.click();
        $$("#BusinessTypeId > option:nth-child(10)").find(Condition.text("Other")).click();

        //$$("#iti-item-ru").find(Condition.text("Russia")).click();
    }
    //Установка полю Email значения {email}
    public void setEmailField(String email) {

        emailField.setValue(email);
    }
    //Раскрытие выпадающего списка "флаг"
    public void clickCountryFlag() {

        countryFlag.click();
        $$("#iti-item-ru").find(Condition.text("Russia")).click();
    }
    //Установка полю телефон значения {phone}
    public void setPhoneField(String phone) {

        phoneField.setValue(phone);
    }
    //Установка полю пароль значения {password}
    public void setPasswordField(String password) {

        passwordField.setValue(password);
    }
    //Установка полю повторить пароль значения {passwordConfirm}
    public void setPasswordConfirmField(String passwordConfirm) {

        passwordConfirmField.setValue(passwordConfirm);
    }
    //Клик по чек-боксу Персональное соглашение
    public void clickPersonalAgreementCheckBox(){
        personalButton.click();
    }
    //Клик по глазу видимости
    public void clickEyeVisibleInvisible(){
        inputIconField.click();
    }
    //Клик по кнопке Регистрации
    public void clickRegistrationButton() {

        registrationButton.click();
    }
    //Получение сообщения об существующем пользователе под полем Email
    public String getErrorTextEmailMessage() {
        errorTextEmailMessage.shouldBe(visible);
        return errorTextEmailMessage.getText();
    }
    //Кнопка регистрации существует
    public boolean registrationButtonIsDisplayed(){
        return registrationButton.exists();
    }
    //Получение текста из оповещения авторизации
    public String getErrorAuthorizationMessage() {
        wrongRegistrationMessage.shouldBe(visible);
        return wrongRegistrationMessage.getText();
    }
    //Получение сообщения об ошибке под полем Телефон
    public String getErrorPhoneMessage() {
        errorPhoneMessage.shouldBe(visible);
        return errorPhoneMessage.getText();
    }
    //Получение значения из поля password
    public String getErrorPasswordMessage(){
        errorPasswordMessage.shouldBe(visible);
       return errorPasswordMessage.getValue();
    }
//    //Получение сообщения об ошибке под полем Email
//    public String getErrorEmailMessage() {
//
//        return errorEmailMessage.getText();
//    }
//    //Получение сообщения об ошибке под чек-боксом Пользовательского соглашения
//    public String getErrorPersonalMessage() {
//
//        return errorPersonalMessage.getText();
//    }
//    //Кнопка регистрации существует
//    public boolean singInButtonIsDisplayed(){
//        return singInButton.exists();
//    }
    //Конструктор для заполнения полей регистрации и клик по кнопке регистрации"
    public void registration(String company, String firstName, String lastName, String siteUrl, String email, String phone, String password, String passwordConfirm) {
        setCompanyField(company);
        setFirstNameField(firstName);
        setLastNameField(lastName);
        setSiteUrlField(siteUrl);
        clickBusinessTypeIdBox();
        setEmailField(email);
        clickCountryFlag();
        setPhoneField(phone);
        setPasswordField(password);
        setPasswordConfirmField(passwordConfirm);
        clickPersonalAgreementCheckBox();
        clickRegistrationButton();
    }
}
