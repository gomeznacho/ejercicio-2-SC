public class Main {

    public static void main(String[] args) {
        UsersRepo.addUser("jimy", "1234");
        UsersRepo.addUser("jimbo", "5678");

        Registro.register("james", "4321");
        System.out.println(Login.login("jambo", "5678"));
    }
}


