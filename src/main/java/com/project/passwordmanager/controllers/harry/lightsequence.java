package com.project.passwordmanager.controllers.harry;

import java.io.PrintWriter;

public class lightsequence {

    private String seq;
private String oldsequence;
    public lightsequence(String seq) {
        this.seq = seq;
        oldsequence =seq;
    }

    public String insertSegment(String segment, int ind) {
        String newString = seq.substring(0, ind) + segment + seq.substring(ind+segment.length());
        return newString;
    }
    public void changeSequence(String newseq) {

        seq= newseq;
    }

    public void display() {
        System.out.println(this.seq);
    }

    public String getSeq() {
        return seq;
    }

}
