import java.util.List;

public class comprovarExpressio {
    public static <E extends Symbol> boolean comprovarExpressio(List<E> list) { //List és genèric

        Pila pila = new Pila();

        for (E symbol : list) {
            if (symbol instanceof OpenClaudator || symbol instanceof OpenParentesi) {
                pila.push(symbol);
                System.out.println("S'ha afegit un "+symbol+" , buscant parella...");
            } else if (symbol instanceof ClosingClaudator || symbol instanceof ClosingParentesi) {
                //No hi ha un símbol obert corresponent.
                //Si el primer element ás tancat, retorna false directe
                if (pila.isEmpty()) {
                    return false;
                }
                pila.pop();
                //Es troba un simbol tancat, eliminem l'obert de la pila
            }
        }
        return pila.isEmpty(); // Retornarà true si tots els elements coincideixen
    }
}
