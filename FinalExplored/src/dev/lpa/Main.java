package dev.lpa;

import consumer.specific.ChildClass;
import dev.lpa.generic.BaseClass;
import external.util.Logger;

public class Main {

    public static void main(String[] args) {

        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("--------------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("--------------------");
        child.recommendedMethod();
        //[BaseClass.recommendedMethod]: Best Way to Do it
        //[BaseClass.optionalMethod]: Customize Optional Method
        //[BaseClass.mandatoryMethod]: NON-NEGOTIABLE!
        //--------------------
        //[BaseClass.recommendedMethod]: Best Way to Do it
        //[Child:optionalMethod] EXTRA Stuff Here
        //[BaseClass.optionalMethod]: Customize Optional Method
        //[BaseClass.mandatoryMethod]: NON-NEGOTIABLE!
        //--------------------
        //[BaseClass.recommendedMethod]: Best Way to Do it
        //[Child:optionalMethod] EXTRA Stuff Here
        //[BaseClass.optionalMethod]: Customize Optional Method
        //[BaseClass.mandatoryMethod]: NON-NEGOTIABLE!

//        System.out.println("--------------------");
//        parent.recommendedStatic();
//        System.out.println("--------------------");
//        childReferredToAsBase.recommendedStatic();
//        System.out.println("--------------------");
//        child.recommendedStatic();

        System.out.println("--------------------");
        parent.recommendedStatic();
        System.out.println("--------------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("--------------------");
        child.recommendedStatic();

        //[BaseClass.recommendedStatic] BEST Way to Do it
        //[BaseClass.optionalStatic]: Optional
        //[BaseClass.mandatoryStatic]: MANDATORY
        //--------------------
        //[BaseClass.recommendedStatic] BEST Way to Do it
        //[BaseClass.optionalStatic]: Optional
        //[BaseClass.mandatoryStatic]: MANDATORY
        //--------------------
        //[BaseClass.recommendedStatic] BEST Way to Do it
        //[BaseClass.optionalStatic]: Optional
        //[BaseClass.mandatoryStatic]: MANDATORY

        System.out.println("--------------------");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();
        //[BaseClass.recommendedStatic] BEST Way to Do it
        //[BaseClass.optionalStatic]: Optional
        //[BaseClass.mandatoryStatic]: MANDATORY
        //[Child.recommendedStatic] BEST Way to Do it
        //[BaseClass.optionalStatic]: Optional
        String xArgument = "This is all I've got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only saying this: Section ");
        doXYZ(xArgument, 16, zArgument);
        //c = This is all I've got to say about Section 16

        System.out.println("After Method, xArgument: " + xArgument);
        System.out.println("After Method, zArgument: " + zArgument);


        //After Method, xArgument: This is all I've got to say about Section
        //After Method, zArgument: Only saying this: Section 16

        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz.");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " + tracker);
        // log to console clears, needs toString
        //10/21/24 08:39:14 : Step 1 is abc
        //10/21/24 08:39:14 : Step 1 is abc, Step 2 is xyz.
        //After logging, tracker = Step 1 is abc, Step 2 is xyz.

    }
    private static void doXYZ(String x, int y, final StringBuilder z) {

        final String c = x + y;
        System.out.println("c = " + c);
        x = c;
        z.append(y);
       // z = new StringBuilder("This is a new reference");
    }

}
