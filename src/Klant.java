import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rik on 11/30/14.
 */
public class Klant {
    int klantID;
    String achternaam;
    String tussenvoegsel;
    String voornaam;
    int leeftijd;
    char geslacht;
    String plaats;
    String email;

    static List<Klant> klantenArray = new ArrayList<Klant>();

    public Klant(String achternaam, String tussenvoegsel, String voornaam, int leeftijd, char geslacht, String plaats, String email) {
        this.klantID = klantenArray.size();
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.email = email;
        klantenArray.add(this);
        bestel(this.klantID);
    }

    public void bestel(int klantID){
        Date date = new Date();
        new Bestelling(klantID,  true, new Time(1000), new Date(date.getTime()) , true, true);
    }

    public static int[] test = new int[]{9,11,3,6,5,4,8,1};

    public static void mergeSort(int[] inputArray) {
        // The length of the array
        int lengte = inputArray.length;
        // If the array has a length of less than 2
        if (lengte < 2)
            return;
        // The middle of the array
        int midden = lengte / 2;
        // The size of the left part of the array
        int linksLengte = midden;
        // The size of the right part of the array
        int rechtsLengte = lengte - midden;
        // Creating two new arrays for the left and the right part
        int[] links = new int[linksLengte];
        int[] rechts = new int[rechtsLengte];
        // For all the items in the first array
        for (int i = 0; i < midden; i++) {
            // Copy from the original left part of the array
            links[i] = inputArray[i];

        }
        // For all the items in the second array
        for (int i = midden; i < lengte; i++) {
            // Copy from the original right part of the array
            rechts[i - midden] = inputArray[i];
        }

        // Execute the function again for the left and the right part of the array
        mergeSort(links);
        mergeSort(rechts);
        // merge the two arrays
        merge(links, rechts, inputArray);
    }

    public static void merge(int[] links, int[] rechts, int[] arr) {
        // get the length of the two arrays
        int linkerLengte = links.length;
        int rightSize = rechts.length;
        // assign 0 to i, j and k
        int i = 0, j = 0, k = 0;
        // while i is less than the left size and j is less than the right size, execute this
        while (i < linkerLengte && j < rightSize) {
            // if the number on the position on the left is less than the number at the position of the right, execute this
            if (links[i] <= rechts[j]) {
                // put the value of the left part back in the array
                arr[k] = links[i];
                i++;
                k++;
            // if the number on the position on the right is less than the number at the position of the right, execute this
            } else {
                // put the value of the right part back in the array
                arr[k] = rechts[j];
                k++;
                j++;
            }
        }
        // if one of the two arrays is empty, but the other not, execute the following:
        // while the left size is not empty, execute this
        while (i < linkerLengte) {
            // put the value of the cursor back in the array
            arr[k] = links[i];
            k++;
            i++;
        }
        // while the right size is not empty, execute this
        while (j < linkerLengte) {
            // put the value of the cursor back in the array
            arr[k] = rechts[j];
            k++;
            j++;
        }
    }


}
