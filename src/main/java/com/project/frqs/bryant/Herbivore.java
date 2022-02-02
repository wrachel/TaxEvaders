package com.project.frqs.bryant;

public class Herbivore extends Animal {

	public Herbivore(String species, String name) {
		super("herbivore", species, name);
	}

	public static void main(String[] args) {
		Herbivore gary = new Herbivore("giraffe", "Gary");
		System.out.println(gary);
	}
}