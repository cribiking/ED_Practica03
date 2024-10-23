import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PrimitiveIterator;

public class Pila implements InterfaceStack {
    private final LinkedList<Object> stack = new LinkedList<Object>();
    private final ListIterator<Object> l_it = stack.listIterator();
    @Override
    public void push(Object element) {
        stack.add(element);
    }
    @Override
    public Object pop() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        //stack.isEmpty();
        while (l_it.hasNext()){
            return true;
        }
        return false;
    }
}
