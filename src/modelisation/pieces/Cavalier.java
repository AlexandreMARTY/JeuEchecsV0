package modelisation.pieces;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

/**
 * Cette classe �tend la superclasse Piece. Elle mod�lise les cavaliers du jeu.
 * 
 * @author Alexandre
 */
public class Cavalier extends Piece {
/////////////////////////////////////////Attributs////////////////////////////////////////////
	// pas d'attriuts particuliers en plus
	
/////////////////////////////////////////Fonctions////////////////////////////////////////////
	public Echiquier premierRayonAction(Echiquier plateauJeu) {
		// TODO
		return null;
	}

/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Cavalier(String nomPiece, Couleur couleurPiece, Case emplacement) {
		super("Cavalier", couleurPiece, emplacement);
	}
}
