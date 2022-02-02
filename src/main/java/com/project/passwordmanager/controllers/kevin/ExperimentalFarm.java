package com.project.passwordmanager.controllers.kevin;

import java.util.Objects;

public class ExperimentalFarm

{

    private Plot[][] farmPlots;



    public ExperimentalFarm(Plot[][] p)

    {

        farmPlots = p.clone();

    }



    /** Returns the plot with the highest yield for a given crop type, as described in part (a). */

    public Plot getHighestYield(String c)

    {
        int highestYield = 0;
        int highestI = 0;
        int highestJ = 0;
        for(int i = 0; i<farmPlots.length; i++) {
            for(int j = 0; j<farmPlots[i].length;j++) {
                if(Objects.equals(farmPlots[i][j].getCropType(), c)) {
                    if(farmPlots[i][j].getCropYield()>highestYield) {
                        highestYield = farmPlots[i][j].getCropYield();
                        highestI = i;
                        highestJ = j;
                    }
                }
            }
        }
        System.out.println("farmPlots["+highestI+"]["+highestJ+"]");
        return farmPlots[highestI][highestJ];
    }



    /** Returns true if all plots in a given column in the two-dimensional array farmPlots

     * contain the same type of crop, or false otherwise, as described in part (b).

     */

    public boolean sameCrop(int col)

    {
        String type = farmPlots[0][col].getCropType();
        for(int i = 0;i<farmPlots.length;i++) {
            if(!(type.equals(farmPlots[i][col].getCropType()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Plot[][] plots = new Plot[4][3];
        String[][] cropArr = {
                {"corn", "corn", "peas"},
                {"peas", "corn", "corn"},
                {"wheat", "corn", "rice"},
                {"corn", "corn", "peas"}
        };
        int[][] yieldArr = {
                {20, 30, 10},
                {30, 40, 62},
                {10, 50, 30},
                {55, 30, 30}
        };
        for(int i = 0; i<plots.length; i++) {
            for(int j = 0; j<plots[i].length; j++) {
                plots[i][j] = new Plot(cropArr[i][j], yieldArr[i][j]);
            }
        }
        ExperimentalFarm f = new ExperimentalFarm(plots);
        System.out.println(f.getHighestYield("corn"));
        System.out.println(f.sameCrop(2));
    }
}