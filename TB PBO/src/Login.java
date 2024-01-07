import java.util.HashMap;
import java.util.Scanner;

public class Login extends Parkir{

    public void login(){

        HashMap<String,String> login = new HashMap<>();
    
        login.put("ari", "ariraihandafa");
        login.put("raihan", "raihandafaari");
        login.put("dafa", "dafaariraihan");
    
        System.out.println("=====HALAMAN LOGIN======");
        
        Scanner scannerInput = new Scanner(System.in);
    
        System.out.print("Username : ");
        String username = scannerInput.nextLine();
        System.out.print("Password : ");
        String password = scannerInput.nextLine();
    
        while (!login.containsKey(username) || !login.get(username).equals(password)) {
            System.err.println("LOGIN GAGAL, SILAHKAN LOGIN KEMBALI\n");
            System.out.print("Username : ");
            username = scannerInput.nextLine();
            System.out.print("Password : ");
            password = scannerInput.nextLine();
    
        }
        System.out.println("LOGIN BERHASIL");
    
    }

}
