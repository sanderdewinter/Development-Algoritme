import java.util.ArrayList;
import java.util.List;

public class Klant {

    int klantID;
    String achternaam, tussenvoegsel, voornaam;
    int leeftijd;
    char geslacht;
    String plaats, emailAdres;
    Klant leftChild, rightChild;

    static List<Klant> klanten = new ArrayList<Klant>();

    public int getKlantId() {
        return klantID;
    }

    static BinaryTree klantenTree = new BinaryTree();

    public Klant(String achternaam, String tussenvoegsel, String voornaam, int leeftijd, char geslacht, String plaats, String emailAdres) {
        this.klantID = klanten.size();
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.emailAdres = emailAdres;

        klanten.add(this);

        bestel(this.klantID);

        // Doing insertion sort
        klanten = InsertionSort.startSort(klanten);
    }

    public Klant(Klant klant) {
        this.klantID = klantenTree.maxId() + 1;
        this.achternaam = klant.achternaam;
        this.tussenvoegsel = klant.tussenvoegsel;
        this.voornaam = klant.voornaam;
        this.leeftijd = klant.leeftijd;
        this.geslacht = klant.geslacht;
        this.plaats = klant.plaats;
        this.emailAdres = klant.emailAdres;

        // Add to binary tree
        klantenTree.addNode(this.klantID, this);
    }

    public void bestel(int klantID){
        new Bestelling(klantID);
    }
}
