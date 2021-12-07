package com.project.frqs.bryant;

import java.lang.Math;

public class LightSequence {
    private String seq;

    public LightSequence(String seq) { // constructor moment
        this.seq = seq;
    }

    public String insertSegment(String segment, int ind) { // substring concatenation to insert a string
        return this.seq.substring(0, ind) + segment + this.seq.substring(ind);
    }

    public void changeSequence(String seq) { // literally just a setter
        this.seq = seq;
    }

    public void display() { // console bs
        System.out.println(this.seq);
    }

    public String fake_display() { // returns the current sequence as an actually normal getter instead of this console bs we have
        return this.seq;
    }

    public static String[] calculate_sequence(int a, int b, String initSeq, String changeSeq, String segment, String oldSeq, String insertSeg) {
        String[] finalArray = new String[5];

        LightSequence gradShow = new LightSequence(initSeq);
        finalArray[0] = gradShow.fake_display();
        gradShow.changeSequence(changeSeq);
        finalArray[1] = gradShow.fake_display();
        finalArray[2] = gradShow.insertSegment(insertSeg, 4);
        finalArray[3] = oldSeq.replaceFirst(segment, "");
        finalArray[4] = String.valueOf(Math.sqrt(Math.pow(a,2)+Math.pow(b,2)));
        return finalArray;
    }

    public static void main(String[] args) {
        LightSequence gradShow = new LightSequence("0101 0101 0101");
        gradShow.display();
        gradShow.changeSequence("0011 0011 0011");
        String resultSeq = gradShow.insertSegment("1111 1111", 4);
        String newSeq = "1100000111".replaceFirst("00", "");
        System.out.println(Math.sqrt(Math.pow(3,2)+Math.pow(4,2)));
        System.out.println(resultSeq);
        System.out.println(newSeq);
    }

}
