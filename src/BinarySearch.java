import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static List<Klant> binarySearch(String achternaam, int min, int max) {
        if (min > max) {
            return null;
        }
        int mid = (max + min) / 2;
        if (Klant.klanten.get(mid).achternaam.equals(achternaam)) {
            List<Klant> results = new ArrayList<Klant>();
            results.add(Klant.klanten.get(mid));
            System.out.println("Mid::::"+Klant.klanten.get(mid).voornaam);
            try {
                for (int i = 1; Klant.klanten.get(mid - i).achternaam.equals(achternaam); i++) {
                    results.add(Klant.klanten.get(mid - i));
                    System.out.println(Klant.klanten.get(mid-i).voornaam);
                }
                for (int i = 1; Klant.klanten.get(mid + i).achternaam.equals(achternaam); i++) {
                    results.add(Klant.klanten.get(mid + i));
                    System.out.println(Klant.klanten.get(mid + i).voornaam);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index out of bounds");
            }
            return results;
        } else if(Klant.klanten.get(mid).achternaam.compareTo(achternaam) > 0) {
            return binarySearch(achternaam, min, mid - 1);
        } else {
            return binarySearch(achternaam, mid + 1, max);
        }
    }
}
