import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static List<Klant> startSort(List<Klant> klanten, boolean improved) {
        Klant[] array = klanten.toArray(new Klant[klanten.size()]);
        if (improved)
            insertionSortImproved(array);
        else
            insertionSort(array);
        return new ArrayList<Klant>(Arrays.asList(array));
    }

    public static void insertionSort(Klant[] inputArray) {
        int i, j;
        Klant key;

        for (j = 1; j < inputArray.length; j++) {
            key = inputArray[j];
            i = j - 1;
            while (i >= 0) {
                if (key.achternaam.compareTo(inputArray[i].achternaam) > 0) {
                    break;
                }
                inputArray[i + 1] = inputArray[i];
                i--;
            }
            inputArray[i + 1] = key;
        }
    }

    public static void insertionSortImproved(Klant[] inputArray) {
        Klant key = inputArray[inputArray.length - 1];

        int i = inputArray.length - 2;
        while (i >= 0) {
            if (key.achternaam.compareTo(inputArray[i].achternaam) > 0) {
                break;
            }
            inputArray[i + 1] = inputArray[i];
            i--;
        }
        inputArray[i + 1] = key;

    }
}
