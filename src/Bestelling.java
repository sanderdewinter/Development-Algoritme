import java.sql.Time;
import java.util.Date;

public class Bestelling {

    int klantID, bestellingID;
    boolean verwerking;
    Date startTijd;
    Time duur;
    boolean compleet, dadelijk;
    public static WachtRij wachtRij = new WachtRij();
    public static WachtRij compleetWachtRij = new WachtRij();

    public Bestelling(int klantID) {
        this.klantID = klantID;
        this.verwerking = false;
        this.compleet = false;
        this.dadelijk = false;
        this.bestellingID = wachtRij.size();
        System.out.println("Enqueue this Bestelling: " + this);
        wachtRij.enqueue(this);
    }

    public static void update() {
        while (wachtRij.size() > 0) {
            Bestelling bestelling = (Bestelling) wachtRij.peek();
            verwerk(bestelling);
        }
        finish();
    }

    public static void finish() {
        System.out.println("Alle bestellingen zijn verwerkt");
        System.out.println("Bestelling compleetWachtrij grootte: " + compleetWachtRij.size());
    }

    public static void verwerk(Bestelling bestelling) {
        if (!bestelling.verwerking) {
            bestelling.verwerking = true;
            bestelling.startTijd = new Date();
            bestelling.duur = new Time(1000);
        }
        Date now = new Date();
        long bestellingTijd = bestelling.startTijd.getTime() + bestelling.duur.getTime();
        Date eindDate = new Date (bestellingTijd);
        if (now.compareTo(eindDate) < 0) {
            bestelling.compleet = true;
            compleetWachtRij.enqueue(bestelling);
            System.out.println("Size before deque: " + wachtRij.size());
            wachtRij.dequeue();
            System.out.println("Size after deque: " + wachtRij.size());
        }
    }
}