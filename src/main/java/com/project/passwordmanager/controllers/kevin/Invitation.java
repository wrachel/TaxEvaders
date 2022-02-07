package com.project.passwordmanager.controllers.kevin;

public class Invitation {

    private String address;
    private String hostName;

    public String getHostName()
    {
        return hostName;
    }

    public void setAddress(String addy)
    {
        address=addy;
    }

    public String invite(String me)
    {
        return "Dear "+me+", please attend my event at " + address + ". See you then, " + hostName + ".";
    }

    public Invitation(String address) {
        this.address = address;
        hostName = "Host";
    }



}

