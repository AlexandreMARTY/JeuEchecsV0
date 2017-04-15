package modelisation.pieces;

import modelisation.plateau.*;

/**
 * Cette classe abstraite est étendue par tous les types de pièces. Elle est censée dicter l'implémentation d'une fonction
 * MaJRayonAction actualisant le rayon d'action de la pièce en fonction des données de l'échiquier de jeu.
 * Chaque pièce d'échec est représenté par som nom, son rayon d'action (un échiquier renouvelé à chaque mise à jour, 
 * un emplacement de départ (une case) et une couleur (NOIR ou BLANC).
 * 
 * A chaque mise à jour, un nouvel échiquier est créé. ce point sera à améliorer dans une version plus aboutie.
 * 
 * @author Alexandre
 */
public abstract class Piece {
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private String nomPiece; //Le nom de la pièce
	private Couleur couleurPiece;//La couleur de la pièce 
	
	private Case emplacement; //La case de départ de la pièce
	
	private Echiquier rayonAction;
	//L'échiquier repésentant la rayon d'action de la pièce. Pour chaque case atteignable, le boolean atteignable de cette case sur 
	//rayonAction est initialisé à true. false sinon
	
/////////////////////////////////////////Fonctions Concrètes////////////////////////////////////////////
	/**
	 * getter du nom de la pièce 
	 * @return le nom de la pièce
	 */
	public String getNomPiece() {
		return nomPiece;
	}

	/**
	 * getter de la couleur de la pièce
	 * @return la couleur de la pièce
	 */
	public Couleur getCouleurPiece() {
		return couleurPiece;
	}
	
	/**
	 * retourne la case d'emplacement de la pièce
	 * @return la case d'emplacement de la pièce
	 */
	public Case getEmplacement() {
		return emplacement;
	}

	/**
	 * Initialise la case d'emplacement de la pièce (à la suite d'un déplacement)
	 * @param emplacement
	 */
	public void setEmplacement(Case emplacement) {
		this.emplacement = emplacement;
	}

	/**
	 * Retourne l'échiquier correspondant au rayon d'action de la pièce.
	 * @return l'échiquier correspondant au rayon d'action de la pièce 
	 */
	public Echiquier getRayonAction() {
		return rayonAction;
	}
	
	/**
	 * Cette prochaine fonction est censé dire si, pour une case donnée, elle est ou non dans le rayon d'action de la pièce 
	 * @param Case c à vérifier si elle est dans le rayon d'action de la pièce
	 * @return true si la case est dans le rayon d'action, sinon false
	 */
	public boolean isInRayonAction(Case c) {
		return this.getRayonAction().getCase(c.getCol(), c.getLig()).isAtteignable();
	}
	
/////////////////////////////////////////Fonctions Abstraites////////////////////////////////////////////
	/**
	 * 
	 * @param plateauJeu l'échiquier pris en argument est le plateau de jeu. En fonction du plateau de jeu, chaque pièce va appeler 
	 * cette fonction pour déterminer son nouveau rayon d'action. 
	 * @return void mais initialise un nouvel @Echiquier en instance de rayonAction
	 */
	public abstract void MaJRayonAction(Echiquier plateauJeu);
}
