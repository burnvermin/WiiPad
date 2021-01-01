package wiipad;

import java.nio.file.Path;
import java.util.List;
import javafx.fxml.FXML;

public class TextFile {
    @FXML
    private final Path file;
    private final List<String> content;
   
    public TextFile(Path file, List<String> content){
        
        this.file = file;
        this.content = content;
                
    }
    @FXML
    public Path getFile(){
        return file;
    }
    @FXML
    public List<String> getContent() {
        return content;
    }
    
    
    
}
