package it.ivan.codiceFiscale;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CodiceFiscaleController {
	
	private String nome;
	private String cognome;
	private String sesso;
	private String data;
	private String comune;
	private String risultato;
	private String carattere;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button calcolaBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private TextField nomeTxt;

    @FXML
    private TextField cognomeTxt;

    @FXML
    private TextField dataNascitaTxt;

    @FXML
    private TextField cittaNascitaTxt;

    @FXML
    private TextField sessoTxt;

    @FXML
    private TextField codiceFiscaleTxt;

    @FXML
    void doCalcola(ActionEvent event) {
    	
    	nome = nomeTxt.getText();
    	if (!empty(nome)) {
    		Nome name = new Nome(nome);
    		nome = name.elaboraNome();
    	} else 
    		emptyMessage(nomeTxt);
    		
		
		cognome = cognomeTxt.getText();
		if (!empty(cognome)) {
			Cognome surname = new Cognome(cognome);
			cognome = surname.elaboraCognome();
		} else 
			emptyMessage(cognomeTxt);
		
		sesso = sessoTxt.getText();
		Sesso sex = null;
		if (!empty(sesso))
			sex = new Sesso(sesso);
		else 
			emptyMessage(sessoTxt);
		
		data = dataNascitaTxt.getText();
		if (!empty(data)) {
			DataNascita dataNascita = new DataNascita(data, sex.femminaMaschi());
			data = dataNascita.elaboraData();
		} else
			emptyMessage(dataNascitaTxt);
		
		comune = cittaNascitaTxt.getText();
		if (!empty(comune)) {
			ComuneNascita comuneNascita = new ComuneNascita(comune);
			comune = comuneNascita.comuneNascita();
		} else
			emptyMessage(this.cittaNascitaTxt);
		
		risultato = (cognome + nome + data + comune).toUpperCase();
		
		CarattereControllo carattereControllo = new CarattereControllo(risultato);
		carattere = carattereControllo.carattereControllo();
		
		risultato = (cognome + nome + data + comune + carattere).toUpperCase();
		
		if (!empty(risultato))
			codiceFiscaleTxt.setText(risultato);
		else
			codiceFiscaleTxt.setText("ERRORE");

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	nomeTxt.setText("");
		cognomeTxt.setText("");
		sessoTxt.setText("");
		dataNascitaTxt.setText("");
		cittaNascitaTxt.setText("");
		codiceFiscaleTxt.setText("");
		
		nome = "";
    	cognome = "";
    	sesso = "";
    	data = ""; 
    	comune ="";
    	risultato = "";
    	carattere = "";

    }
    
    private boolean empty(String s) {
    	return s == null || s.trim().isEmpty();
    }
    
    private void emptyMessage(TextField textField) {
    	textField.setText("Questo campo non dev'essere vuoto"); 
    	nome = "";
    	cognome = "";
    	sesso = "";
    	data = ""; 
    	comune ="";
    	risultato = "";
    	carattere = "";
    	
    }

    @FXML
    void initialize() {
        assert calcolaBtn != null : "fx:id=\"calcolaBtn\" was not injected: check your FXML file 'CodiceFiscale.fxml'.";
        assert resetBtn != null : "fx:id=\"resetBtn\" was not injected: check your FXML file 'CodiceFiscale.fxml'.";
        assert nomeTxt != null : "fx:id=\"nomeTxt\" was not injected: check your FXML file 'CodiceFiscale.fxml'.";
        assert cognomeTxt != null : "fx:id=\"cognomeTxt\" was not injected: check your FXML file 'CodiceFiscale.fxml'.";
        assert dataNascitaTxt != null : "fx:id=\"dataNascitaTxt\" was not injected: check your FXML file 'CodiceFiscale.fxml'.";
        assert cittaNascitaTxt != null : "fx:id=\"cittaNascitaTxt\" was not injected: check your FXML file 'CodiceFiscale.fxml'.";
        assert sessoTxt != null : "fx:id=\"sessoTxt\" was not injected: check your FXML file 'CodiceFiscale.fxml'.";
        assert codiceFiscaleTxt != null : "fx:id=\"codiceFiscaleTxt\" was not injected: check your FXML file 'CodiceFiscale.fxml'.";

    }
}
