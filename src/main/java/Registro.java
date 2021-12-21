public class Registro {

    public static boolean register (String email, String password){

        User user = new User(email, password);
        for(User u : UsersRepo.usersList){
            if(u.getEmail().equals(email)) {
                System.out.println("email ya existente");
                return false;
            }
        }
        UsersRepo.usersList.add(user);
        System.out.println("usuario registrado correctamente");
        System.out.println(user);
        return true;
    }



}
