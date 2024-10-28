package dev.lpa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Animal animal = new Animal ("animal", "big", 100);
        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);
        //Howling! Howling! Wolf walking

        // this list can contain any kind of animal
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 20));
        //Howling! Dog (Wolf) walking
        //Dog (Wolf) shed hair all the time
        //Woof! Dog (German Shepard) walking
        //Dog (German Shepard) shed hair all the time
        //swish Fish (Goldfish) lazily
        //splash Fish (Barracuda) lazily
        //Woof! Dog (Pug) walking
        //Dog (Pug) shed hair all the time

        animals.add(new Horse("Clydesdale", "large", 1000));
        //Horse (Clydesdale) walks
        //Horse (Clydesdale) sheds in the spring


        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if(animal instanceof Mammal currentMammal){
                currentMammal.shedHair();
            }
        }
    }

    private static void doAnimalStuff(Animal animal){

        //even though Animal has no moving or other, it will call Dog if we pass it as method
        animal.makeNoise();
        animal.move("slow");
    }
}
