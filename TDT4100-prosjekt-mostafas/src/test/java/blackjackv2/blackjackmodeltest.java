package blackjackv2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class blackjackmodeltest {
    @Test 
    void dealerWins(){

        BlackjackModel model = new BlackjackModel();

        
        Card king = new Card(Suit.CLUBS, Rank.KING);
        Card ten = new Card(Suit.CLUBS, Rank.TEN);
        model.getDealerHand().addCard(king);
        model.getDealerHand().addCard(ten);

       
        Card two = new Card(Suit.DIAMONDS, Rank.TWO);
        model.getPlayerHand().addCard(two);

        assertEquals(-1, model.win());


    }

    @Test
    void initializesFullDeckTest(){
        BlackjackModel model = new BlackjackModel();
        assertEquals(52, model.getDeck().getCards().size());
    }

   @Test
   void isBustTest(){

    BlackjackModel model = new BlackjackModel();
    
    
    Card king = new Card(Suit.CLUBS, Rank.KING);
    Card ten = new Card(Suit.CLUBS, Rank.TEN);
    Card two = new Card(Suit.DIAMONDS, Rank.TWO);

    model.getPlayerHand().addCard(two);
    model.getPlayerHand().addCard(ten);
    model.getPlayerHand().addCard(king);

    assertTrue(model.isBust());
   }

   @Test
   
   void aceValueTest(){
    Hand hand = new Hand();

    Card ace1 = new Card(Suit.CLUBS, Rank.ACE);
    Card king = new Card(Suit.DIAMONDS, Rank.KING);
    Card nine = new Card(Suit.SPADES, Rank.NINE);

    hand.addCard(king);
    hand.addCard(ace1);

    assertEquals(21, hand.getHandValue());

    hand.addCard(nine);
    
    assertEquals(20, hand.getHandValue());
    
   }


   @Test
   void cardValueTest(){
    Card card = new Card(Suit.CLUBS, Rank.FOUR);

    assertEquals(4, card.getValue());
   }

   void hitTest(){
    BlackjackModel model = new BlackjackModel();

    model.hit();
    assertEquals(1, model.getPlayerHand().getCards().size());
    
    assertEquals(51, model.getDeck().getCards().size());
   }

   

}
