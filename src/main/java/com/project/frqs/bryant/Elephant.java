package com.project.frqs.bryant;

public class Elephant extends Herbivore {
	private double tuskLength;

	public Elephant(String name, double tuskLength) {
		super("elephant", name);
		this.tuskLength = tuskLength;
	}

	public String toString() {
		return super.toString() + " with tusks " + tuskLength + " meters long";
	}

	public static void main(String[] args) {
		Elephant percy = new Elephant("Percy", 2.0);
		System.out.println(percy);
	}
}