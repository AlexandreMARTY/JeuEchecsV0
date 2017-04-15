package modelisation.pieces;

import modelisation.plateau.*;

/**
 * Cette classe abstraite est �tendue par tous les types de pi�ces. Elle est cens�e dicter l'impl�mentation d'une fonction
 * MaJRayonAction actualisant le rayon d'action de la pi�ce en fonction des donn�es de l'�chiquier de jeu.
 * Chaque pi�ce d'�chec est repr�sent� par som nom, son rayon d'action (un �chiquier renouvel� � chaque mise � jour, 
 * un emplacement de d�part (une case) et une couleur (NOIR ou BLANC).
 * 
 * A chaque mise � jour, un nouvel �chiquier est cr��. ce point sera � am�liorer dans une version plus aboutie.
 * 
 * @author Alexandre
 */
public abstract class Piece {
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private String nomPiece; //Le nom de la pi�ce
	private Couleur couleurPiece;//La couleur de la pi�ce 
	
	private Case emplacement; //La case de d�part de la pi�ce
	
	private Echiquier rayonAction;
	//L'�chiquier rep�sentant la rayon d'action de la pi�ce. Pour chaque case atteignable, le boolean atteignable de cette case sur 
	//rayonAction est initialis� � true. false sinon
	
/////////////////////////////////////////Fonctions Concr�tes////////////////////////////////////////////
	/**
	 * getter du nom de la pi�ce 
	 * @return le nom de la pi�ce
	 */
	public String getNomPiece() {
		return nomPiece;
	}

	/**
	 * getter de la couleur de la pi�ce
	 * @return la couleur de la pi�ce
	 */
	public Couleur getCouleurPiece() {
		return couleurPiece;
	}
	
	/**
	 * retourne la case d'emplacement de la pi�ce
	 * @return la case d'emplacement de la pi�ce
	 */
	public Case getEmplacement() {
		return emplacement;
	}

	/**
	 * Initialise la case d'emplacement de la pi�ce (� la suite d'un d�placement)
	 * @param emplacement
	 */
	public void setEmplacement(Case emplacement) {
		this.emplacement = emplacement;
	}

	/**
	 * Retourne l'�chiquier correspondant au rayon d'action de la pi�ce.
	 * @return l'�chiquier correspondant au rayon d'action de la pi�ce 
	 */
	public Echiquier getRayonAction() {
		return rayonAction;
	}
	
	/**
	 * Cette prochaine fonction est cens� dire si, pour une case donn�e, elle est ou non dans le rayon d'action de la pi�ce 
	 * @param Case c � v�rifier si elle est dans le rayon d'action de la pi�ce
	 * @return true si la case est dans le rayon d'action, sinon false
	 */
	public boolean isInRayonAction(Case c) {
		return this.getRayonAction().getCase(c.getCol(), c.getLig()).isAtteignable();
	}
	
/////////////////////////////////////////Fonctions Abstraites////////////////////////////////////////////
	/**
	 * 
	 * @param plateauJeu l'�chiquier pris en argument est le plateau de jeu. En fonction du plateau de jeu, chaque pi�ce va appeler 
	 * cette fonction pour d�terminer son nouveau rayon d'action. 
	 * @return void mais initialise un nouvel @Echiquier en instance de rayonAction
	 */
	public abstract void MaJRayonAction(Echiquier plateauJeu);
}
