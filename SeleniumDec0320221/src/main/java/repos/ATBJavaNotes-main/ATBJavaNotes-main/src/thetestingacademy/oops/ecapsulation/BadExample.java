package thetestingacademy.oops.ecapsulation;

public class BadExample {

    public static void main(String[] args) {
        vwoLogin vwoLogin = new vwoLogin("admin","admin");
        boolean check = vwoLogin.isLoggedIn("admin","admin");
        System.out.println(check);
    }
}

class vwoLogin{

    public String username;
    public String password;

    vwoLogin(String u, String p){
        this.password = p;
        this.username = u;
    }

    boolean isLoggedIn(String username, String password){
        if(this.username.toLowerCase().equals(username) && this.password.toLowerCase().equals(password))
        {
            System.out.println("Logged IN!!");
            return true;
        }
        else {
            System.out.println("Wrong");
            return false;
        }

    }


}
