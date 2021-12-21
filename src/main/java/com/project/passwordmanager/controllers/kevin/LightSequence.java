package com.project.passwordmanager.controllers.kevin;

// UNIT 2 FRQ


public class LightSequence {

    // instance variable seq
    private String seq;

    public LightSequence(String seq) {
        this.seq = seq;
    }

    public String insertSegment(String segment, int ind) {
        String newString = seq.substring(0, ind) + segment + seq.substring(ind);
        return newString;
    }
    public void changeSequence(String seq) {
        this.seq = seq;
    }

    public void display() {
        System.out.println(seq);
    }

    public String getSeq() {
        return seq;
    }


}