/**
 * Created by Davey on 23-01-15.
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
