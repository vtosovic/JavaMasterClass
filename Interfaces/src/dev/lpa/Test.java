package dev.lpa;

public class Test {
    public static void main(String[] args) {

        inFlight(new Jet());
        //Jet is taking off
        //transition not implemented on dev.lpa.Jet
        //Jet is flying
        //Jet's coordinates recorded
        //Jet is landing

        // if the method is public, this works.
        // OrbitEarth.log("Testing " + new Satellite());
        //Tue Sep 03 10:59:47 CEST 2024: Testing dev.lpa.Satellite@16b98e56

        orbit(new Satellite());

    }
    public static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if (flier instanceof Trackable tracked) { // can test interface also
            tracked.track();
        }
        flier.land();
    }

    public static void orbit(OrbitEarth flier){
        flier.takeOff();
        flier.fly();
        flier.land();
    }
}


