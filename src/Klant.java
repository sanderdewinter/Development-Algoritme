import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Klant {

    int klantID;
    String achternaam, tussenvoegsel, voornaam;
    int leeftijd;
    char geslacht;
    String plaats, emailAdres;
    Klant leftChild;
    Klant rightChild;


    static List<Klant> klanten = new ArrayList<Klant>();

    public int getKlantId(){ return klantID; }

    private static BinaryTree getKlantenTree = new BinaryTree();

    public static BinaryTree klantenTree() {
        return getKlantenTree;
    }

    public Klant(String achternaam, String tussenvoegsel, String voornaam, int leeftijd, char geslacht, String plaats, String emailAdres) {
        this.klantID = klanten.size(); //klantenTree.maxId()+1;
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.emailAdres = emailAdres;

        klanten.add(this);
        //klantenTree.addNode(this.klantID, this);

        bestel(this.klantID);

        // Doing insertion sort
        //if (klanten.size() > 2)
            klanten = MergeSort.startSort(klanten, false);
    }

    //Zet de klanten uit de array in de binary tree
    public Klant(Klant klant){
        this.klantID = klantenTree().maxId()+1;
        this.achternaam = klant.achternaam;
        this.tussenvoegsel = klant.tussenvoegsel;
        this.voornaam = klant.voornaam;
        this.leeftijd = klant.leeftijd;
        this.geslacht = klant.geslacht;
        this.plaats = klant.plaats;
        this.emailAdres = klant.emailAdres;

        klantenTree().addNode(this.klantID, this);
    }

    public void bestel(int klantID){
        new Bestelling(klantID);
    }
}