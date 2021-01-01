package wiipad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;

public class Model {
   
     public IOResult<TextFile> load(Path file){
        
        try {    
            List<String> lines = Files.readAllLines(file);
            return new IOResult<>(true, new TextFile(file, lines));
        } catch (IOException ex) {
            Logger.getLogger(WiiPadController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex.getMessage());
            return new IOResult<>(false, null);
        
    }
     }
    
    @FXML
    public void save(TextFile textFile){
        
        try {
                       
            Files.write(textFile.getFile(), textFile.getContent(), StandardOpenOption.CREATE_NEW);
                       
        } catch (IOException ex) {
            Logger.getLogger(WiiPadController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        
    }
    
}
