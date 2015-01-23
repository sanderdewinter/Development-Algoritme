import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static List<Klant> startSort(List<Klant> klanten, boolean mergeSort) {
        Klant[] array = klanten.toArray(new Klant[klanten.size()]);
        if (mergeSort) {
            mergeSort(array);
        } else {
            InsertionSort.insertionSort(array);
        }
        return new ArrayList<Klant>(Arrays.asList(array));
    }

    private static void mergeSort(Klant[] klanten) {
        // De lengte van de array
        int lengte = klanten.length;

        // Als de array kleiner is dan 2
        if (lengte < 2) {
            return;
        }

        // Midden van de array
        int midden = lengte / 2;

        // Linker kant van de array
        int linksLengte = midden;

        // Rechter kant van de array
        int rechtsLengte = lengte - midden;

        // 2 Nieuwe arrays
        Klant[] links = new Klant[linksLengte];
        Klant[] rechts = new Klant[rechtsLengte];

        // Linkse helft vullen
        for (int i = 0; i < midden; i++) {
            links[i] = klanten[i];
        }

        // Rechtse helft vullen
        for (int i = midden; i < lengte; i++) {
            rechts[i - midden] = klanten[i];
        }

        // Opnieuwe uitvoeren met links en rechts
        mergeSort(links);
        mergeSort(rechts);

        // Voeg de array samen
        merge(links, rechts, klanten);
    }

    public static void merge(Klant[] links, Klant[] rechts, Klant[] arr) {
        // Lengte van de 2 arrays
        int linkerLengte = links.length;
        int rechterLengte = rechts.length;

        int l = 0, r = 0, i = 0;

        // Zolang i en j kleiner zijn dan de kant van de array
        while (l < linkerLengte && r < rechterLengte) {

            // Als de linkse kant kleiner is dan de rechter kant
            if (links[l].leeftijd <= rechts[r].leeftijd) {
                // Vul de waarde van de linker kant in
                arr[i] = links[l];
                l++;
                i++;

                // Als de rechtse kant kleiner is dan de linker kant
            } else {
                // Vul de waarder van de rechter kant in
                arr[i] = rechts[r];
                i++;
                r++;
            }
        }

        // Als de array oneven is en linker kant is nog niet leeg
        while (l < linkerLengte) {
            arr[i] = links[l];
            i++;
            l++;
        }

        // Als de array oneven is en rechter kant is nog niet leeg
        while (r < linkerLengte) {
            arr[i] = rechts[r];
            i++;
            r++;
        }
    }
}
