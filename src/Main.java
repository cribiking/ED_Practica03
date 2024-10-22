import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }

    //REFERENCIA: https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java#:~:text=LinkedList%20is%20fast%20for%20appending,to%20delete%20in%20the%20middle.
    public static <E extends Symbol> boolean comprovarExpressio(List<E> list) { //List és genèric

        LinkedList<E> stack = new LinkedList<E>(); //Linked perque O(1) when index = 0 or index = list.size() - 1

        //TODO: Fer que et digui quin element falta
        for (E symbol : list) {
            if (symbol instanceof OpenClaudator || symbol instanceof OpenParentesi) { //Si trobem un element que obre
                stack.push(symbol); //TODO: si afegeix sempre al principi (addFirst), els que tanquen poden estar en ordre diferent, no? Potser millor addLast, no?
            } else if (symbol instanceof ClosingClaudator || symbol instanceof ClosingParentesi) {
                if (stack.isEmpty()) {
                    return false; // No hay un símbolo abierto correspondiente
                }
                stack.pop(); // Se encuentra un símbolo cerrado, eliminar el abierto
            }
        }

        return stack.isEmpty(); // Devuelve true si todos los símbolos están balanceados
    }

    public static void testCase_1() {
        ArrayList simbols = new ArrayList<>(); //ArrayList perque get(i) té un cost O(1);
        OpenParentesi openParentesi = new OpenParentesi();
        ClosingParentesi closeParentesi = new ClosingParentesi();
        OpenClaudator openClaudator = new OpenClaudator();
        ClosingClaudator closeClaudator = new ClosingClaudator();

        simbols.add(openParentesi);
        simbols.add(openClaudator);
        simbols.add(closeClaudator);
        simbols.add(closeParentesi);

        System.out.println("Test case 1");
        System.out.println("-------");

        for (Symbol simbol : simbols) { //TODO: Why this is giving me an error?
            System.out.println(simbol.toString());
        }

        System.out.println("--------");

        if (comprovarExpressio(simbols)) {
            System.out.println("Resultat: Expressió correcte");
            System.out.println("-------");
        } else {
            System.out.println("Resultat: Expressió incorrecte");
            System.out.println("-------");
        }
    }
}


