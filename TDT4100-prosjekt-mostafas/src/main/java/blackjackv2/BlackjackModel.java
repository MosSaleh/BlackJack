package blackjackv2;

//endre på navnet
public class BlackjackModel {
    private Hand dealerHand;
    private Hand playerHand;
    private DealerDeck deck;


    public BlackjackModel(){
        this.dealerHand = new Hand();
        this.playerHand = new Hand();
        this.deck = new DealerDeck();
    }

    public void startGame(){
        this.deck = new DealerDeck();

        deck.shuffleDeck();
        dealerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
    }

    public Hand getPlayerHand(){
        return this.playerHand;
    }

    public Hand getDealerHand(){
        return this.dealerHand;
    }
    public boolean isBust(){
        if(playerHand.getHandValue() > 21){
            return true;
        }
        else{
            return false;
        }
    }
    public void hit(){
        if (this.getDeck().getCards().size() > 1){
            playerHand.addCard(deck.drawCard());
        }
        
    }

    public void dealerturn(){
        while (dealerHand.getHandValue() < 17){
            dealerHand.addCard(deck.drawCard());
        }

    }

    public int win(){
        if(playerHand.getHandValue() > 21){
            return -1;
        }
        else if(dealerHand.getHandValue() > 21 || playerHand.getHandValue() > dealerHand.getHandValue() ){
            return 1;
        }
        else if(dealerHand.getHandValue() == playerHand.getHandValue()){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    public DealerDeck getDeck(){
        return this.deck;
    }

   
}
