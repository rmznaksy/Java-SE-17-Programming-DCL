package com.example.application;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.example.domain.Animal;
import com.example.domain.Cat;
import com.example.domain.Fish;
import com.example.domain.Pet;
import com.example.domain.Spider;

public class AnimalApp {

	public static void main(String[] args) {
		var animals = List.of(
			new Spider(),
			new Cat(),
			new Fish("Free Willy"),
			new Spider(),
			new Cat("Garfield"),
			new Fish("Nemo"),
			new Spider()
		);
		for (Animal animal : animals) {
			animal.walk();
			animal.eat();
			if(animal instanceof Pet) // Guard
				((Pet)animal).play(); // Safe
		}
		//forEach: Higher-Order Function
		//Consumer<Animal> walk = animal -> animal.walk();
		//Consumer<Animal> eat = animal -> animal.eat();
		Consumer<Animal> walk = Animal::walk;
		Consumer<Animal> eat = Animal::eat;
		Consumer<Animal> playIfPet = animal -> {
			if(animal instanceof Pet)
				((Pet)animal).play();
		};
		//animalparallelStream()
		animals.stream().parallel()
		.forEach(walk.andThen(eat).andThen(playIfPet));
	
	var totalLegsOfPets = 0;
	for(var animal : animals) {
		if(animal instanceof Pet)
			totalLegsOfPets += animal.getLegs();
	}
	
	System.out.printf("Total: %d\n", totalLegsOfPets);
	totalLegsOfPets =
	animals.stream()
			.filter( animal -> Pet.class.isInstance(animal))
			.mapToInt( animal -> animal.getLegs())
			.sum();
	System.out.printf("Total: %d\n", totalLegsOfPets);
	
	var animalCounts =
	animals.stream()
		   .collect(Collectors.groupingBy(
				   Animal::getClass, Collectors.counting()
				   )
		   );
	animalCounts.forEach((clazz,count)->
		System.out.printf("%s: %d\n", clazz.getSimpleName(),count)
			);
	}
}
