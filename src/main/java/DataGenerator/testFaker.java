package DataGenerator;

public class testFaker {

        public static void main(String[] args) {
            UserGenerator userGenerator = new UserGenerator();

            System.out.println("company: " + userGenerator.company);
            System.out.println("First Name: " + userGenerator.firstName);
            System.out.println("Last Name: " + userGenerator.lastName);
            System.out.println("Phone: " + userGenerator.phoneNumber);
            System.out.println("Email:" + userGenerator.email);
            System.out.println("Password:" + userGenerator.password);
            System.out.println("SiteUrl:" + userGenerator.siteUrl);
        }
}
