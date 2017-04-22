package modelisation.joueurs;

import java.util.ArrayList;
import java.util.List;

import modelisation.pieces.Cavalier;
import modelisation.pieces.Dame;
import modelisation.pieces.Fou;
import modelisation.pieces.Piece;
import modelisation.pieces.Pion;
import modelisation.pieces.Roi;
import modelisation.pieces.Tour;
import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class Humain implements Joueur {
	
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private Couleur couleurJoueur; //La couleur du joueur (définit la couleur de ces pièces)
	private List<Piece> armee; //Son armée de pièces
	
	
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
	
/////////////////////////////////////////Constructeur////////////////////////////////////////////

	public Humain(Couleur couleurJoueur, Echiquier plateauJeu) {
		if (couleurJoueur == Couleur.BLANC) {
			this.couleurJoueur = couleurJoueur;
			//création de pions
			Pion piona2 = new Pion(couleurJoueur, plateauJeu.getCase(0, 1));
			Pion pionb2 = new Pion(couleurJoueur, plateauJeu.getCase(1, 1));
			Pion pionc2 = new Pion(couleurJoueur, plateauJeu.getCase(2, 1));
			Pion piond2 = new Pion(couleurJoueur, plateauJeu.getCase(3, 1));
			Pion pione2 = new Pion(couleurJoueur, plateauJeu.getCase(4, 1));
			Pion pionf2 = new Pion(couleurJoueur, plateauJeu.getCase(5, 1));
			Pion piong2 = new Pion(couleurJoueur, plateauJeu.getCase(6, 1));
			Pion pionh2 = new Pion(couleurJoueur, plateauJeu.getCase(7, 1));
			
			//création des tours
			Tour toura1 = new Tour(couleurJoueur, plateauJeu.getCase(0, 0));
			Tour tourh1 = new Tour(couleurJoueur, plateauJeu.getCase(7, 0));
			
			//creation des cavaliers
			Cavalier cavalierb1 = new Cavalier(couleurJoueur, plateauJeu.getCase(1, 0));
			Cavalier cavalierg1 = new Cavalier(couleurJoueur, plateauJeu.getCase(6, 0));
			
			//création des fous
			Fou fouc1 = new Fou(couleurJoueur, plateauJeu.getCase(2, 0));
			Fou fouf1 = new Fou(couleurJoueur, plateauJeu.getCase(5, 0));
			
			//création de la dame
			Dame damed1 = new Dame(couleurJoueur, plateauJeu.getCase(3, 0));
			
			//création du roi
			Roi roie1 = new Roi(couleurJoueur, plateauJeu.getCase(4, 0));
			
			//création de la liste et ajout des pièces 
			this.armee = new ArrayList<Piece>();
			this.armee.add(roie1); this.armee.add(damed1); this.armee.add(toura1); this.armee.add(tourh1); this.armee.add(fouc1);
			this.armee.add(fouf1); this.armee.add(cavalierb1); this.armee.add(cavalierg1); this.armee.add(piona2); this.armee.add(pionb2);
			this.armee.add(pionc2); this.armee.add(piond2); this.armee.add(pione2); this.armee.add(pionf2); this.armee.add(piong2); this.armee.add(pionh2);
		}
			
		if (couleurJoueur == Couleur.NOIR) {
			this.couleurJoueur = couleurJoueur;
			//création de pions
			Pion piona7 = new Pion(couleurJoueur, plateauJeu.getCase(0, 6));
			Pion pionb7 = new Pion(couleurJoueur, plateauJeu.getCase(1, 6));
			Pion pionc7 = new Pion(couleurJoueur, plateauJeu.getCase(2, 6));
			Pion piond7 = new Pion(couleurJoueur, plateauJeu.getCase(3, 6));
			Pion pione7 = new Pion(couleurJoueur, plateauJeu.getCase(4, 6));
			Pion pionf7 = new Pion(couleurJoueur, plateauJeu.getCase(5, 6));
			Pion piong7 = new Pion(couleurJoueur, plateauJeu.getCase(6, 6));
			Pion pionh7 = new Pion(couleurJoueur, plateauJeu.getCase(7, 6));
			
			//création des tours
			Tour toura8 = new Tour(couleurJoueur, plateauJeu.getCase(0, 7));
			Tour tourh8 = new Tour(couleurJoueur, plateauJeu.getCase(7, 7));
			
			//creation des cavaliers
			Cavalier cavalierb8 = new Cavalier(couleurJoueur, plateauJeu.getCase(1, 7));
			Cavalier cavalierg8 = new Cavalier(couleurJoueur, plateauJeu.getCase(6, 7));
			
			//création des fous
			Fou fouc8 = new Fou(couleurJoueur, plateauJeu.getCase(2, 7));
			Fou fouf8 = new Fou(couleurJoueur, plateauJeu.getCase(5, 7));
			
			//création de la dame
			Dame damed8 = new Dame(couleurJoueur, plateauJeu.getCase(3, 7));
			
			//création du roi
			Roi roie8 = new Roi(couleurJoueur, plateauJeu.getCase(4, 7));
			
			//création de la liste et ajout des pièces 
			this.armee = new ArrayList<Piece>();
			this.armee.add(roie8); this.armee.add(damed8); this.armee.add(toura8); this.armee.add(tourh8); this.armee.add(fouc8);
			this.armee.add(fouf8); this.armee.add(cavalierb8); this.armee.add(cavalierg8); this.armee.add(piona7); this.armee.add(pionb7);
			this.armee.add(pionc7); this.armee.add(piond7); this.armee.add(pione7); this.armee.add(pionf7); this.armee.add(piong7); this.armee.add(pionh7);
		}		
	}
}
