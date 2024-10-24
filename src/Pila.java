import java.util.LinkedList;
import java.util.ListIterator;

public class Pila implements InterfaceStack {
    private int size = 0;
    private LinkedList<Object> stack = new LinkedList<Object>();
    @Override
    public void push(Object element) {
        stack.add(element);
    }
    @Override
    public Object pop() {
        Object obj = stack.getLast();
        stack.removeLast(); //Com que utilitzem linkedList no dona problemes amb el tamany
        return obj;
    }
    @Override
    public int getSize() {
        size = 0;
        for (Object e : stack){
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
