import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by rik on 12/14/14.
 */
public class Main {

    public static void main(String[] args) {
        new Main().insertCustomer();
        Klant.mergeSort(Klant.test);
        for (int i = 0; i < Klant.test.length ; i++){
            System.out.println(Klant.test[i]);
        }
    }

    private void insertCustomer(){
        new Klant("van der werf","", "Rik",18, 'M',"Bruinisse","test@test.nl");
        new Klant("van der werf","", "Rik",18, 'M',"Bruinisse","test@test.nl");
        new Klant("Witter","", "Davey",20, 'M',"Spijkenisse","test@test.nl");
        update();
    }

    public static void update(){
        while (Bestelling.queue.size() != 0){
            Bestelling bestelling2;
            Bestelling bestelling = (Bestelling) Bestelling.queue.element();
            if(Bestelling.queue.size() > 1){
                bestelling2 = (Bestelling)((LinkedList)Bestelling.queue).get(1);
                verwerk(bestelling, bestelling2);
            } else {
                verwerk(bestelling, null);
            }
        }
    }

    private static void verwerk(Bestelling bestelling, Bestelling bestelling2){
        Date now = new Date();
        long bestellingTijd = bestelling.startTijd.getTime() + bestelling.duur.getTime();
        Date bestellingDate = new Date (bestellingTijd);
        if (now.compareTo(bestellingDate) > 0 && bestelling2 != null){
            bestelling.compleet=true;
            bestelling2.verwerking=true;
            bestelling2.duur=new Time(1000);
            //Aangezien de datum pas toegevoegd moet worden wanneer er aan de bestelling wordt gewerkt
            bestelling2.startTijd=new Date(now.getTime());
            Bestelling.klaar.add(bestelling);
            Bestelling.queue.poll();
            System.out.println(bestelling.duur);
            System.out.println(bestelling.startTijd);
        } else if(now.compareTo(bestellingDate) > 0 && bestelling2 == null){
            bestelling.compleet=true;
            //Aangezien de datum pas toegevoegd moet worden wanneer er aan de bestelling wordt gewerkt
            Bestelling.klaar.add(bestelling);
            Bestelling.queue.poll();
        }
    }
}
