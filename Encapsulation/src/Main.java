public class Main {
    public static void main(String[] args) {

 //       Player player = new Player();
//        // instances are Public, we can set them without setter
//        // if field is changed in Player, then we need to change it here also
         // this will brake code
//        player.name = "Tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());
//        // this method can bypass setter in Player, and this is a problem
//        // It bypasses checks
//        player.health = 200;
//        player.loseHealth(11);
//        System.out.println("Remaining health = " + player.healthRemaining());

        // making health 200 will not pass the check and set it to 100
        EnhancedPlayer tim = new EnhancedPlayer("Tim", 200, "Sword");
        System.out.println("initial health is " + tim.healthRemaining());
    }
}
