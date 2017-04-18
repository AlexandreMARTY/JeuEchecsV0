package modelisation.pieces;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

/**
 * Cette classe étend la superclasse Piece. Elle modélise les cavaliers du jeu.
 * 
 * @author Alexandre
 */
public class Cavalier extends Piece {
/////////////////////////////////////////Attributs////////////////////////////////////////////
	// pas d'attriuts particuliers en plus
	
/////////////////////////////////////////Fonctions////////////////////////////////////////////
	
	/**
	 * cette fonction renvoie le premier rayon d'action du cavalier, c'est à dire le rayon d'action 
	 * tenant compte des pièces sur l'échiquier mais pas des mises en échec de son propre roi
	 * @tested
	 */
	public
	//protected
	Echiquier premierRayonAction(Echiquier plateauJeu) {
		Echiquier premierrayonaction = new Echiquier();
		Case c = this.getEmplacement();
		//on teste les 8 cases possibles
		if (CaseAPortee(c.getCol()-2, c.getLig()-1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()-2, c.getLig()-1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()-2, c.getLig()+1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()-2, c.getLig()+1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()-1, c.getLig()+2, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()-1, c.getLig()+2).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()+1, c.getLig()+2, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()+1, c.getLig()+2).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()+2, c.getLig()+1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()+2, c.getLig()+1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()+2, c.getLig()-1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()+2, c.getLig()-1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()+1, c.getLig()-2, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()+1, c.getLig()-2).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()-1, c.getLig()-2, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()-1, c.getLig()-2).setAtteignable(true);
		}
		return premierrayonaction;
	}

	/**
	 * Pour le cavalier, une particularité est de tester les cases une à une. La méthode ci dessous permet de factoriser le code. 
	 * @tested
	 * @param col
	 * @param lig
	 * @param plateauJeu
	 * @return
	 */
//public
private 
boolean CaseAPortee(int col, int lig, Echiquier plateauJeu) {
	if (Case.isValid(col, lig)) {
		return ((plateauJeu.getCase(col, lig).OccupeePar() == null) 
				|| (plateauJeu.getCase(col, lig).OccupeePar().getCouleurPiece() != this.getCouleurPiece()));
		}
	else {
		return false;
	}
}

/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Cavalier(String nomPiece, Couleur couleurPiece, Case emplacement) {
		super("Cavalier", couleurPiece, emplacement);
	}
}
