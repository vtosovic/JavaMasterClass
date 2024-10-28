package dev.lpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com",
                "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        // UNION
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A ∪ B) Union of emails (A) with phones (B)", unionAB);
        //(A ∪ B) Union of emails (A) with phones (B)
        //------------------------------------------------
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Lucy Van Pelt: [] [(564) 208-6852]
        //Charlie Brown: [] [(333) 444-5555]
        //Maid Marion: [] [(123) 456-7890]
        //Robin Hood: [RHood@sherwoodforest.org, rhood@gmail.com] []
        //Mickey Mouse: [mckmouse@gmail.com] []
        //Daffy Duck: [daffy@google.com] []
        //Minnie Mouse: [minnie@verizon.net] []

        // INTERSECT
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A ∩ B) Intersect emails (A) with phones (B)", intersectAB);
        //(A ∩ B) Intersect emails (A) with phones (B)
        //------------------------------------------------
        //Robin Hood: [RHood@sherwoodforest.org, rhood@gmail.com] []
        //Mickey Mouse: [mckmouse@gmail.com] []
        //Minnie Mouse: [minnie@verizon.net] []

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B ∩ A) Intersect emails (A) with phones (B)", intersectBA);
        //(B ∩ A) Intersect emails (A) with phones (B)
        //------------------------------------------------
        //Robin Hood: [] [(564) 789-3000]
        //Mickey Mouse: [] [(999) 888-7777]
        //Minnie Mouse: [] [(456) 780-5666]


        // Difference
        Set<Contact> AminusB = new HashSet<>(emailContacts);
        AminusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)", AminusB);
        //(A - B) emails (A) - phones (B)
        //------------------------------------------------
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Daffy Duck: [daffy@google.com] []

        Set<Contact> BminusA = new HashSet<>(phoneContacts);
        BminusA.removeAll(emailContacts);
        printData("(B - A) phones (B) - emails (A)", BminusA);
        //(B - A) phones (B) - emails (A)
        //------------------------------------------------
        //Lucy Van Pelt: [] [(564) 208-6852]
        //Charlie Brown: [] [(333) 444-5555]
        //Maid Marion: [] [(123) 456-7890]

        //Union of Differences
        // version 1
        Set<Contact> symmetricDiff = new HashSet<>(AminusB);
        symmetricDiff.addAll(BminusA);
        printData("Symmetric Diff", symmetricDiff);
        //Symmetric Diff
        //------------------------------------------------
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Lucy Van Pelt: [] [(564) 208-6852]
        //Charlie Brown: [] [(333) 444-5555]
        //Maid Marion: [] [(123) 456-7890]
        //Daffy Duck: [daffy@google.com] []

        //version 2
        // Union - diff
        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric Diff", symmetricDiff2);
        //Symmetric Diff
        //------------------------------------------------
        //Linus Van Pelt: [lvpelt2015@gmail.com] []
        //Lucy Van Pelt: [] [(564) 208-6852]
        //Charlie Brown: [] [(333) 444-5555]
        //Maid Marion: [] [(123) 456-7890]
        //Daffy Duck: [daffy@google.com] []



    }

    public static void printData(String header, Collection<Contact> contacts){

        System.out.println("------------------------------------------------");
        System.out.println(header);
        System.out.println("------------------------------------------------");
        contacts.forEach(System.out::println);
    }
}

