package dev.lpa;

public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int qty){
        return qty * price;
    }

    public void printPricedItem(int qty){
        //%2d - two digits right justified
        //%8.2 - a decimal number printed as float with two decimal places
        //%-15s - prints a string, 15 spaces, left justified
        //%-35s - prints a string, 35 spaces, left justified
        System.out.printf("%2d qty $%8.2f each, %-15s %-35s %n",
                qty, price, type, description);
    }

    public abstract void showDetails();
}
