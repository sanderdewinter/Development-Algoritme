public class Main {

    public static void main(String[] args) {
        new Main().insertCustomer();

        update();

        // Test merge sorting
        Klant.mergeSort(Klant.test);
        for (int i = 0; i < Klant.test.length; i++) {
            //System.out.println(Klant.test[i]);
        }
    }

    private void insertCustomer() {
        new Klant("Winter", "de", "Sander", 18, 'M', "Sliedrecht", "0877902@hr.nl");
        new Klant("Winter2", "de", "Sander2", 18, 'M', "Sliedrecht", "0877902@hr.nl2");
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