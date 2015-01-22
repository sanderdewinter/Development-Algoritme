public class Main {

    public static void main(String[] args) {
        new Main().insertCustomer();

        update();

        Klant.klanten = Klant.startSort(Klant.klanten, true);

        // Klant from linear search --> The first klant wich has this age
        int leeftijd = 18;
        System.out.println(Klant.linearSearch(leeftijd));

        // Insertion sort
        new Klant("Winzer", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl");
        for (Klant k : Klant.klanten) {
            System.out.println(k.achternaam);
        }

    }

    private void insertCustomer() {
        new Klant("Winter", "de", "Sander", 18, 'M', "Sliedrecht", "0877902@hr.nl");
        new Klant("Vries", "de", "Sander2", 8, 'M', "Sliedrecht", "0877902@hr.nl2");
        new Klant("Witter", "", "Davey", 20, 'M', "Spijkenisse", "test@test.nl");
    }

    public static void update() {
        while (Bestelling.wachtRij.size() > 0) {
            Bestelling bestelling = Bestelling.wachtRij.peek();
            Bestelling.verwerk(bestelling);
        }

        finish();
    }

    public static void finish() {
        System.out.println("Alle bestellingen zijn verwerkt");
    }
}