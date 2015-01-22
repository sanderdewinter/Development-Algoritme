public class Main {

    public static void main(String[] args) {
        // Make customers, they will automatisch make Bestellingen and added to WachtRij
        new Main().insertCustomer();
        System.out.println("Totaal aantal bestellingen in de queue: " + Bestelling.wachtRij.size());

        // Bestellingen will be 'verwerkt' (updated)
        Bestelling.update();

        Klant.klanten = Klant.startSort(Klant.klanten, true);

        // Klant from linear search --> The first klant wich has this age
        int leeftijd = 18;
        System.out.println(Klant.linearSearch(leeftijd));

        // Insertion sort
        new Klant("Winzer", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl");
        for (Klant k : Klant.klanten) {
            System.out.println(k.achternaam);
        }

        // Binary search
        System.out.println("Zoek klant: de Vries");
        System.out.println(Klant.binarySearch("Winter", 0, Klant.klanten.size()).voornaam);
    }

    private void insertCustomer() {
        new Klant("Winter", "de", "Sander", 18, 'M', "Sliedrecht", "0877902@hr.nl");
        new Klant("Winter", "de", "Piet", 8, 'M', "Sliedrecht", "0877902@hr.nl2");
        new Klant("Witter", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl");
    }
}