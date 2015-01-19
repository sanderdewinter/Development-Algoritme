import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Klant {

    int klantID;
    String achternaam, tussenvoegsel, voornaam;
    int leeftijd;
    char geslacht;
    String plaats, emailAdres;

    static List<Klant> klanten = new ArrayList<Klant>();

    public Klant(String achternaam, String tussenvoegsel, String voornaam, int leeftijd, char geslacht, String plaats, String emailAdres) {
        this.klantID = klanten.size();
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.emailAdres = emailAdres;

        klanten.add(this);

        bestel(this.klantID);
    }

    public void bestel(int klantID){
        new Bestelling(klantID);
    }

    public static int[] test = new int[]{9,11,3,6,5,4,8,1};

    public static void mergeSort(int[] inputArray) {
        // De lengte van de array
        int lengte = inputArray.length;

        // Als de array kleiner is dan 2
        if (lengte < 2)
            return;

        // Midden van de array
        int midden = lengte / 2;

        // Linker kant van de array
        int linksLengte = midden;

        // Rechter kant van de array
        int rechtsLengte = lengte - midden;

        // 2 Nieuwe arrays
        int[] links = new int[linksLengte];
        int[] rechts = new int[rechtsLengte];

        // Linkse helft vullen
        for (int i = 0; i < midden; i++) {
            links[i] = inputArray[i];
        }

        // Rechtse helft vullen
        for (int i = midden; i < lengte; i++) {
            rechts[i - midden] = inputArray[i];
        }

        // Opnieuwe uitvoeren met links en rechts
        mergeSort(links);
        mergeSort(rechts);

        // Voeg de array samen
        merge(links, rechts, inputArray);
    }

    public static void merge(int[] links, int[] rechts, int[] arr) {
        // Lengte van de 2 arrays
        int linkerLengte = links.length;
        int rechterLengte = rechts.length;

        int i = 0, j = 0, k = 0;

        // Zolang i en j kleiner zijn dan de kant van de array
        while (i < linkerLengte && j < rechterLengte) {

            // Als de linkse kant kleiner is dan de rechter kant
            if (links[i] <= rechts[j]) {
                // Vul de waarde van de linker kant in
                arr[k] = links[i];
                i++;
                k++;

            // Als de rechtse kant kleiner is dan de linker kant
            } else {
                // Vul de waarder van de rechter kant in
                arr[k] = rechts[j];
                k++;
                j++;
            }
        }

        // Als de array oneven is en linker kant is nog niet leeg
        while (i < linkerLengte) {
            arr[k] = links[i];
            k++;
            i++;
        }

        // Als de array oneven is en rechter kant is nog niet leeg
        while (j < linkerLengte) {
            arr[k] = rechts[j];
            k++;
            j++;
        }
    }
}
