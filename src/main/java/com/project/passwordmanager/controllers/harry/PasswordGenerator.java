package com.project.passwordmanager.controllers.harry;

import java.util.Random;

class PasswordGenerator {
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
    public String[] main(String prefix, int length, int second) {
        PasswordGenerator pw1 = new PasswordGenerator(length, prefix);
        PasswordGenerator pw2 = new PasswordGenerator(second);
        String[] arr =new String[8];

        for (int i =0; i<8; i++) {
            switch (i) {
                case 0:
                    arr[i]=Integer.toString(pw1.pwCount());
                    break;
                case 1:
                    arr[i]=pw1.pwGen();
                    break;
                case 2:
                    arr[i]=pw1.pwGen();
                    break;
                case 3:
                    arr[i]=Integer.toString(pw1.pwCount());
                    break;
                case 4:
                    arr[i]=Integer.toString(pw2.pwCount());
                    break;
                case 5:
                    arr[i]=pw2.pwGen();
                    break;
                case 6:
                    arr[i]=Integer.toString(pw2.pwCount());
                    break;
                case 7:
                    arr[i]=Integer.toString(pw1.pwCount());
                    break;
            }
        }
        return arr;
    }
}
