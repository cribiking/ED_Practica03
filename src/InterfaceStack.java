public interface InterfaceStack <E extends Symbol> {
    public void push (E element);
    public E pop();
    public int getSize();
    public boolean isEmpty();
}
