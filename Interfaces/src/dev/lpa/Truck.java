package dev.lpa;

public class Truck implements Trackable {
    // Truck cannot fly, but can use this interface

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");

    }
}
