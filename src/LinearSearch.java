public class LinearSearch {
    public static Klant linearSearch(int waarde) {
        for (Klant klant : Klant.klanten) {
            if (klant.leeftijd == waarde) {
                return klant;
            }
        }
        return null;
    }

    public static Klant linearSearch(String waarde) {
        for (Klant klant : Klant.klanten) {
            if (klant.achternaam.equals(waarde)) {
                return klant;
            }
        }
        return null;
    }
}
