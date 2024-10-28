public class Main {
    public static void main(String[] args) {
        int i = 4;
        int j = 20;
        int counter = 0;
        int oddCount = 0;
        while (i <= j){
            i++;
            if (!isEvenNumber(i)){
                oddCount++;
                continue;
            }
            counter++;
            System.out.println("Even number " + i);
            if (counter >= 5){
                break;
            }
        }
        System.out.println("Even numbers " + counter);
        System.out.println("Odd numbers " + oddCount);
    }
    public static boolean isEvenNumber(int number){
        if (number%2==0){
            return true;
        } else {return false;}
    }
}
