package dev.lpa;


import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count){
    public GroceryItem(String name) {
        this(name, "DIARY", 1);
    }
    @Override
    public String toString(){
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class Main {
    public static void main(String[] args) {

        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("oranges", "PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));
        // output:
        // [1 MILK in DIARY, 6 APPLES in PRODUCE, 5 ORANGES in PRODUCE]

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        // basic creating list using <>
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        // adds Butter at the position 0
        groceryList.add(new GroceryItem("Butter"));
        // adds milk at 1
        groceryList.add(new GroceryItem("milk"));
        // adds orange, as Produce, at 2
        groceryList.add(new GroceryItem("oranges", "PRODUCE", 5));
        // replaces position 0 with apples, of Produce
        groceryList.set(0,
                new GroceryItem("apples", "PRODUCE", 6));
        // removes butter on position 1
        groceryList.remove(1);
        System.out.println(groceryList);
        // output:
        // [6 APPLES in PRODUCE, 5 ORANGES in PRODUCE]

    }
}
