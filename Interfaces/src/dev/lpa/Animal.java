package dev.lpa;

// enum can implement Interface
enum FlightStages implements Trackable {GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }

    // this will keep all enum values even if they change
    public FlightStages getNextStage(){
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

// record can implement interface
record DragonFly(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

// class can implement interface
class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    public void achieveOrbit(){
        transition("Orbit achieved!");
    }

    @Override
    public void takeOff() {
        transition("Taking Off");

    }

    @Override
    public void land() {
        transition("Landing");

    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collecting while Orbiting");

    }

    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }

}

interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();
    // adding public is redundant
    // it can be private since JDK9
    private static void log(String description){
        // using fully qualified name
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description){
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage =  FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}
interface FlightEnabled{

    // these are implicitly public, static, final - CONSTANTS
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();
    void land();
    void fly();

    // changing one instance in an interface makes everything uncompilable
    // now everything needs to change
    // FlightStages transition(FlightStages stage);

    // to do that:
    default FlightStages transition(FlightStages stage) {
//        System.out.println("transition not implemented on "
//                + getClass().getName());
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to "
        + nextStage);
        return nextStage;
    }
    //Transitioning from GROUNDED to LAUNCH
    //Tue Sep 03 12:00:13 CEST 2024: GROUNDED: Beginning Transition to LAUNCH
    //Monitoring LAUNCH
    //Orbit achieved!
    //Transitioning from LAUNCH to CRUISE
    //Tue Sep 03 12:00:13 CEST 2024: LAUNCH: Beginning Transition to CRUISE
    //Monitoring CRUISE
    //Data Collecting while Orbiting
    //Transitioning from CRUISE to DATA_COLLECTION
    //Tue Sep 03 12:00:13 CEST 2024: CRUISE: Beginning Transition to DATA_COLLECTION
    //Monitoring DATA_COLLECTION
    //Landing
    //Transitioning from DATA_COLLECTION to GROUNDED
    //Tue Sep 03 12:00:13 CEST 2024: DATA_COLLECTION: Beginning Transition to GROUNDED
}
interface Trackable {

    void track();
}

public abstract class Animal {

    public abstract void move();
}
