package modelisation.pieces;

import java.util.ArrayList;
import java.util.List;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

/**
 * Cette classe étend la superclasse Piece. Elle modélise les dames du jeu.
 * 
 * @author Alexandre
 */
public class Dame extends Piece {
/////////////////////////////////////////Attributs////////////////////////////////////////////
	// pas d'attriuts particuliers en plus
	
/////////////////////////////////////////Fonctions////////////////////////////////////////////
	
	/**
	 * Cette fonction renvoie la portee de la dame, en utilisant la même démarche que pour le fou
	 */
	public
	//protected
	Echiquier premierRayonAction(Echiquier plateauJeu) {
		Echiquier premierrayonaction = new Echiquier();
		List<List<Case>> diagonales = diagonalesVides(this.getEmplacement());
		List<List<Case>> rangees = rangeesVides(this.getEmplacement());
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
		for (List<Case> rang : rangees) {
			if (rang.size()>0) {
				boolean porteevalide = true;
				for (Case c : rang) {
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
	 * @return
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
		for (int z = 1; z<7; z++) {
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
	
	/**
	 * Cette fonction annexe renvoie les rangées vides de la dame selon cette ordre : gauche, haut, bas, droit
	 * @param emplacement
	 * @return
	 * @tested
	 */
	public
//private 
	List<List<Case>> rangeesVides(Case emplacement) {
		List<List<Case>> rangeesvides = new ArrayList<List<Case>>();
		List<Case> rangHautGauche = new ArrayList<Case>();
		List<Case> rangHautDroit  = new ArrayList<Case>();
		List<Case> rangBasGauche  = new ArrayList<Case>();
		List<Case> rangBasDroit   = new ArrayList<Case>();
		int col = emplacement.getCol(); int lig = emplacement.getLig();
		for (int z = 1; z<7; z++) {
			if (Case.isValid(col-z, lig+z)) {
				rangHautGauche.add(new Case(col-z, lig+z));
			}
			if (Case.isValid(col+z, lig+z)) {
			rangHautDroit.add(new Case(col+z, lig+z));
			}
			if (Case.isValid(col-z, lig-z)) {
			rangBasGauche.add(new Case(col-z, lig-z));
			}
			if (Case.isValid(col+z, lig-z)) {
			rangBasDroit.add(new Case(col+z, lig-z));
			}
		}
		rangeesvides.add(rangBasGauche);
		rangeesvides.add(rangHautGauche);
		rangeesvides.add(rangBasDroit);
		rangeesvides.add(rangHautDroit);
		return rangeesvides;
	}

/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Dame(String nomPiece, Couleur couleurPiece, Case emplacement) {
		super("Dame", couleurPiece, emplacement);
	}
}
