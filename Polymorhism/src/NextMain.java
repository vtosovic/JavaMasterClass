public class NextMain {
    public static void main(String[] args) {

        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        // following will not work, as compiler needs to run the code to see what
        // type of movie it needs, and it will not
        //Adventure jaws = Movie.getMovie("A", "Jaws");

        // casting will help:
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();

        // this will create exception:
        //Adventure jaws = (Adventure) Movie.getMovie("C", "Jaws");
        //jaws.watchMovie();
        // Exception in thread "main" java.lang.ClassCastException:
        // class Comedy cannot be cast to class Adventure (Comedy and Adventure
        // are in unnamed module of loader 'app')
        // at NextMain.main(NextMain.java:12)

        // this will not compile
        // using generic Object
//        Object comedy = Movie.getMovie("C", "Airplane");
//        comedy.watchMovie();
        // compiler cannot add getMovie to Object class

        // we need casting
        Object comedy = Movie.getMovie("C", "Airplane");
        // this will also not work, we need specific type
        // Movie comedyMovie = (Movie) comedy;
        // comedyMovie.watchComedy();

        // more specific works:
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchComedy();

        // this also compiles, and it works
        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        // this also works
        var plane = new Comedy("Airplane");
        plane.watchComedy();


        // test 1 of runtime type
        Object unknownObject =  Movie.getMovie("S", "Star Wars");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        // test 2 of runtime type
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        // test 3 of runtime type
        } else if (unknownObject instanceof  ScienceFiction syfy){
            syfy.watchScienceFiction();
        }



    }
}
