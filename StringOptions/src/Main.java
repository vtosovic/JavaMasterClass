public class Main {
    public static void main(String[] args) {

        String helloWorld = "Hello" + " World";
        helloWorld.concat(" and Goodbye");

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");

        printInformation(helloWorld);
        printInformation(helloWorldBuilder);

        //empty starts with 16 characters
        StringBuilder emptyStart = new StringBuilder();
        //this will require larger capacity, new will be 34
        emptyStart.append("a".repeat(17));
        //gets 32
        StringBuilder emptyStart32 = new StringBuilder(32);
        //no new allocation needed, it will be again 32
        emptyStart32.append("a".repeat(17));
        printInformation(emptyStart);
        printInformation(emptyStart32);

        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and Goodbye");

        // this will replace G with g
        builderPlus.deleteCharAt(16).insert(16, 'g');
        System.out.println(builderPlus);

        // this will replace G with g, different method
        builderPlus.replace(16, 17, "G");
        System.out.println(builderPlus);

        // reverse and truncate to 7 chars
        builderPlus.reverse().setLength(7);
        System.out.println(builderPlus);

    }

    public static void printInformation(String string){
        System.out.println("String = " + string);
        System.out.println("length = " + string.length());
    }

    public static void printInformation(StringBuilder builder){
        System.out.println("String = " + builder);
        System.out.println("length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());
    }
}
