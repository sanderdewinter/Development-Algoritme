import java.util.LinkedList;
import java.util.NoSuchElementException;

public class WachtRij {

    private int size;

    public LinkedList<Bestelling> queue = new LinkedList<Bestelling>();

    public WachtRij() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Bestelling bestelling) {
        queue.add(queue.size(), bestelling);
        size++;
    }

    public void dequeue() {
        queue.remove(queue.getFirst());
        size--;
    }

    public Bestelling peek() {
        try {
            return queue.getFirst();
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
