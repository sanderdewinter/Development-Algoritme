public class Main {

    public static void main(String[] args) {
        scenario1();

        System.out.println(" ");

        scenario2();

        System.out.println(" ");

        scenario3();
    }

    private void insertCustomer() {
        new Klant("Akker", "de", "Sander", 318, 'M', "Sliedrecht", "0877902@hr.nl");
        new Klant("Winter", "de", "Sander", 18, 'M', "Sliedrecht", "0877902@hr.nl");
        new Klant("Costantini", "", "Giulia", 28, 'V', "Rotterdam", "COSTG@hr.nl");
        new Klant("Winter", "de", "Piet", 8, 'M', "Sliedrecht", "0877902@hr.nl2");
        new Klant("Witter", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl");
    }

    private static void scenario1() {
        System.out.println("Scenario 1");

        // Make customers, they will automatisch make Bestellingen and added to WachtRij
        new Main().insertCustomer();
        System.out.println("Totaal aantal bestellingen in de queue: " + Bestelling.wachtRij.size());

        // Bestellingen will be 'verwerkt' (updated)
        Bestelling.update();
    }

    private static void scenario2() {
        System.out.println("Scenario 2");

        Klant.klanten = MergeSort.startSort(Klant.klanten);

        // Klant from linear search --> The first klant wich has this age
        int leeftijd = 18;
        System.out.println(LinearSearch.linearSearch(leeftijd));

        // Insertion sort with improved version
        new Klant("Winzer", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl");
        for (Klant k : Klant.klanten) {
            System.out.println(k.achternaam);
        }

        // Binary search
        System.out.println("Zoek klant: de Winter");
        System.out.println(BinarySearch.binarySearch("Winter", 0, Klant.klanten.size()));
    }

    private static void scenario3() {
        System.out.println("Scenario 3");

        // Binary tree
        for (int i = 0 ; i < Klant.klanten.size(); i++){
            // Add klanten to Tree
            new Klant(Klant.klanten.get(i));
        }

        Klant klant = Klant.klantenTree.findNode(3);
        System.out.println(klant.achternaam);


        // Deleteing klant from tree with ID 3
        System.out.println(" ");

        // Tree before sorted on Klant ID
        System.out.println(Klant.klantenTree.getRoot().getKlantId());
        System.out.println(Klant.klantenTree.getRoot().rightChild.getKlantId());
        System.out.println(Klant.klantenTree.getRoot().rightChild.rightChild.getKlantId());
        System.out.println(Klant.klantenTree.getRoot().rightChild.rightChild.rightChild.getKlantId());
        System.out.println(Klant.klantenTree.getRoot().rightChild.rightChild.rightChild.rightChild.getKlantId());

        // Deleting node here
        Klant.klantenTree.removeKlant(Klant.klantenTree.findNode(3));

        System.out.println("Result after deleting one node");
        System.out.println(Klant.klantenTree.getRoot().getKlantId());
        System.out.println(Klant.klantenTree.getRoot().rightChild.getKlantId());
        System.out.println(Klant.klantenTree.getRoot().rightChild.rightChild.getKlantId());
        System.out.println(Klant.klantenTree.getRoot().rightChild.rightChild.rightChild.getKlantId());

        // Use the comparator
        System.out.println(Klant.klantenTree.compare(4, Klant.klantenTree.findNode(1)));
        System.out.println(Klant.klantenTree.compare(3, Klant.klantenTree.findNode(5)));
    }
}