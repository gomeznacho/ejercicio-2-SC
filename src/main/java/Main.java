import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        UsersController.addUser("jimy", "1234");
        UsersController.addUser("jim", "1234");
        UsersController.addUser("jimbo", "5678");

        System.out.println(UsersController.usersList.toString());

        UsersController.register("james", "4321");
        System.out.println(UsersController.login("jimbo", "5678"));
    }
}


