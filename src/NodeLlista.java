import java.util.ArrayList;
import java.util.LinkedList;

public class NodeLlista<T> {
    private Node<T> front;  //Inici de la cua
    private Node<T> back;   //Final de la cua
    private LinkedList<T> cua;

    public NodeLlista(){
        LinkedList<T> cua = new LinkedList<>();
    };

    public void enqueue(T element) {
        if(cua.isEmpty()){
            Node<T> = cua.
        }
    };

    public T dequeue() {
        return null;
    };

    public T getFront() {
        return null;
    }

    private static class Node<T>{
        T element;
        Node<T> next;
        Node<T> previous;
        Node(T e, Node<T> next, Node<T> previous){
            element = e;
            this.next = next;
            this.previous = previous;
        }
    };



}
