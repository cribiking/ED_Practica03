import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }


    public static <E extends Symbol> boolean comprovarExpressio(List<E> list) {

        Stack<E> stack = new ArrayStack<E>();

        for (E symbol : list) {
            if (symbol instanceof OpenClaudator || symbol instanceof OpenParentesi) {
                stack.push(symbol);
            } else if (symbol instanceof ClosingClaudators || symbol instanceof ClosingParentesi) {
                if (stack.isEmpty()) {
                    return false; // No hay un símbolo abierto correspondiente
                }
                stack.pop(); // Se encuentra un símbolo cerrado, eliminar el abierto
            }
        }

        return stack.isEmpty(); // Devuelve true si todos los símbolos están balanceados
    }
}


