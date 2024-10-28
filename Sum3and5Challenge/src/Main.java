public class Main {

    public static void main(String[] args) {

        int sum = 0;
        int counter = 0;

        for (int i = 1; i < 1001; i++) {
            if(i%15==0){
                sum+=i;
                System.out.println("Number " + i);
                counter++;
                if(counter ==5){
                    System.out.println("sum is " + sum);
                    break;
                }
            }
        }
    }
}
