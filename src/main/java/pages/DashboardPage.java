package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private final String BOARD_PAGE_URL = "https://dashboard.cryptadium.dev/Dashboard";


    //Локатор кнопки общий баланс
    private SelenideElement balanceButton = $x("//a[@class='dashboard__link']");


}
