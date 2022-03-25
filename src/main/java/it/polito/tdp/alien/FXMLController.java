package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private AlienDictionary alienDictionary = new AlienDictionary();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="lbText"
    private TextField lbText; // Value injected by FXMLLoader
    
    @FXML
    private TextArea txtResult;


    @FXML
    void doReset(ActionEvent event) {
    	
    alienDictionary.doReset();
    lbText.clear();
    txtResult.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtResult.clear();
    	String riga = lbText.getText().toLowerCase();
    	
    	if(riga==null || riga.length()==0 ) {
    		txtResult.setText("Inserisci una o due parole");
    		return;
    	}
    	
    	StringTokenizer st = new StringTokenizer(riga, " ");
    	
    	if(!st.hasMoreTokens()) {
    		txtResult.setText("Inserisci una o due parole");
    		return;
    	}
    	
    	String alienWord = st.nextToken();
    	
    	if(st.hasMoreTokens()) {
    		
    		String translation = st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		
    		alienDictionary.addWord(alienWord, translation);
    		
    		txtResult.setText("la parola \""+alienWord+"\" è stata aggiunta con traduzione \""+ translation);
    		
    	} else {
    		if(!alienWord.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici o punto interrogativo");
    			return;
    		}
    		
    		String translation;
    		
    		if(!alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")) {
    			
    			translation = alienDictionary.translateWordWildCard(alienWord);
    		} else {
    			
    			translation = alienDictionary.translateWord(alienWord);
    			
    		}
    		
    		if(translation != null) {
    			txtResult.setText(translation);
    		} else {
    			txtResult.setText("la parola cercata non è presente");
    		}
    	}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lbText != null : "fx:id=\"lbText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
