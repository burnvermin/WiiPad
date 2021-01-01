
package wiipad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class WiiPadController  {

    @FXML
    private TextArea textArea;
    private Model model;
    private TextFile currentTextFile;
    
    
    public WiiPadController (Model model){
    
        this.model = model;
        
    }
    
    
       @FXML
       public void onClose(){
           //We can use two methods
           //Platform.exit();
           System.exit(0);
    }
       
       
    @FXML
    public void openFile() throws Exception{
          //This is how you convert legacy file to new representation of file in java
            
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("./"));
            File file = fileChooser.showOpenDialog(null);
            if(file != null){    
            IOResult<TextFile> io = model.load(file.toPath());
            
                if(io.isOk() && io.hasData()){
                    currentTextFile  = io.getData();
                    textArea.clear();
                    currentTextFile.getContent().forEach(line -> textArea.appendText(line + ("\n")));
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Task Failed Successfully");
                    alert.show();
                }
            
            }
        
    }
    
    @FXML
    public void saveFile(){
//        
//        TextFile textFile = new TextFile(currentTextFile.getFile(), Arrays.asList(textArea.getText()));
//            model.save(textFile);
        
            FileChooser fileChooser = new FileChooser();
//         fileChooser.setInitialDirectory(new File("./"));
         fileChooser.setTitle("Save");
         File file;
         file = fileChooser.showSaveDialog(null);
         
            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
        
            if(file != null) {
                saveTextToFile(textArea, file);
                File dir = file.getParentFile();
                fileChooser.setInitialDirectory(dir); 
        }
    }
    
    @FXML
    public void saveAsFile(){     
         FileChooser fileChooser = new FileChooser();
         fileChooser.setInitialDirectory(new File("./"));
         File file = fileChooser.showSaveDialog(null);
         
                //create extension filters. The choice will be appended to the end of the file name
             fileChooser.getExtensionFilters().addAll(
                     new FileChooser.ExtensionFilter("pdf Files", "*.pdf"),
                     new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        //
         if (file != null) {
              fileChooser.setInitialDirectory(file.getParentFile()); 
                saveTextToFile(textArea, file);
            }
         
    }
    
    @FXML
     private void saveTextToFile(TextArea content, File file) {
     textArea = content;
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content.getText());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WiiPadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    public void copyText(){
        textArea.copy();
    }
    
     @FXML
    public void pasteText(){
        textArea.paste();
    }
    
     @FXML
    public void cutText(){
        textArea.cut();
    }
    
    @FXML
    public void deleteText(){
        textArea.deleteNextChar();
    }
    
    @FXML
    public void onAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("This is text Editor App made By David. Go follow me on Twitter @KoningDavid_I");
        alert.show();
    }
    
}
