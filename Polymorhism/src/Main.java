// imported by auto-import
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Movie theMovie = Movie.getMovie("Science", "Star Wars");
//        theMovie.watchMovie();

        Scanner s = new Scanner(System.in);
        while (true){
            System.out.print("Enter Type (A for Adventure, C for Comedy, " +
                    "S for SF, or Q for quit): ");
            String type = s.nextLine();
            //uses contains method to see if it contains Q or q
            if ("Qq".contains(type)){
                break;
            }
            System.out.print("Enter Movie Title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
