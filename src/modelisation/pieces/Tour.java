package modelisation.pieces;

import java.util.ArrayList;
import java.util.List;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class Tour extends Piece{


/////////////////////////////////////////Attributs////////////////////////////////////////////
	private boolean aBouge; //indique si la tour a déjà bougé ou non
	
/////////////////////////////////////////Fonctions////////////////////////////////////////////
	public boolean aBouge() {
		return aBouge;
	}

	public void setaBouge(boolean aBouge) {
		this.aBouge = aBouge;
	}
	
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
		List<List<Case>> diagonales = rangeesVides(this.getEmplacement());
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
	 * Cette fonction annexe renvoie les rangées vides de la dame selon cette ordre : gauche, haut, bas, droit
	 * @param emplacement
	 * @return Une liste de List<Case> correspondant aux cases disponibles dans chacune des rangées
	 * @tested
	 */
	public
//private 
	List<List<Case>> rangeesVides(Case emplacement) {
		List<List<Case>> rangeesvides = new ArrayList<List<Case>>();
		List<Case> rangGauche = new ArrayList<Case>();
		List<Case> rangHaut  = new ArrayList<Case>();
		List<Case> rangBas = new ArrayList<Case>();
		List<Case> rangDroit   = new ArrayList<Case>();
		int col = emplacement.getCol(); int lig = emplacement.getLig();
		for (int z = 1; z<=7; z++) {
			if (Case.isValid(col-z, lig)) {
				rangGauche.add(new Case(col-z, lig));
			}
			if (Case.isValid(col, lig+z)) {
			rangHaut.add(new Case(col, lig+z));
			}
			if (Case.isValid(col, lig-z)) {
			rangBas.add(new Case(col, lig-z));
			}
			if (Case.isValid(col+z, lig)) {
			rangDroit.add(new Case(col+z, lig));
			}
		}
		rangeesvides.add(rangGauche);
		rangeesvides.add(rangHaut);
		rangeesvides.add(rangBas);
		rangeesvides.add(rangDroit);
		return rangeesvides;
	}

/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Tour(Couleur couleurPiece, Case emplacement) {
		super("Tour", couleurPiece, emplacement);
		this.aBouge = false;
	}
}
