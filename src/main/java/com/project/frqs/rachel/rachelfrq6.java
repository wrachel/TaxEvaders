package com.project.frqs.rachel;
import java.util.ArrayList;

public class rachelfrq6 {

    private ArrayList<String> words;

    public rachelfrq6(ArrayList<String> array){
        words = array;
    }

    public ArrayList<String> returnvalue(ArrayList<String> words){
        ArrayList<String> arrList = new ArrayList<String>(5);

        for (String myValue : words){

            if (myValue.endsWith("ing")){
                arrList.add(myValue);
            }

        }
        return arrList;
    }
}
