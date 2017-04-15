package modelisation.pieces;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

/**
 * Cette classe �tend la superclasse Piece. Elle mod�lise les dames du jeu.
 * 
 * @author Alexandre
 */
public class Dame extends Piece {
/////////////////////////////////////////Attributs////////////////////////////////////////////
	// pas d'attriuts particuliers en plus
	
/////////////////////////////////////////Fonctions////////////////////////////////////////////
	public Echiquier premierRayonAction(Echiquier plateauJeu) {
		// TODO
		return null;
	}

/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Dame(String nomPiece, Couleur couleurPiece, Case emplacement) {
		super("Dame", couleurPiece, emplacement);
	}
}
