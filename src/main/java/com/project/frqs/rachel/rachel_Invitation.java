package com.project.frqs.rachel;

public class rachel_Invitation {
    private String hostName;
    private String address;

    public rachel_Invitation(String n, String a){
        hostName = n;
        address = a;
    }
    public rachel_Invitation(String add){
        address = add;
        hostName = "host";
    }
    public String invitedPerson(String invited){
        String returnstatement = "Dear " + invited + ", please attend my event at " + address + ". See you then, " + hostName + ".";
        return returnstatement;
    }
}
