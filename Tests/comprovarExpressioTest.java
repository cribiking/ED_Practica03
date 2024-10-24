import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class comprovarExpressioTest {
    @Test
    void Test1() {
        ArrayList simbols = new ArrayList<>(); //ArrayList perque get(i) té un cost O(1);

        OpenParentesi openParentesi = new OpenParentesi();
        ClosingParentesi closeParentesi = new ClosingParentesi();
        OpenClaudator openClaudator = new OpenClaudator();
        ClosingClaudator closeClaudator = new ClosingClaudator();

        //simbols.add(openParentesi);
        simbols.add(openClaudator);
        simbols.add(closeClaudator);
        simbols.add(closeParentesi);

    }
    @Test
    void Test2() {
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


    }


}