package com.project.frqs.bryant;

public class Animal {	
	private String foodStrategy, species, name;
	
	public Animal(String foodStrategy, String species, String name) {
		this.foodStrategy = foodStrategy;
		this.species = species;
		this.name = name;
	}

	public String toString() {
		return String.format("%s the %s is a %s", name, species, foodStrategy);
	}

	public static void main(String[] args) {
		Animal lisa = new Animal("carnivore", "lion", "Lisa");
		System.out.println(lisa);
	}
}