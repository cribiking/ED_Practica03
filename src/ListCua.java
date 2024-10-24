
public class ListCua<T> implements CuaInterface<T>{
    private Node<T> front;  //Cap, inici de la cua
    private Node<T> back;   //Cua, final de la cua

    /**
     * Inicialitza la nova llista de nodes
     */
    public ListCua(){ front = back = null; }

    /**
     * Si el front és buit, vol dir que no hi ha cap element a la llista
     * @return Boolean indicant si la llista és buida
     */
    public boolean isEmpty() {
        return front == null;
    }

    //TODO: explicar això per pasos, tipus 1. 2. 3. etc
    /**
     * Funció que crea un nou node, i actualitza els punters dels nodes contiguus.
     * Cada cop que fem un enqueue, creeem un nou node (sense apuntadors), a continuació, apuntem el "previous" del
     * node que hem creat a l'últim node de la "llista" (back), actualitzem el back perquè el seu "next"
     * apunti al node que acabem de crear i finalment actualitzem la llista perquè el back sigui el node que acabem de crear
     * @param element Element a introduir
     */
    public void inserir(T element) { //Enqueue

        Node<T> aux;

        if(front == null && back == null){ //Si és el primer node que afegim, tant el principi com el final de la cua estan aquest únic node
            front = back = new Node<T>(element, null, null);
        } else {
            aux = new Node<T>(element, null, back); //El nou node no té next, ja que és l'últim en ser creat
            back.next = aux;    //Actualitzem i apuntem el next del penultim node, al que acabem de crear
            back = aux; //Actualitzem el final de la cua
        }
    }

    /**
     * Actualitzem el següent element del front perquè sigui el "front" de la cua
     * No hem d'eliminar el node que ja no és el front perquè el garbage collector
     * de java ho fa automàticament, és a dir, simplement hem d'actualiztar punters.
     * @return Element del node a eliminar, NULL en cas que no hi hagi element a eliminar
     */
    public T treure() { //Dequeue
        T aux = null;

        if(isEmpty()){
            System.out.println("No hi ha elements, no es pot eliminar l'últim element de la llista");
        } else {
            aux = front.element;
            front = front.next;
            front.previous = null;
        }

        if(front == null){ //Quan el front és NULL, vol dir que ja no tenim elements en la llista
            back = null;
        }

        return aux;
    };

    /**
     * Retorna el primer element de la llista
     * @return Element del primer node de la llista
     */
    public T getFront() {
        return this.front.element;
    }

    /**
     * Classe node que defineix el comportament d'un node
     * @param <T> Type, qualsevol tipus d'objecte/element
     */
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
