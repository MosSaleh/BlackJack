package blackjackv2;
import java.util.ArrayList;


public class DealerDeck implements CardContainer{
    private ArrayList<Card> cards;

    public DealerDeck(){
    
        this.cards = new ArrayList<>();

        for (Suit suit: Suit.values()){
            for (Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffleDeck(){
        ArrayList<Card> shuffledCards = new ArrayList<>();

        while (this.cards.size() > 0){
            int index = (int)(Math.random() * cards.size());
            shuffledCards.add(this.cards.remove(index)); 
        }  

        this.cards = shuffledCards;
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }
    public Card drawCard(){
        return this.cards.remove(this.cards.size() -1);
    }

    
}
