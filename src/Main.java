import java.util.*;

public class Main {

    public static final int NUM_CLIENTS = 100;
    public static final int TEMPS_CLIENT = 120;
    public static final int TEMPS_ARRIBADA = 15;
    public static final int NUM_CAIXERS = 10;


    public static void main(String[] args) {
        //Exercici 1 - Tokenizer
        //testCase_1();//true
        //testCase_2();//false

        //Exercici 2 - Simulador de cues
        simuladorDeCues();

    }

    //REFERENCIA: https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java#:~:text=LinkedList%20is%20fast%20for%20appending,to%20delete%20in%20the%20middle.
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

        for (Object elem : simbols) {
            System.out.println(elem.toString());
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

    public static void testCase_2() {

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

        for (Object simbol : simbols) {
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

    public static void simuladorDeCues() {

        ListCua<Client> cuaCine;
        ArrayList<Client> caixers;
        Client clientAux;

        int temps;
        int tempsMitja;
        int numClients;
        int numCaixers;

        for(int i = 0; i < NUM_CAIXERS; i++){
            cuaCine = new ListCua<>();
            caixers = new ArrayList<Client>();

            tempsMitja = 0;
            temps = 0;

            numClients = NUM_CLIENTS;


            while(numClients > 0){

                if(temps % TEMPS_ARRIBADA == 0){
                    cuaCine.inserir(new Client(temps));
                    if(caixers.size() != i+1){
                        caixers.add(cuaCine.treure());
                    }
                }

                numCaixers = caixers.size();

                if(temps != 0 && temps % TEMPS_CLIENT == 0){
                    while(!caixers.isEmpty()){
                        caixers.getFirst().setSortida(temps);
                        tempsMitja += caixers.getFirst().tempsTotalCua();
                        caixers.removeFirst();
                        numClients--;
                    }
                    //System.out.println("Temps espera client " + (NUM_CLIENTS - numClients) + ": " + clientAux.tempsTotalCua());
                }

                temps++;

            }

            System.out.println("Nombre de caixers: " + (i+1) + " - Temps mitjà en ser atesos (en segons): " + tempsMitja/NUM_CLIENTS);

        }

    }
}


