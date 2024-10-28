package dev.lpa.model;

public class LPAStudent extends Student{

    private double percentComplete;

    public LPAStudent() {
    // 0-100%, needs to be 100.001
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        // to print %, %% is needed
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
