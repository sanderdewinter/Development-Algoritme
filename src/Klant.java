import java.util.ArrayList;
import java.util.List;

/**
 * Created by sander on 1/8/15.
 */
public class Klant {

    int klantID;
    String achternaam, tussenvoegsel, voornaam;
    int leeftijd;
    char geslacht;
    String plaats;
    String emailAdres;

    static List<Klant> klantenArray = new ArrayList<Klant>();

    public Klant(String achternaam, String tussenvoegsel, String voornaam, int leeftijd, char geslacht, String plaats, String emailAdres) {
        this.klantID = klantenArray.size();;
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.emailAdres = emailAdres;
    }
}
