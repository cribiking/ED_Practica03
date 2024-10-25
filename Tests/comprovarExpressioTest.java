import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class comprovarExpressioTest {
    @Test
    void Test1() {
        //Cridem a la llista del primer testa
        ArrayList<Symbol> list = comprovarExpressio.generateList1();
        comprovarExpressio verifyExp = new comprovarExpressio();
        //Comprovem que el metode funciona comparant el resultat esperat (true) , amb el que ens dona el métode
        assertTrue(comprovarExpressio.comprovarExpressio(list));
    }
    @Test
    void Test2() {
        //Cridem a la llista del segon test
        ArrayList<Symbol> list = comprovarExpressio.generateList2();
        comprovarExpressio verifyExp = new comprovarExpressio();
        //Comprovem que el metode funciona comparant el resultat esperat (false) , amb el que ens dona el métode
        assertFalse( comprovarExpressio.comprovarExpressio(list));
    }
}