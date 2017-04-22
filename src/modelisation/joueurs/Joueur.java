package modelisation.joueurs;

import modelisation.pieces.Piece;
import modelisation.plateau.Case;
import modelisation.plateau.Echiquier;

public interface Joueur {
	
	public boolean deplace(Piece piece, Case arrivee, Echiquier plateauJeu);

}
