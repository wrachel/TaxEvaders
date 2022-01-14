package com.project.passwordmanager.controllers.harry;
import java.util.Random;

public class frq5 {
   public String invite(String host, String add, String invitee){
       return "";
   }
}
class question1 extends frq5{
    public String invite(String host, String add, String invitee){
        return "Dear "+ invitee+", please attend my event at "+add + ". See you then, "+ host+ ".";

    }
}
 class PasswordGenerator extends frq5 {
    private static int passwordsGenerated =0;
    private static Random random = new Random();
    private String prefix;
    private int length;

    public PasswordGenerator(int length,String prefix) {
        this.prefix = prefix;
        this.length = length;
    }
    public PasswordGenerator(int length) {
        this.prefix = "A";
        this.length = length;
    }
    public String pwGen(){
        String pwd= this.prefix+".";
        for(int i=1;i<=this.length;i++){
            pwd+=random.nextInt(10);
        }
        passwordsGenerated+=1;
        return pwd;
    }
    public int pwCount(){
        return passwordsGenerated;
    }
    public void main() {
        PasswordGenerator pw1 = new PasswordGenerator(4,"chs");
        System.out.println(pw1.pwCount());
        System.out.println(pw1.pwGen());
        System.out.println(pw1.pwGen());
        System.out.println(pw1.pwCount());
        PasswordGenerator pw2 = new PasswordGenerator(6);
        System.out.println(pw2.pwCount());
        System.out.println(pw2.pwGen());
        System.out.println(pw2.pwCount());
        System.out.println(pw1.pwCount());
    }
}

