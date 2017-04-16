package modelisation.pieces;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

/**
 * Cette classe �tend la superclasse Piece. Elle mod�lise les fous du jeu.
 * 
 * @author Alexandre
 */
public class Fou extends Piece {
/////////////////////////////////////////Attributs////////////////////////////////////////////
	// pas d'attriuts particuliers en plus
	
/////////////////////////////////////////Fonctions////////////////////////////////////////////
	protected Echiquier premierRayonAction(Echiquier plateauJeu) {
		// TODO
		return null;
	}

/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Fou(String nomPiece, Couleur couleurPiece, Case emplacement) {
		super("Fou", couleurPiece, emplacement);
	}
}
