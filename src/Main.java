import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        scenarioOne();
        System.out.println(" ");
        scenarioTwo();
        System.out.println(" ");
        scenarioThree();
    }

    //Scenario 1
    private static void scenarioOne() {
        System.out.println("---------Scenario 1---------");
        new Main().insertCustomer();
        System.out.println("Totaal aantal bestellingen in de queue: " + Bestelling.wachtRij.size());
        Bestelling.update();
    }

    //Scenario 2
    private static void scenarioTwo() {
        System.out.println("---------Scenario 2---------");
        System.out.println("Mergesort:");
        Klant.klanten = MergeSort.startSort(Klant.klanten, true);
        for (Klant k : Klant.klanten) {
            System.out.println(k.achternaam);
        }
        System.out.println(" ------------------------------ ");
        Klant.klanten = MergeSort.startSort(Klant.klanten, false);
        for (Klant k : Klant.klanten) {
            System.out.println(k.achternaam);
        }
        System.out.println(" ");

        System.out.println("Insertion sort: add Davey Winzer, than use insertion sort");
        new Klant("Winzer", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl", false);
        for (Klant k : Klant.klanten) {
            System.out.println(k.achternaam);
        }
        System.out.println(" ");

        int leeftijd = 18;
        System.out.println(" ");
        System.out.println("--LinearSearch leeftijd:--");
        System.out.println(LinearSearch.linearSearch(leeftijd).voornaam);
        System.out.println("--LinearSearch achternaam:--");
        System.out.println(LinearSearch.linearSearch("Costantini").voornaam);
        System.out.println(" ");


        System.out.println("--BinarySearch:--");
        System.out.println("Zoek klant: de Winter");
        Klant BinaryKlant = BinarySearch.binarySearch("Winter", 0, Klant.klanten.size()).get(0);
        System.out.println(BinaryKlant.achternaam);
    }

    // Scenario 3
    private static void scenarioThree() {
        System.out.println("---------Scenario 3---------");
        for (int i = 0 ; i < Klant.klanten.size(); i++){
            new Klant(Klant.klanten.get(i));
        }
        System.out.println(" ");
        System.out.println("Search");
        Klant zoekKlant = Klant.klantenTree().search(1);
        if(zoekKlant != null){
            System.out.println(zoekKlant.voornaam + " " + zoekKlant.achternaam);
        } else {
            System.out.println("Deze klant bestaat niet!");
        }
        System.out.println(" ");

        System.out.println("The tree before deletion");
        System.out.println(Klant.klantenTree().getRoot().getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.rightChild.getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.rightChild.rightChild.getKlantId());
        Klant.klantenTree().removeNode(Klant.klantenTree().search(2));
        System.out.println("The tree after deletion");
        System.out.println(Klant.klantenTree().getRoot().getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.getKlantId());
        System.out.println(Klant.klantenTree().getRoot().rightChild.rightChild.getKlantId());
        System.out.println(" ");

        System.out.println("Traversal: ");
        //System.out.println(Klant.klantenTree().compare(Klant.klantenTree().findNode(3), Klant.klantenTree().findNode(4)));
        //System.out.println(Klant.klantenTree().compare(Klant.klantenTree().findNode(4), Klant.klantenTree().findNode(3)));
    }

    private void insertCustomer() {
        new Klant("Akker", "de", "Sander", 318, 'M', "Sliedrecht", "0877902@hr.nl", true);
        new Klant("Winter", "de", "Sander", 18, 'M', "Sliedrecht", "0877902@hr.nl", true);
        new Klant("Costantini", "", "Giulia", 28, 'V', "Rotterdam", "COSTG@hr.nl", true);
        new Klant("Witter", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl", true);
    }
}