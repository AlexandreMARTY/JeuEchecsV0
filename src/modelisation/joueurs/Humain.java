package modelisation.joueurs;

import java.util.List;

import modelisation.pieces.Piece;
import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class Humain implements Joueur {
	
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private Couleur couleurJoueur; //La couleur du joueur (d�finit la couleur de ces pi�ces)
	private List<Piece> armee; //Son arm�e de pi�ces
	
	
/////////////////////////////////////////Getters et Setters////////////////////////////////////////////
	
	public Couleur getCouleurJoueur() {
		return couleurJoueur;
	}
	
	public void setCouleurJoueur(Couleur couleurJoueur) {
		this.couleurJoueur = couleurJoueur;
	}
	
	public List<Piece> getArmee() {
		return armee;
	}
	
	public void setArmee(List<Piece> armee) {
		this.armee = armee;
	}
	
/////////////////////////////////////////Fonctions Interface////////////////////////////////////////////
	
	public boolean deplace(Piece piece, Case arrivee, Echiquier plateauJeu) {
		if (piece.CaseInRayonAction(arrivee)) {
			piece.setEmplacement(arrivee);
			arrivee.setOccupeePar(piece);
			return true;
		}
		return false;
	}	
}
