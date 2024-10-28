public class Main {
    public static void main(String[] args) {
        System.out.println(sumDigits(1234));
        System.out.println(sumDigits(1000));
        System.out.println(sumDigits(8));
    }
    public static int sumDigits(int number){
        if (number < 0) {
            return -1;
        }
        int tempNum = 0;
        int sum = 0;
        while (number > 0){
            tempNum = number%10;
            sum += tempNum;
            number = (number - tempNum)/10;
        }
        return sum;
    }
}
