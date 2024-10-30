import java.util.LinkedList;

public class Pila <E extends Symbol> implements InterfaceStack<E> {
    private int size = 0;
    private LinkedList<E> stack = new LinkedList<>();
    @Override
    public void push(E element) {
        stack.add(element);
    }
    @Override
    public E pop() {
        E elem = stack.getLast();
        stack.removeLast(); //Com que utilitzem linkedList no dona problemes amb el tamany
        return elem;
    }
    @Override
    public int getSize() {
        size = 0;
        for (E e : stack){
            size++;
        }
        return size;
    }
    @Override
    public boolean isEmpty() {
        if (getSize() == 0 || stack == null) {
            return true;
        }
        return false;
    }
}
