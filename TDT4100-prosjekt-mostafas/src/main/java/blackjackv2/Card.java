package blackjackv2;
public class Card {

    private final Suit suit;
    private final Rank rank;
    

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public int getValue(){
        switch(this.getRank()){
            case TWO : return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case JACK: return 10;
            case QUEEN: return 10;
            case KING : return 10;
            case ACE : return 0;
            default : return 0;
        }
    }
    
    public boolean isAce(){
        if(this.getRank() == Rank.ACE){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return rank + " " + suit;
    }
    
    
}