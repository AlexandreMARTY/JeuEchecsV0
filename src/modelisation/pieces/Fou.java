package modelisation.pieces;

import java.util.ArrayList;
import java.util.List;

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
	/**
	 * cette fonction est cens� renvoyer le premier rayon d'action du fou en 
	 * tenant compte des emplacements des autres pi�ces sur le jeu
	 * @tobetested
	 */
	protected Echiquier premierRayonAction(Echiquier plateauJeu) {
		Echiquier premierrayonaction = new Echiquier();
		List<List<Case>> diagonales = diagonalesVides(this.getEmplacement());
		for (List<Case> diag : diagonales) {
			boolean porteevalide = true;
			for (Case c : diag) {
				Case caseplateau = plateauJeu.getCase(c.getCol(), c.getLig());
				if (caseplateau.OccupeePar() == null && porteevalide == true) {
					premierrayonaction.getCase(caseplateau.getCol(), caseplateau.getLig()).setAtteignable(true);
				}
				else if (caseplateau.OccupeePar().getCouleurPiece() != this.getCouleurPiece() && porteevalide == true) {
					premierrayonaction.getCase(caseplateau.getCol(), caseplateau.getLig()).setAtteignable(true);
					porteevalide = false;
				}
				else {
					porteevalide = false;
				}
			}
		}
		return premierrayonaction;
	}
	
	/**
	 * Cette fonction annexe renvoie les diagonales vides du fou selon cette ordre : bas-gauche, haut-gauche, bas-droit, haut-droit
	 * @param emplacement
	 * @return
	 * @tobetested
	 */
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
