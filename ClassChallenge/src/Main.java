public class Main {

    public static void main(String[] args) {

        BankAccount bobsAccount = new BankAccount();
//        BankAccount bobsAccount = new BankAccount("12345",500.00,"Bob Brown","myemail.@bob.com", "(087)123-4567");
//        bobsAccount.setNumber("12345");
//        bobsAccount.setBalance(1000.00);
//        bobsAccount.setCustomerName("Bob Brown");
//        bobsAccount.setCustomerEMail("myemail@bob.com");
//        bobsAccount.setNumber("(087) 123-4567");
        System.out.println(bobsAccount.getNumber());
        System.out.println(bobsAccount.getBalance());
        bobsAccount.withdrawFund(100.0);
        bobsAccount.depositFunds(250);
        bobsAccount.withdrawFund(50.0);
        bobsAccount.withdrawFund(200.0);
        bobsAccount.depositFunds(100);
        bobsAccount.withdrawFund(45.55);
        bobsAccount.withdrawFund(54.46);
        bobsAccount.withdrawFund(54.45);

        BankAccount timsAccount = new BankAccount("Tim", "tim@email.com", "12345");
        System.out.println("AccountNo: " + timsAccount.getNumber() +
                "; name " + timsAccount.getCustomerName());
    }
}
