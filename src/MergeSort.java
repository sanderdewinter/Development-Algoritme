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
        int lengte = klanten.length;
        if (lengte < 2) {
            return;
        }
        int midden = lengte / 2;
        int linksLengte = midden;
        int rechtsLengte = lengte - midden;
        Klant[] links = new Klant[linksLengte];
        Klant[] rechts = new Klant[rechtsLengte];
        for (int i = 0; i < midden; i++) {
            links[i] = klanten[i];
        }
        for (int i = midden; i < lengte; i++) {
            rechts[i - midden] = klanten[i];
        }
        mergeSort(links);
        mergeSort(rechts);
        merge(links, rechts, klanten);
    }

    public static void merge(Klant[] links, Klant[] rechts, Klant[] arr) {
        int linkerLengte = links.length;
        int rechterLengte = rechts.length;
        int l = 0, r = 0, i = 0;
        while (l < linkerLengte && r < rechterLengte) {
            if (links[l].leeftijd <= rechts[r].leeftijd) {
                arr[i] = links[l];
                l++;
                i++;
            } else {
                arr[i] = rechts[r];
                i++;
                r++;
            }
        }
        while (l < linkerLengte) {
            arr[i] = links[l];
            i++;
            l++;
        }
        while (r < linkerLengte) {
            arr[i] = rechts[r];
            i++;
            r++;
        }
    }
}
