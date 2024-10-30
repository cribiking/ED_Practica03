import java.util.*;

public class Main {

    public static final int NUM_CLIENTS = 100;
    public static final int TEMPS_CLIENT = 120;
    public static final int TEMPS_ARRIBADA = 15;
    public static final int NUM_CAIXERS = 10;


    public static void main(String[] args) {
        //Exercici 1 - Tokenizer
        testCase_1();//true
        testCase_2();//false

        //Exercici 2 - Simulador de cues
        simuladorDeCues();

    }

    //REFERENCIA: https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java#:~:text=LinkedList%20is%20fast%20for%20appending,to%20delete%20in%20the%20middle.
    public static <E extends Symbol> boolean comprovarExpressio(List<E> list) { //List és genèric

        Pila pila = new Pila();

        for (E symbol : list) {
            if (symbol instanceof OpenClaudator || symbol instanceof OpenParentesi) {
                pila.push(symbol);
                System.out.println("S'ha afegit un "+ symbol.getSymbolType() +" a la pila , buscant parella...");
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
    public static void testCase_1() {

        ArrayList<Symbol> simbols = new ArrayList<>(); //ArrayList perque get(i) té un cost O(1);

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

        System.out.print("Símbols creats:");
        for (Symbol elem : simbols) {
            System.out.print(elem.getSymbolType());
        }

        System.out.println("\n--------");

        if (comprovarExpressio(simbols)) {
            System.out.println("Resultat: Expressió correcte");
            System.out.println("-------");
        } else {
            System.out.println("Resultat: Expressió incorrecte");
            System.out.println("-------");
        }

        System.out.println("\n\n");
    }

    public static void testCase_2() {

        ArrayList<Symbol> simbols = new ArrayList<>(); //ArrayList perque get(i) té un cost O(1);
        OpenParentesi openParentesi = new OpenParentesi();
        ClosingParentesi closeParentesi = new ClosingParentesi();
        OpenClaudator openClaudator = new OpenClaudator();
        ClosingClaudator closeClaudator = new ClosingClaudator();

        simbols.add(openParentesi);
        simbols.add(openClaudator);
        simbols.add(openParentesi);
        simbols.add(closeClaudator);
        simbols.add(closeParentesi);


        System.out.println("Test case 2");
        System.out.println("-------");

        System.out.print("Symbols Creats:");
        for (Symbol elem : simbols) {
            System.out.print(elem.getSymbolType());
        }

        System.out.println("\n--------");

        if (comprovarExpressio(simbols)) {
            System.out.println("Resultat: Expressió correcte");
            System.out.println("-------");
        } else {
            System.out.println("Resultat: Expressió incorrecte");
            System.out.println("-------");
        }

        System.out.println("\n\n");
    }

    public static void simuladorDeCues() {

        int numClients;
        int temps;
        int tempsMitja;
        int tempsMitjaTotal = 0;

        ListCua<Client> cuaClients;
        int[] caixers;

        //Si el temps d'arribada del client és menor que el temps del caixer, el caixer no pot acceptar al client

        for(int i = 0; i < NUM_CAIXERS; i++){
            cuaClients = new ListCua<>();
            caixers = new int[i + 1];
            temps = 0;
            tempsMitja = 0;
            numClients = NUM_CLIENTS;

            while(numClients > 0){

                if(temps % TEMPS_ARRIBADA == 0){
                    cuaClients.inserir(new Client(temps));
                }

                for(int n = 0; n < (i+1) && !cuaClients.isEmpty(); n++){
                        if(caixers[n] <= temps){
                            caixers[n] += TEMPS_CLIENT;
                            tempsMitja += TEMPS_CLIENT + (temps - cuaClients.getFront().getArribada());
                            cuaClients.treure();
                            numClients--;
                        }
                }

                temps++;
            }

            tempsMitjaTotal += tempsMitja/NUM_CLIENTS;
            System.out.println("Nombre de caixers: " + (i + 1) + " - Temps mitjà en ser atesos (en segons): " + tempsMitja/NUM_CLIENTS);

        }

    }
}


