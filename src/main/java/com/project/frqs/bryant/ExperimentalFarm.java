package com.project.frqs.bryant;
import com.project.frqs.bryant.Plot;

public class ExperimentalFarm {
	private Plot[][] farmPlots;

	public ExperimentalFarm(Plot[][] p) {
		this.farmPlots = p;
	}
 
	/** Returns the plot with the highest yield for a given crop type, as described in part (a). */
	public Plot getHighestYield(String c) {
		int max = -1;
		int max_x = -1;
		int max_y = -1;
		for (int i = 0; i < farmPlots.length; i++) {
			for (int j = 0; j < farmPlots[0].length; j++) {
				if (farmPlots[i][j].getCropType() == c) {
					if (farmPlots[i][j].getCropYield() > max) {
						max = farmPlots[i][j].getCropYield();
						max_x = i;
						max_y = j;
					}
				}
			}
		}
		if (max_x + max_y == -2) {
			return null;
		}
		return farmPlots[max_x][max_y];
	}

	/** Returns true if all plots in a given column in the two-dimensional array farmPlots
	* contain the same type of crop, or false otherwise, as described in part (b). */
	public boolean sameCrop(int col) {
		String cropType = farmPlots[0][col].getCropType();
		
		for (int i = 1; i < farmPlots.length; i++) {
			if (!(farmPlots[i][col].equals(cropType))) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Plot[][] plots = new Plot[][] {
								{new Plot("corn", 20), new Plot("corn", 30), new Plot("peas", 10)},
								{new Plot("peas", 30), new Plot("corn", 40), new Plot("corn", 62)},
								{new Plot("wheat", 10), new Plot("corn", 50), new Plot("rice", 30)},
								{new Plot("corn", 55), new Plot("corn", 30), new Plot("peas", 30)}
							};
		ExperimentalFarm farm = new ExperimentalFarm(plots);
		System.out.println(farm.getHighestYield("corn"));
		System.out.println(farm.sameCrop(0));
		System.out.println(farm.sameCrop(1));
    }
}