import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Crearem una serie de proves per així poder guiar-nos
        //1. creació de arrays
        //testCase_1();
        testCase_2();
    }

    //REFERENCIA: https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java#:~:text=LinkedList%20is%20fast%20for%20appending,to%20delete%20in%20the%20middle.
    public static <E extends Symbol> boolean comprovarExpressio(List<E> list) { //List és genèric

        LinkedList<E> stack = new LinkedList<E>(); //Linked perque O(1) when index = 0 or index = list.size() - 1

        //TODO: Fer que et digui quin element falta
        for (E symbol : list) {

            if (symbol instanceof OpenClaudator || symbol instanceof OpenParentesi) {
                stack.push(symbol);
            } else if (symbol instanceof ClosingClaudator || symbol instanceof ClosingParentesi) {
                if (stack.isEmpty()) {
                    return false;
                    /*
                     No hay un símbolo abierto correspondiente
                     Si el primer elemento es cerrado, retorna false directe
                    */
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

        for (int i = 0; i < simbols.size(); i++){
            System.out.println(simbols.get(i).toString());
        }

//        for (Symbol simbol : simbols) { //TODO: Why this is giving me an error?
//        }

        System.out.println("--------");

        if (comprovarExpressio(simbols)) {
            System.out.println("Resultat: Expressió correcte");
            System.out.println("-------");
        } else {
            System.out.println("Resultat: Expressió incorrecte");
            System.out.println("-------");
        }
    }

    public static void testCase_2() { //Error

        ArrayList simbols = new ArrayList<>(); //ArrayList perque get(i) té un cost O(1);
        OpenParentesi openParentesi = new OpenParentesi();
        ClosingParentesi closeParentesi = new ClosingParentesi();
        OpenClaudator openClaudator = new OpenClaudator();
        ClosingClaudator closeClaudator = new ClosingClaudator();

        simbols.add(openParentesi);
        simbols.add(closeClaudator);
        simbols.add(openClaudator);
        simbols.add(closeClaudator);
        simbols.add(closeParentesi);

        System.out.println("Test case 2");
        System.out.println("-------");

        for (int i = 0; i < simbols.size(); i++){
            System.out.println(simbols.get(i).toString());
        }

//        for (Symbol simbol : simbols) { //TODO: Why this is giving me an error?
//        }

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


