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
	/**
	 * (public pour les tests)
	 * cette fonction est censé renvoyer le premier rayon d'action du fou en 
	 * tenant compte des emplacements des autres pièces sur le jeu
	 * @tested
	 */
	public
	//protected
	Echiquier premierRayonAction(Echiquier plateauJeu) {
		Echiquier premierrayonaction = new Echiquier();
		List<List<Case>> diagonales = diagonalesVides(this.getEmplacement());
		for (List<Case> diag : diagonales) {
			if (diag.size()>0) {
				boolean porteevalide = true;
				for (Case c : diag) {
					Case caseplateau = plateauJeu.getCase(c.getCol(), c.getLig());
					if (porteevalide == true && caseplateau.OccupeePar() == null) {
						premierrayonaction.getCase(caseplateau.getCol(), caseplateau.getLig()).setAtteignable(true);
					}
					else if (porteevalide == true && caseplateau.OccupeePar().getCouleurPiece() != this.getCouleurPiece()) {
						premierrayonaction.getCase(caseplateau.getCol(), caseplateau.getLig()).setAtteignable(true);
						porteevalide = false;
					}
					else {
						porteevalide = false;
					}
				}
			}
		}
		return premierrayonaction;
	}
	
	/**
	 * Cette fonction annexe renvoie les diagonales vides du fou selon cette ordre : bas-gauche, haut-gauche, bas-droit, haut-droit
	 * @param emplacement
	 * @return Une liste de List<Case> correspondant aux cases disponibles dans chacune des diagonales
	 * @tested
	 */
	public
//private 
	List<List<Case>> diagonalesVides(Case emplacement) {
		List<List<Case>> diagonalesvides = new ArrayList<List<Case>>();
		List<Case> diagHautGauche = new ArrayList<Case>();
		List<Case> diagHautDroit  = new ArrayList<Case>();
		List<Case> diagBasGauche  = new ArrayList<Case>();
		List<Case> diagBasDroit   = new ArrayList<Case>();
		int col = emplacement.getCol(); int lig = emplacement.getLig();
		for (int z = 1; z<=7; z++) {
			if (Case.isValid(col-z, lig+z)) {
				diagHautGauche.add(new Case(col-z, lig+z));
			}
			if (Case.isValid(col+z, lig+z)) {
			diagHautDroit.add(new Case(col+z, lig+z));
			}
			if (Case.isValid(col-z, lig-z)) {
			diagBasGauche.add(new Case(col-z, lig-z));
			}
			if (Case.isValid(col+z, lig-z)) {
			diagBasDroit.add(new Case(col+z, lig-z));
			}
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
