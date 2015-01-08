import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rik on 11/30/14.
 */
public class Klant {
    int klantID;
    String achternaam;
    String tussenvoegsel;
    String voornaam;
    int leeftijd;
    char geslacht;
    String plaats;
    String email;

    static List<Klant> klantenArray = new ArrayList<Klant>();

    public Klant(String achternaam, String tussenvoegsel, String voornaam, int leeftijd, char geslacht, String plaats, String email) {
        this.klantID = klantenArray.size();
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.email = email;
        klantenArray.add(this);
        bestel(this.klantID);
    }

    public void bestel(int klantID){
        Date date = new Date();
        new Bestelling(klantID,  true, new Time(60000), new Date(date.getTime()) , true, true);
    }



}
