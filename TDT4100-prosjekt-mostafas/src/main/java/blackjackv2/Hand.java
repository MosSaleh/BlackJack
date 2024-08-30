package blackjackv2;
import java.util.ArrayList;


public class Hand implements CardContainer{

    private ArrayList<Card> cards;

    public Hand(){
        ArrayList<Card> cards = new ArrayList<>();

        this.cards = cards;
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

     public int getHandValue(){
        int sum = 0;
        int aces = 0;
        for(Card card: cards){
            if(card.isAce()){
                aces += 1;
            }
            else{
                sum += card.getValue();
            }
        }

        while (aces > 0){
            aces--;
            if(sum + 11 < 22){
                sum += 11;
            }
            else{
                sum++;
            }
        }

        return sum;
    }

    public String toString(){
        return cards.toString() + " (" + getHandValue() + ")";
    }
}
