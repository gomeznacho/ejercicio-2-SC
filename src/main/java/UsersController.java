import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class UsersController {
   public static ArrayList<User> usersList = new ArrayList<>();

   public static User findByName(String email){
      for(User u : usersList){
         if(u.getEmail().equals(email))
            return u;
      }
      return null;
   }

   public static void addUser (String email, String password) throws NoSuchAlgorithmException, NoSuchProviderException {
      String slt = getSalt();
      String hshPswrd = getSecurePassword(password, slt);
      usersList.add(new User(email, hshPswrd));
   }

   public static boolean register (String email, String password) throws NoSuchAlgorithmException, NoSuchProviderException {
      String slt = getSalt();
      String hshPswrd = getSecurePassword(password, slt);

      User user = new User(email, hshPswrd);

      for(User u : UsersController.usersList){
         if(u.getEmail().equals(email)) {
            System.out.println("email ya existente");
            return false;
         }
      }
      UsersController.usersList.add(user);
      System.out.println("usuario registrado correctamente");
      System.out.println(user);
      return true;
   }

   public static int login(String email, String password) throws NoSuchAlgorithmException, NoSuchProviderException {
      User user = UsersController.findByName(email);
      if( user == null)
         return -1;
      else{
         String slt = getSalt();
         String hshPswrd = getSecurePassword(password, slt);
         //String storedPswrd = getSecurePassword(user.getPassword(), slt);
         if(hshPswrd.equals(user.getPassword()))
            return 1;
         else return -2;
      }
   }


   public static MessageDigest md;
   static {
      try {
         md = MessageDigest.getInstance("MD5");
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }
   }
   public static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException{
      SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
      byte[] sltB = new byte[16];
      secureRandom.nextBytes(sltB);
      return sltB.toString();
   }

   public static String getSecurePassword(String rawPassword, String salt){
      String hshPswrd = null;
      try{
         md.update(salt.getBytes());
         byte[] sltB = md.digest(rawPassword.getBytes());
         StringBuilder sb = new StringBuilder();
         for (byte b : sltB) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
         }
         hshPswrd = sb.toString();
      }catch(Exception e){
         e.printStackTrace();
      }
      return hshPswrd;
   }


}
