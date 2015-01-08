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

    public Klant(int klantID, String achternaam, String tussenvoegsel, String voornaam, int leeftijd, char geslacht, String plaats, String emailAdres) {
        this.klantID = klantID;
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.emailAdres = emailAdres;
    }
}
