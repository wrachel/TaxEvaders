package com.project.passwordmanager.controllers.harry;

public class experimentalFarm {
    private Plot[][] farmPlots;

    public experimentalFarm(Plot[][] p) {
        this.farmPlots = p;
    }

    /**
     * Returns the plot with the highest yield for a given crop type, as described in part (a).
     */
    public Plot getHighestYield(String c) {
        Plot plot = null;
        int highest = this.farmPlots[0][0].getCropYield();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (farmPlots[i][j].getCropType().equalsIgnoreCase(c) && farmPlots[i][j].getCropYield() > highest) {
                    highest = farmPlots[i][j].getCropYield();
                    plot = farmPlots[i][j];
                }
            }
        }
        if (plot != null)
            return plot;
        else
            return null;
        /* to be implemented in part (a) */
    }

    /**
     * Returns true if all plots in a given column in the two-dimensional array farmPlots
     * contain the same type of crop, or false otherwise, as described in part (b).
     */
    public boolean sameCrop(int col) {
        boolean check = true;
        ;
        String crop = farmPlots[0][col].getCropType();
        for (int i = 0; i < 4; i++) {
            if (!farmPlots[i][col].getCropType().equalsIgnoreCase(crop)) {
                check = false;
                break;
            }
        }
        return check;
        /* to be implemented in part (b) */
    }
}
