package blackjackv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.io.IOException;

public class BlackjackView extends Application{
    
    public static void main(String[] args) {
        
        Application.launch(args);
    }
    @Override

    //chat.openai.com brukt som kilde for start metoden
    public void start(Stage primaryStage) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = loader.load();
        BlackjackController controller = loader.getController();
        controller.initView(this);
        primaryStage.setTitle("Blackjack");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
    }

    
}
