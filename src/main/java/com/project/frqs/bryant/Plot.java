package com.project.frqs.bryant;

public class Plot {
	private String cropType;
	private int cropYield;

	public Plot(String crop, int yield) {
		this.cropType = crop;
		this.cropYield = yield;
	}
	
	public String getCropType() {
		return cropType;
	}

	public int getCropYield() {
		return cropYield;
	}

	public String toString() {
		return String.format("This farm plants %s with a yield of %s", cropType, cropYield);
	}

	public static void main(String[] args) {
		Plot plot = new Plot("corn", 10);
		System.out.println(plot.getCropType());
		System.out.println(plot.getCropYield());
	}
}