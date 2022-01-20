package com.project.frqs.rachel;

import java.lang.Math;

public class LightSequence {
    private String seq;

    public LightSequence(String seq) { // constructor moment
        this.seq = seq;
    }

    public String insertSegment(String segment, int ind) { // substring concatenation to insert a string
        String newString = seq.substring(0, ind) + segment + seq.substring(ind+1);
        return newString;
    }

    public void changeSequence(String returnseq) { // literally just a setter
        seq = returnseq;
    }

    public void display() { // console bs
        System.out.println(this.seq);
    }

    public String getSeq(){
        return this.seq;
    }

    public static String[] display_everything(int vertical, int horizontal, String initSeq, String changeSeq, String segment, String oldSeq, String insertSeg) {
        String[] displayArray = new String[6];

        com.project.frqs.rachel.LightSequence gradShow = new com.project.frqs.rachel.LightSequence(initSeq);
        displayArray[0] = gradShow.getSeq();
        gradShow.changeSequence(changeSeq);
        displayArray[1] = gradShow.getSeq();
        displayArray[2] = gradShow.insertSegment(insertSeg, 4);
        displayArray[3] = oldSeq.replaceFirst(segment, "");
        displayArray[4] = segment;
        displayArray[5] = String.valueOf(Math.sqrt(vertical*vertical + horizontal*horizontal));
        return displayArray;
    }



}

