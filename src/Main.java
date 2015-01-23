public class Main {

    public static void main(String[] args) {
        System.out.println("Scenario 1");

        // Make customers, they will automatisch make Bestellingen and added to WachtRij
        new Main().insertCustomer();
        System.out.println("Totaal aantal bestellingen in de queue: " + Bestelling.wachtRij.size());

        // Bestellingen will be 'verwerkt' (updated)
        Bestelling.update();

        System.out.println(" ");
        System.out.println("Scenario 2");

        Klant.klanten = MergeSort.startSort(Klant.klanten, true);

        // Klant from linear search --> The first klant wich has this age
        int leeftijd = 18;
        System.out.println(LinearSearch.linearSearch(leeftijd));

        // Insertion sort
        new Klant("Winzer", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl");
        for (Klant k : Klant.klanten) {
            System.out.println(k.achternaam);
        }

        // Binary search
        System.out.println("Zoek klant: de Winter");
        System.out.println(BinarySearch.binarySearch("Winter", 0, Klant.klanten.size()));

        System.out.println(" ");
        System.out.println("Scenario 3");
        for (int i = 0 ; i < Klant.klanten.size(); i++){
            new Klant(Klant.klanten.get(i));
        }
        System.out.println(Klant.klantenTree().findNode(2).achternaam);
        System.out.println("The tree before deletion");
        System.out.println(Klant.klantenTree().getRoot().getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.rightChild.getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.rightChild.rightChild.getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.rightChild.rightChild.rightChild.getKlantId());
        Klant.klantenTree().removeNode(Klant.klantenTree().findNode(2));
        System.out.println("The tree after deletion");
        System.out.println(Klant.klantenTree().getRoot().getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.rightChild.getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.rightChild.rightChild.getKlantId());

        System.out.println(" ");
        System.out.println("Compare if the key 3 is more than 5, should give back -1 ");
        System.out.println(Klant.klantenTree().compare(Klant.klantenTree().findNode(3), Klant.klantenTree().findNode(5)));
        System.out.println("Compare if the key 5 is more than 3, schould give back 1 ");
        System.out.println(Klant.klantenTree().compare(Klant.klantenTree().findNode(5), Klant.klantenTree().findNode(3)));


    }

    private void insertCustomer() {
        new Klant("Akker", "de", "Sander", 318, 'M', "Sliedrecht", "0877902@hr.nl");
        new Klant("Winter", "de", "Sander", 18, 'M', "Sliedrecht", "0877902@hr.nl");
        new Klant("Costantini", "", "Giulia", 28, 'V', "Rotterdam", "COSTG@hr.nl");
        new Klant("Winter", "de", "Piet", 8, 'M', "Sliedrecht", "0877902@hr.nl2");
        new Klant("Witter", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl");
    }
}