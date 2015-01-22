import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class WachtRij {

    public int size;

    public List<Bestelling> queue = new ArrayList<Bestelling>();

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
        queue.remove(0);
        size--;
    }

    public Bestelling peek() {
        try {
            return queue.get(0);
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
