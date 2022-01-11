package com.project.frqs.rachel;
import java.util.Random;

public class rachelfrq5q2 {
    private int length;
    private String prefix;
    private static int passwordsGen=0;

    public rachelfrq5q2(int length, String prefix){
        this.prefix = prefix;
        this.length = length;
    }
    public rachelfrq5q2(int length){
        this.length = length;
        prefix = "A";
    }

    public String pwGen(){
        Random rand = new Random();
        String password = prefix + ".";

        for(int i = 0; i < length; i++){
            password = password + rand.nextInt(9);
        }
        passwordsGen += 1;
        return password;
    }

    public int pwCount(){
        return passwordsGen;
    }

    /*public static void main(String[] args){
        rachelfrq5q2 pw1 = new rachelfrq5q2(4, "chs");
        //can use methods and System.out.println statements as needed to print passwords & password counts
        System.out.println(pw1.pwCount());
        System.out.println(pw1.pwGen());
        System.out.println(pw1.pwGen());
        System.out.println(pw1.pwCount());

        rachelfrq5q2 pw2 = new rachelfrq5q2(6);
        System.out.println(pw2.pwCount());
        System.out.println(pw2.pwGen());
        System.out.println(pw2.pwCount());
        System.out.println(pw1.pwCount());

    }

     */
}
