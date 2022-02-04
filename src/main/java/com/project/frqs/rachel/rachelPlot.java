package com.project.frqs.rachel;

public class rachelPlot {
    private String cropType;
    private int cropYield;

    public rachelPlot(String crop, int yield) {
        cropType = crop;
        cropYield = yield;
    }

    public String getCropType(){
        return cropType;
    }

    public int getCropYield() {
        return cropYield;
    }
}
