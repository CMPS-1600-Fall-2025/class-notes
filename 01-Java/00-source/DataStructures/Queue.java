import java.util.LinkedList;

public class Queue<E> {
    private LinkedList<E> list;
    
public Queue() {
        this.list = new LinkedList<E>();
    }

    public void enqueue(E element) {
        list.add(element);
    }

    public E dequeue() {
        E element = list.getFirst();
        list.removeFirst();
        return element;
    }
}
