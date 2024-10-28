package dev.lpa;

public class Fish extends Animal {

    public Fish(String type, String size, double weight) {
        //forcing subclass to make a constructor
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        if(speed.equals("slow")){
            System.out.println(getExplicitType() + " lazily");
        } else {
            System.out.println(getExplicitType() + " darting frantically");
        }

    }

    @Override
    public void makeNoise() {

        if(type == "Goldfish"){
            //type is protected, no getter needed
            System.out.print("swish ");
        } else {
            System.out.print("splash ");
        }

    }
}
