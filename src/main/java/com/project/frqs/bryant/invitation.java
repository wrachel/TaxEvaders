package com.project.frqs.bryant;

public class invitation {
    private String hostName;
    private String address;

    public invitation(String hostName, String address) {
        this.hostName = hostName;
        this.address = address;
    }

    public invitation(String address) {
        this.hostName = "Host";
        this.address = address;
    }

    public String getHostName() {
        return hostName;
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public String generateInvitation(String name) {
        return String.format("Dear %s, please attend my event at %s. See you then, %s.", name, address, hostName);
    }

    public static void main(String[] args) {
        invitation testOne = new invitation("Karen", "hell");
        System.out.println(testOne.getHostName());
        testOne.updateAddress("some supermarket or something idk");
        System.out.println(testOne.generateInvitation("Steven"));

        invitation testTwo = new invitation( "hell");
        System.out.println(testTwo.getHostName());
        testTwo.updateAddress("some supermarket or something idk");
        System.out.println(testTwo.generateInvitation("Steven"));
    }
}