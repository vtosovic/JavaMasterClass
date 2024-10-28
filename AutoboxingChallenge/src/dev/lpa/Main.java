package dev.lpa;

import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {
    public Customer(String name, double initialDeposit){
        this(name.toUpperCase(),
                new ArrayList<Double>(500));
        transactions.add(initialDeposit);
    }
}

public class Main {
    public static void main(String[] args) {

        Customer bob = new Customer("Bob S", 1000.0);
        System.out.println(bob);
        // Customer[name=BOB S, transactions=[1000.0]]

        Bank bank = new Bank("Chase");
        bank.addNewCustomer("Jane A", 500.0);
        System.out.println(bank);
        //Customer (Jane A) wasn't found
        //New Customer added: Customer[name=JANE A, transactions=[500.0]]
        //Bank{name='Chase', customers=[Customer[name=JANE A, transactions=[500.0]]]}

        bank.addTransaction("Jane A", -10.25);
        bank.addTransaction("Jane A", -75.01);
        bank.printStatement("Jane A");
        //------------------------------
        //Customer Name: JANE A
        //Transactions:
        //$    500.00 (credit)
        //$    -10.25 (debit)
        //$    -75.01 (debit)
        bank.addTransaction("Bob S", 1000.0);
        bank.printStatement("Bob S");
        //Customer (Bob S) wasn't found
        //Customer (Bob S) wasn't found

        bank.addNewCustomer("bob s", 25);
        bank.addTransaction("Bob S", 1000.0);
        bank.printStatement("Bob S");
        //New Customer added: Customer[name=BOB S, transactions=[25.0]]
        //------------------------------
        //Customer Name: BOB S
        //Transactions:
        //$     25.00 (credit)
        //$   1000.00 (credit)

    }
}

class Bank { // no public because it is in the same file
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    private Customer getCustomer(String customerName){
        for (var customer :customers){
            if (customer.name().equalsIgnoreCase(customerName)){
                return customer;
            }
        }
        System.out.printf("Customer (%s) wasn't found %n", customerName);
        return null;
    }

    public void addNewCustomer(String customerName, double initialDeposit){
        if (getCustomer(customerName) == null){
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New Customer added: " + customer);
        }
    }

    public void addTransaction(String name, double transactionAmount){

        Customer customer = getCustomer(name);
        if (customer!=null){
            customer.transactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName) {
        Customer customer = getCustomer(customerName);
        if (customer == null) {
            return;
        }
        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + customer.name());
        System.out.println("Transactions:");
        for (double d : customer.transactions()) { // unboxing
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }
}