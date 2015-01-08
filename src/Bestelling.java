import java.security.Timestamp;
import java.sql.Time;
import java.util.*;

/**
 * Created by rik on 11/30/14.
 */
public class Bestelling {
    int klantID;
    int bestellingID;
    boolean verwerking;
    Date startTijd;
    Date duur;
    boolean compleet;
    boolean dadelijk;

    public static Queue queue = new LinkedList();
    public static Queue klaar = new LinkedList();

    public Bestelling(int klantID,  boolean verwerking, Date duur, Date startTijd, boolean compleet, boolean dadelijk) {
        this.klantID = klantID;
        this.verwerking = verwerking;
        this.duur = duur;
        this.startTijd = startTijd;
        this.compleet = compleet;
        this.dadelijk = dadelijk;
        this.bestellingID = queue.size();
        queue.add(this);
    }



}
