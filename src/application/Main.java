package application;
	
import javafx.application.Application;
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
	
	
/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Main() {
		this.plateuJeu = new Echiquier();
		this.joueurblanc = new Humain(Couleur.BLANC, this.plateuJeu);
		this.joueurnoir = new Humain(Couleur.NOIR, this.plateuJeu);
	}
	
/////////////////////////////////////////Getters////////////////////////////////////////////
	
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
	
	
	
/////////////////////////////////////////fonction de lancement////////////////////////////////////////////
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		launch(args);
	}
}
