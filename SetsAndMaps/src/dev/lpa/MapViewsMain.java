package dev.lpa;

import java.util.*;

public class MapViewsMain {

    public static void main(String[] args) {

        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        // get keys
        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);
        //[Lucy Van Pelt, Linus Van Pelt, Minnie Mouse, Maid Marion, Charlie Brown, Robin Hood, Daffy Duck, Mickey Mouse]

        // get copy of keys, they will be in alphabetical order
        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);
        //[Charlie Brown, Daffy Duck, Linus Van Pelt, Lucy Van Pelt, Maid Marion, Mickey Mouse, Minnie Mouse, Robin Hood]

        // search by keys
        if (contacts.containsKey("Linus Van Pelt")) {
            System.out.println("Linus and I go way back, so of course I have info");
        }

        // remove by keys
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));
        //[Lucy Van Pelt, Linus Van Pelt, Minnie Mouse, Maid Marion, Charlie Brown, Robin Hood, Mickey Mouse]
        //Lucy Van Pelt: [] [(564) 208-6852]
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Minnie Mouse: [minnie@verizon.net] []
        //Maid Marion: [] [(123) 456-7890]
        //Charlie Brown: [] [(333) 444-5555]
        //Robin Hood: [rhood@gmail.com] []
        //Mickey Mouse: [micky1@aws.com] []

        //  remove in copy
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k, v) -> System.out.println(v));
        //[Charlie Brown, Daffy Duck, Lucy Van Pelt, Maid Marion, Mickey Mouse, Minnie Mouse, Robin Hood]
        // Linus is still in the original:
        //Lucy Van Pelt: [] [(564) 208-6852]
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Minnie Mouse: [minnie@verizon.net] []
        //Maid Marion: [] [(123) 456-7890]
        //Charlie Brown: [] [(333) 444-5555]
        //Robin Hood: [rhood@gmail.com] []
        //Mickey Mouse: [micky1@aws.com] []

        // remove all but some:
        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown",
                "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));
        //[Linus Van Pelt, Charlie Brown, Robin Hood, Mickey Mouse]
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Charlie Brown: [] [(333) 444-5555]
        //Robin Hood: [rhood@gmail.com] []
        //Mickey Mouse: [micky1@aws.com] []

        keysView.clear();
        System.out.println(contacts);
        //{}

        // ERROR - UNSUPPORTED OPERATION EXCEPTION
        // we need a data, not only key
//        keysView.add("Daffy Duck");
//        System.out.println(contacts);

        ContactData.getData("email").forEach(c->contacts.put(c.getName(),c));
        ContactData.getData("phone").forEach(c->contacts.put(c.getName(),c));
        System.out.println(keysView);
        //[Linus Van Pelt, Lucy Van Pelt, Minnie Mouse, Maid Marion, Robin Hood, Daffy Duck, Charlie Brown, Mickey Mouse]

        var values = contacts.values();
        values.forEach(System.out::println);
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Lucy Van Pelt: [] [(564) 208-6852]
        //Minnie Mouse: [] [(456) 780-5666]
        //Maid Marion: [] [(123) 456-7890]
        //Robin Hood: [] [(789) 902-8222]
        //Daffy Duck: [daffy@google.com] []
        //Charlie Brown: [] [(333) 444-5555]
        //Mickey Mouse: [] [(999) 888-7777]

        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));
        //[Linus Van Pelt, Minnie Mouse, Robin Hood, Daffy Duck, Mickey Mouse]
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Minnie Mouse: [] [(456) 780-5666]
        //Robin Hood: [] [(789) 902-8222]
        //Daffy Duck: [daffy@google.com] []
        //Mickey Mouse: [] [(999) 888-7777]

        System.out.println("-------------");
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));
        //Duck, Daffy: Daffy Duck: [daffy@google.com] []
        //Hood, Robin: Robin Hood: [] [(789) 902-8222]
        //Mouse, Mickey: Mickey Mouse: [] [(999) 888-7777]
        //Mouse, Minnie: Minnie Mouse: [] [(456) 780-5666]
        //Van Pelt, Linus: Linus Van Pelt: [lvpelt2015@gmail.com] []

        // adding a duplicate contact
        System.out.println("-------------");
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);
        //Linus Van Pelt
        //Duck, Daffy
        //Minnie Mouse
        //Robin Hood
        //Daffy Duck
        //Mickey Mouse

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if (set.size() < contacts.keySet().size()){
            System.out.println("Duplicate Values are in my Map");
        }

        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Robin Hood: [] [(789) 902-8222]
        //Mickey Mouse: [] [(999) 888-7777]
        //Daffy Duck: [daffy@google.com] []
        //Minnie Mouse: [] [(456) 780-5666]
        //Duplicate Values are in my Map


        // ENTRY SET
        var nodeSet = contacts.entrySet();
        for (var node : nodeSet){
            System.out.println(nodeSet.getClass().getName());
            if (!node.getKey().equals(node.getValue().getName())) {
                System.out.println(node.getClass().getName());
                System.out.println("Key doesn't match name: " + node.getKey() +
                        ": " + node.getValue());
            }
        }
        //java.util.HashMap$EntrySet
        //java.util.HashMap$EntrySet
        //java.util.HashMap$Node
        //Key doesn't match name: Duck, Daffy: Daffy Duck: [daffy@google.com] []
        //java.util.HashMap$EntrySet
        //java.util.HashMap$EntrySet
        //java.util.HashMap$EntrySet
        //java.util.HashMap$EntrySet
    }
}
