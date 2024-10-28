public class Main {

    public static void main(String[] args) {

        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(65, 45));
    }
    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid";
        } else {

            return getDurationString(seconds / 60, seconds%60);
        }
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes <0 || seconds <0) {
            return "Invalid";
        } else {
            int hours = minutes / 60;
            int remainingSeconds = seconds%60;
            int remainingMinutes = minutes%60;
            return hours + "h " + remainingMinutes + "m " + remainingSeconds + "s";

        }

    }
}
