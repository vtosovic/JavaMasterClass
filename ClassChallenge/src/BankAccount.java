public class BankAccount {

    private String number;
    private double balance;
    private String customerName;
    private String customerEMail;
    private String phoneNumber;

    public BankAccount() {
        this("56789", 2.5, "Default Name", "Default Address", "Default Phone");
        System.out.println("Empty constructor called.");
    }

    public BankAccount(String number, double balance, String customerName, String customerEMail, String phoneNumber) {
        System.out.println("Account constructor with parameters called");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEMail = customerEMail;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String customerEMail, String phoneNumber) {
        this("99999", 1000.55, customerName, customerEMail, phoneNumber);
        this.customerName = customerName;
        this.customerEMail = customerEMail;
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double depositAmount){
        balance += depositAmount;
        System.out.println("Deposit of $" + depositAmount + " made. New balance is &" + this.balance);
    }
    public void withdrawFund(double withdrawalAmount){
        if (balance - withdrawalAmount < 0) {
            System.out.println("Insufficient Funds! You only have $" + balance + " in your account");
        } else {
            balance -= withdrawalAmount;
            System.out.println("Withdrawal of  $" + withdrawalAmount + " processed. Remaining balance = $" + balance);
        }
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEMail() {
        return customerEMail;
    }

    public void setCustomerEMail(String customerEMail) {
        this.customerEMail = customerEMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
