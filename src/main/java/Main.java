public class Main {

    public static void main(String[] args) {
        UsersController.addUser("jimy", "1234");
        UsersController.addUser("jim", "1234");
        UsersController.addUser("jimbo", "5678");

        //casos de pruba de registro
        UsersController.register("james", "4321");
        UsersController.register("james", "4321");

        //casos de preba de login
        System.out.println(UsersController.login("jimbo", "5678"));
        System.out.println(UsersController.login("jimbo", "578"));
        System.out.println(UsersController.login("jambo", "578"));
    }
}


