import java.util.LinkedList;

public class Stack<E> {
    private LinkedList<E> list;
    
    public Stack() {
        this.list = new LinkedList<E>();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        E element = list.getLast();
        list.removeLast();
        return element;
    }
}
