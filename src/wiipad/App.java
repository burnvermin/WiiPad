
package wiipad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader root = new FXMLLoader(getClass().getResource("WiiPadFXML.fxml"));
               
        root.setControllerFactory(t -> new WiiPadController(new Model()));
       
        
        primaryStage.setScene(new Scene(root.load()));
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
