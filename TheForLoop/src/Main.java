public class Main {
    public static void main(String[] args) {

//        for (int counter = 1; counter <= 5; counter++){
//            System.out.println(counter);
//        }
        for (double rate = 7.5; rate <= 10; rate+=0.25){
            double interestAmount = calculateInterest(100.0, rate);
            if (interestAmount > 8.5){
                break;
            }
            System.out.println("$100 at " + rate + "% interest = $" + interestAmount);
        }
    }

    public static double calculateInterest(double amount, double interestRate){

        return (amount * (interestRate / 100));
    }
}
