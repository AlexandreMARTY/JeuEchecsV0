package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelisation.joueurs.Humain;
import modelisation.joueurs.Joueur;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

/////////////////////////////////////////Attributs////////////////////////////////////////////
	private Joueur joueurblanc;
	private Joueur joueurnoir;
	private Echiquier plateuJeu;
	
	private boolean Jouejoueurblanc;
	private boolean Jouejoueurnoir;
	
	private Stage primarystage;
	
	
/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Main() {
		this.plateuJeu = new Echiquier();
		this.joueurblanc = new Humain(Couleur.BLANC, this.plateuJeu);
		this.joueurnoir = new Humain(Couleur.NOIR, this.plateuJeu);
		this.Jouejoueurblanc = true;
		this.Jouejoueurnoir = false;
	}
	
/////////////////////////////////////////Getters////////////////////////////////////////////
	
	public boolean isJouejoueurblanc() {
		return Jouejoueurblanc;
	}

	public void setJouejoueurblanc(boolean jouejoueurblanc) {
		Jouejoueurblanc = jouejoueurblanc;
	}

	public boolean isJouejoueurnoir() {
		return Jouejoueurnoir;
	}

	public void setJouejoueurnoir(boolean jouejoueurnoir) {
		Jouejoueurnoir = jouejoueurnoir;
	}

	public Joueur getJoueurblanc() {
		return joueurblanc;
	}

	public Joueur getJoueurnoir() {
		return joueurnoir;
	}

	public Echiquier getPlateuJeu() {
		return plateuJeu;
	}
	
/////////////////////////////////////////Mise en relation avec l'interface////////////////////////////////////////////
	 public void initRootLayout() {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("IHM/PlateauJeu.fxml"));
	            BorderPane rootLayout = (BorderPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primarystage.setScene(scene);
	            primarystage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	
/////////////////////////////////////////fonction de lancement////////////////////////////////////////////
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		launch(args);
	}
}
