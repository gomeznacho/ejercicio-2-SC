public class Login {

    public static int login(String email, String password){
        User user = UsersRepo.findByName(email);
        if( user == null)
            return -1;
        else return 1;
    }


}
