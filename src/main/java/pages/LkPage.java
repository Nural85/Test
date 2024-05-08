package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LkPage {
    //Локтор для имени пользователя
    private SelenideElement userName = $("div.user_fullName");
    //Локатор для сообщения об авторизации
    private SelenideElement authMessage = $("body > div > section > form > div.modal__form-title.modal__form-title--error.validation-summary-errors > ul > li");


    public String userNameIsExist() {
        return userName.getText();
    }

    public String getSuccessAuthorizationMessage() {
        authMessage.shouldBe(visible);
        return authMessage.getText();
    }
}
