import java.util.LinkedList;
import java.util.NoSuchElementException;

public class WachtRij {

    public int size;
    LinkedList<Object> queue;


    public WachtRij() {
        queue = new LinkedList<Object>();
        size = 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Object object) {
        queue.add(object);
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