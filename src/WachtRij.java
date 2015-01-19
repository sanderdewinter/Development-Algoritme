import java.util.ArrayList;

public class WachtRij {

    public int size;

    public ArrayList<Bestelling> queue = new ArrayList<Bestelling>();

    public WachtRij() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Bestelling bestelling) {
        queue.add(bestelling);
        size++;
    }

    public void dequeue() {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).compleet) {
                queue.remove(i);
                size--;
            }
        }
    }

    public Bestelling peek() {
        for (int i = 0; i < queue.size(); i++) {
            if (!queue.get(i).verwerking) {
                return queue.get(i);
            }
        }
        return null;
    }
}
