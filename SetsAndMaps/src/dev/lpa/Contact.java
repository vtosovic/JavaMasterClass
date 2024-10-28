package dev.lpa;

import java.util.HashSet;
import java.util.Set;

public class Contact {

    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }
    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone){
        this.name =  name;
        if (email != null){
            emails.add(email);
        }

        if (phone > 0) {
            String p = String.valueOf(phone);
            p = "(%s) %s-%s".formatted(p.substring(0,3), p.substring(3,6),
                    p.substring(6));
            phones.add(p);
        }
    }

    public String getName() {
        return name;
    }

    public String getNameLastFirst(){
        return name.substring(name.indexOf(" ") + 1) + ", " +
                name.substring(0, name.indexOf(" "));
    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    public Contact mergeContactData(Contact contact){
        Contact newContact = new Contact(name);
        // just cloning the data
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        //merge
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);
        return newContact;
    }


    // generated from IntelliJ

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;
        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        // adding multiplier 33 (or 31) to have different classes for different hashcodes
        //The multiplication by 33 in the hashCode() method is used to produce a more even
        // distribution of hash codes, the choice of 33 is somewhat random, but it is a prime number
        // and is known to work well in practice.
        // The specific value isn't as important as the fact that it is a prime number,
        // as this helps to reduce the likelihood of collisions (two different
        // objects producing the same hash code). In general, the multiplication
        // in a hashCode() function is meant to mix the bits of the various fields of the
        // object so that small changes in the input (i.e., the object's state)
        // produce significantly different hash codes, this helps improve the performance
        // of hash-based data structures like HashSet or HashMap.
        //
        //In the example, the hashCode() method was automatically generated
        // by IntelliJ IDEA based on the fields of the Contact class,
        // the tool used a default multiplier (in this case, 33) and
        // applied it to the hash codes of the fields. Remember,
        // while the specific choice of multiplier can influence performance,
        // the important thing is to ensure that the hashCode() method generates
        // a reasonably unique code for each distinct object.
        return 33 * getName().hashCode();
    }

    public void addEmail(String companyName) {

        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length - 1],
                companyName.replaceAll(" ", "").toLowerCase());
        if (!emails.add(email)) {
            System.out.println(name + " already has email " + email);
        } else {
            System.out.println(name + " now has email " + email);
        }
    }

    public void replaceEmailIfExists(String oldEmail, String newEmail) {

        if (emails.contains(oldEmail)) {
            emails.remove(oldEmail);
            emails.add(newEmail);
        }
    }
}
