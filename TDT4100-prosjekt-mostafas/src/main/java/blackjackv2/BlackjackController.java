package blackjackv2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BlackjackController
{   
    @FXML private Button hitButton, newGame, standButton, resetButton;
    @FXML private TextArea playerHandText, dealerHandText, gameStateText, scoreTextArea;

    private BlackjackModel model;
    private BlackjackView view;
    private WinCounter winCounter = new WinCounter();
    
    public void initModel(){
        this.model = new BlackjackModel();
        this.model.startGame();
    }
    
    public void initView(BlackjackView view){
        this.view = view;
        disableControls();
    }

    public void initWinCounter(){
        this.winCounter = new WinCounter();
    }
    

    @FXML
    public void newGame(){
        initModel();
        enableControls();
        showHands();

    }

    @FXML
    public void onHit(){
        this.model.hit();
        playerHandText.setText(this.model.getPlayerHand().toString());

        if(this.model.isBust()){
            gameStateText.setText("You busted and lost!");
            disableControls();

        }

    }

    @FXML
    public void showHands(){
        playerHandText.setText(this.model.getPlayerHand().toString());
        dealerHandText.setText(this.model.getDealerHand().toString());
    }
    @FXML
    public void disableControls(){
        hitButton.setDisable(true);
        standButton.setDisable(true);
    }

    @FXML
    public void enableControls(){
        hitButton.setDisable(false);
        standButton.setDisable(false);
    }

    @FXML
    public void onStand(){

        this.model.dealerturn();
        showHands();
        if(this.model.win() == 1){
            gameStateText.setText("You win!");
            winCounter.addWin();
            scoreTextArea.setText(String.valueOf(winCounter.readWins()));
        }else if (this.model.win() == 0){
            gameStateText.setText("You tie!!");
        }else{
            gameStateText.setText("Oh no you lost!");
        }

        disableControls();
    }

    @FXML
    public void onReset(){
        winCounter.resetScore();
        scoreTextArea.setText(String.valueOf(winCounter.readWins()));
    }


}