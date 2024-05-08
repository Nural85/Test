package DataGenerator;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static String _password;
    Faker faker = new Faker();

    public String company = faker.name().name().replaceAll("\\d", "");
    public String firstName = faker.name().firstName().replaceAll("\\d", "");
    public String lastName = faker.name().lastName().replaceAll("\\d", "");
    public String phoneNumber = "9" + faker.number().digits(9);
    public String email = faker.internet().emailAddress();
    // Генерируем случайную строку с цифрами, маленькими и большими буквами, и специальными символами
    int passwordLength = faker.random().nextInt(8, 17); // Генерируем случайную длину пароля от 8 до 16 символов
    public String password = RandomStringUtils.random(passwordLength, true, true) + RandomStringUtils.randomNumeric(1) + RandomStringUtils.randomAlphabetic(1) + RandomStringUtils.randomAlphabetic(1) + RandomStringUtils.random(1, "!@#$%^&*()_+-=[]{}|;:'\",.<>/?") + faker.lorem().characters(2, 4, true, true);
    public String siteUrl = "https://example.com/" + RandomStringUtils.randomAlphanumeric(8);

}
