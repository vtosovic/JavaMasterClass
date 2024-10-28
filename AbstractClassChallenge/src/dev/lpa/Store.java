package dev.lpa;

import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product) {}

public class Store {
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {

        storeProducts.add(new ArtObject("Oil Painting", 1350,
                "Impressionistic work by ABF painted in 2010"));

        storeProducts.add(new ArtObject("Sculpture", 2000,
                "Bronze work by JKF, produced in 1950"));

        //------------------------------
        //This Oil Painting is a beautiful reproduction
        //This price of the piece is $1350.00
        //Impressionistic work by ABF painted in 2010
        //------------------------------
        //This Sculpture is a beautiful reproduction
        //This price of the piece is $2000.00
        //Bronze work by JKF, produced in 1950

        storeProducts.add(new Furniture("Desk", 500,
                "Mahogany Desk"));

        storeProducts.add(new Furniture("Lamp", 200,
                "Tiffany Lamp with Hummingbirds"));

        //------------------------------
        //This Desk was manufactured in North Carolina
        //This price of the piece is $500.00
        //Mahogany Desk
        //------------------------------
        //This Lamp was manufactured in North Carolina
        //This price of the piece is $200.00
        //Tiffany Lamp with Hummingbirds

        listProducts();


        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);
        //Order 1
        // 2 qty $ 2000.00 each, Sculpture       Bronze work by JKF, produced in 1950
        // 1 qty $ 1350.00 each, Oil Painting    Impressionistic work by ABF painted in 2010
        //Sales Total = $5350.00

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
        //Order 2
        // 5 qty $  200.00 each, Lamp            Tiffany Lamp with Hummingbirds
        // 1 qty $ 1350.00 each, Oil Painting    Impressionistic work by ABF painted in 2010
        // 1 qty $  500.00 each, Desk            Mahogany Desk
        //Sales Total = $2850.00
    }

    public static void listProducts(){
        for (var item : storeProducts){
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex,
                                      int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for (var item : order){
            item.product().printPricedItem(item.qty());
            salesTotal +=item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }
}
