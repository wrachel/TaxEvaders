package com.project.frqs.rachel;

public class RachelExperimentalFarm {
    private rachelPlot[][] farmPlots = {{}};

    public rachelPlot getHighestYield(String c){
        int numRows = farmPlots.length;
        int numColumns = farmPlots[0].length;
        int highestYield = 0;

        rachelPlot plot = null;

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                if (farmPlots[i][j].getCropType().equals(c) && farmPlots[i][j].getCropYield() > highestYield){
                    highestYield = farmPlots[i][j].getCropYield();
                    plot = farmPlots[i][j];
                }
            }
        }

        return plot;
    }
}
