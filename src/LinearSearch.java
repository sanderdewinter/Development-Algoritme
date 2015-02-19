/**
 * Created by sander on 1/23/15.
 */
public class LinearSearch {
    public static Klant linearSearch(int leeftijd) {
        for (Klant klant : Klant.klanten) {
            if (klant.leeftijd == leeftijd) {
                return klant;
            }
        }
        return null;
    }
}
