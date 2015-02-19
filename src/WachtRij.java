import java.util.LinkedList;
import java.util.NoSuchElementException;

public class WachtRij {

    int size;
    LinkedList<Object> queue;

    public WachtRij() {
        queue = new LinkedList<Object>();
        size = 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Object obj) {
        queue.add(obj);
        size++;
    }

    public void dequeue() {
        queue.remove();
        size--;
    }

    public Object peek() {
        try {
            return queue.getFirst();
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
