package blackjackv2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class blackjackfiletest {
    @Test
    public void addWinTest(){
        WinCounter counter = new WinCounter();
        counter.addWin();

        assertEquals(1, counter.readWins());
    }

    @Test
    public void resetWinsTest(){
        WinCounter counter = new WinCounter();
        counter.addWin();

        counter.resetScore();

        assertEquals(0, counter.readWins());
    }
}
