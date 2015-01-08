import java.security.Timestamp;

/**
 * Created by sander on 1/8/15.
 */
public class Bestelling {

    int klantID, bestellingID;
    boolean verwerking;
    Timestamp startTijd;
    Timestamp duur;
    boolean compleet;
    boolean dadelijk;

    public Bestelling(int klantID, int bestellingID, boolean verwerking, Timestamp startTijd, Timestamp duur, boolean compleet, boolean dadelijk) {
        this.klantID = klantID;
        this.bestellingID = bestellingID;
        this.verwerking = verwerking;
        this.startTijd = startTijd;
        this.duur = duur;
        this.compleet = compleet;
        this.dadelijk = dadelijk;
    }
}
