import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class UsersRepo {
   public static ArrayList<User> usersList = new ArrayList<>();

   public static User findByName(String email){
      for(User u : usersList){
         if(u.getEmail().equals(email))
            return u;
      }
      return null;
   }

      public static MessageDigest md;
   static {
      try {
         md = MessageDigest.getInstance("MD5");
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }
   }

   public static void addUser (String email, String password){

      md.update(password.getBytes());
      byte[] pswrdB = md.digest();
      StringBuilder sb = new StringBuilder();
      for (byte b : pswrdB) {
         sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
      }
      String hshPswrd = sb.toString();
      usersList.add(new User(email, hshPswrd));

   }

}
