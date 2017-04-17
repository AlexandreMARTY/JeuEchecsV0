package modelisation.pieces;

import java.util.ArrayList;
import java.util.List;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

/**
 * Cette classe étend la superclasse Piece. Elle modélise les fous du jeu.
 * 
 * @author Alexandre
 */
public class Fou extends Piece {
/////////////////////////////////////////Attributs////////////////////////////////////////////
	// pas d'attriuts particuliers en plus
	
/////////////////////////////////////////Fonctions////////////////////////////////////////////
	protected Echiquier premierRayonAction(Echiquier plateauJeu) {
		Echiquier premierrayonaction = new Echiquier();
		List<List<Case>> diagonales = diagonalesVides(this.getEmplacement());
		for (List<Case> diag : diagonales) {
			boolean porteevalide = true;
			for (Case c : diag) {
				if (c.OccupeePar() == null && porteevalide == true) {
					premierrayonaction.getCase(c.getCol(), c.getLig()).setAtteignable(true);
				}
				else if (c.OccupeePar().getCouleurPiece() != this.getCouleurPiece() && porteevalide == true) {
					premierrayonaction.getCase(c.getCol(), c.getLig()).setAtteignable(true);
					porteevalide = false;
				}
				else {
					porteevalide = false;
				}
			}
		}
		return premierrayonaction;
	}

private List<List<Case>> diagonalesVides(Case emplacement) {
		List<List<Case>> diagonalesvides = new ArrayList<List<Case>>();
		List<Case> diagHautGauche = new ArrayList<Case>();
		List<Case> diagHautDroit  = new ArrayList<Case>();
		List<Case> diagBasGauche  = new ArrayList<Case>();
		List<Case> diagBasDroit   = new ArrayList<Case>();
		int col = emplacement.getCol(); int lig = emplacement.getLig();
		for (int z = 0; z<7; z++) {
			diagHautGauche.add(new Case(col-z, lig+z));
			diagHautDroit.add(new Case(col+z, lig+z));
			diagBasGauche.add(new Case(col-z, lig-z));
			diagBasDroit.add(new Case(col+z, lig-z));
		}
		diagonalesvides.add(diagBasGauche);
		diagonalesvides.add(diagHautGauche);
		diagonalesvides.add(diagBasDroit);
		diagonalesvides.add(diagHautDroit);
		return diagonalesvides;
	}

	/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Fou(String nomPiece, Couleur couleurPiece, Case emplacement) {
		super("Fou", couleurPiece, emplacement);
	}
}
