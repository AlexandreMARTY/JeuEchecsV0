package modelisation.pieces;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class Roi extends Piece {
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private boolean peutPetitRoquer; //Indique si le roi peut petitRoquer ou non 
	private boolean peutGrandRoquer; //Indique si le roi peut grandRoquer ou non 
	private boolean aBouge; //Indique si le roi a bouge ou non

/////////////////////////////////////////Fonctions////////////////////////////////////////////

	/**
	 * cette fonction renvoie le premier rayon d'action du roi, c'est à dire le rayon d'action 
	 * tenant compte des pièces sur l'échiquier mais pas des mises en échec
	 * @tested
	 */
	public
	//protected
	Echiquier premierRayonAction(Echiquier plateauJeu) {
		Echiquier premierrayonaction = new Echiquier();
		if (peutPetitRoquer) {
			premierrayonaction.getCase(6, this.getEmplacement().getLig());
		}
		if (peutGrandRoquer) {
			premierrayonaction.getCase(2, this.getEmplacement().getLig());
		}
		Case c = this.getEmplacement();
		//on teste les 8 cases possibles
		if (CaseAPortee(c.getCol()-1, c.getLig()-1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()-1, c.getLig()-1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()-1, c.getLig(), plateauJeu)) {
			premierrayonaction.getCase(c.getCol()-1, c.getLig()).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()-1, c.getLig()+1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()-1, c.getLig()+1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol(), c.getLig()+1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol(), c.getLig()+1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()+1, c.getLig()+1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()+1, c.getLig()+1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()+1, c.getLig(), plateauJeu)) {
			premierrayonaction.getCase(c.getCol()+1, c.getLig()).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol()+1, c.getLig()-1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol()+1, c.getLig()-1).setAtteignable(true);
		}
		if (CaseAPortee(c.getCol(), c.getLig()-1, plateauJeu)) {
			premierrayonaction.getCase(c.getCol(), c.getLig()-1).setAtteignable(true);
			}
		return premierrayonaction;
	}

	/**
	 * getter du boolen indiquant que le roi peut faire le petit roque
	 * @return
	 */
	public boolean PeutPetitRoquer() {
		return peutPetitRoquer;
	}
	
	public void setPeutPetitRoquer(boolean b) {
		peutPetitRoquer = b;
	}

	/**
	 * Cette fonction détermine si le roi peut faire le petit roque. 
	 * Par la suite elle sera mise en private et incluse dans le setter
	 * @param plateauJeu
	 * @param tour
	 * @return
	 * @tobetested
	 */
	public boolean PeutPetitRoquer(Echiquier plateauJeu, Tour tour) {
		boolean result = true; //indique le résultat de l'analyse
		if (!aBouge) {
			if (plateauJeu.getCase(5, this.getEmplacement().getLig()).OccupeePar() == null 
					&& plateauJeu.getCase(6, this.getEmplacement().getLig()).OccupeePar() == null) {//trajet vide
				if (plateauJeu.getCase(7, this.getEmplacement().getLig()).OccupeePar().equals(tour) && !tour.aBouge()) {//Tour présente et n'a pas bougé
					for (int col1 = 0; col1<8; col1++) {
						for (int lig1 = 0; lig1<8; lig1++) { // Et ensuite pour chaque pièce ennemie du plateau
							if (plateauJeu.getCase(col1, lig1).OccupeePar() != null && 
									plateauJeu.getCase(col1, lig1).OccupeePar().getCouleurPiece() != this.getCouleurPiece()) {
								Echiquier premierRayonActionAdv = plateauJeu.getCase(col1, lig1).
										OccupeePar().premierRayonAction(plateauJeu); //On calcule son rayon d'action
								result = result&&((!premierRayonActionAdv.getCase(5, this.getEmplacement().getLig()).isAtteignable() ||  
										 !premierRayonActionAdv.getCase(6, this.getEmplacement().getLig()).isAtteignable()));
								//si une des cases de déplacement du roi est touché on le met à false.
								}
							}
						}
					return result;
					}
				}
			}
		return false;
		}


	/**
	 * getter du boolen indiquant que le roi peut faire le grand roque
	 * @return
	 */
	public boolean PeutGrandRoquer() {
		return peutGrandRoquer;
	}

	/**
	 * Cette fonction détermine si le roi peut faire le grand roque. 
	 * Par la suite elle sera mise en private et incluse dans le setter
	 * @param plateauJeu
	 * @param tour
	 * @return
	 * @tobetested
	 */
	public boolean PeutGrandRoquer(Echiquier plateauJeu, Tour tour) {
		boolean result = true; //indique le résultat de l'analyse
		if (!aBouge) {
			if (plateauJeu.getCase(3, this.getEmplacement().getLig()).OccupeePar() == null 
					&& plateauJeu.getCase(2, this.getEmplacement().getLig()).OccupeePar() == null 
						&& plateauJeu.getCase(1, this.getEmplacement().getLig()).OccupeePar() == null) {//trajet vide
				if (plateauJeu.getCase(0, this.getEmplacement().getLig()).OccupeePar().equals(tour) && !tour.aBouge()) {//Tour présente et n'a pas bougé
					for (int col1 = 0; col1<8; col1++) {
						for (int lig1 = 0; lig1<8; lig1++) { // Et ensuite pour chaque pièce ennemie du plateau
							if (plateauJeu.getCase(col1, lig1).OccupeePar() != null && 
									plateauJeu.getCase(col1, lig1).OccupeePar().getCouleurPiece() != this.getCouleurPiece()) {
								Echiquier premierRayonActionAdv = plateauJeu.getCase(col1, lig1).
										OccupeePar().premierRayonAction(plateauJeu); //On calcule son rayon d'action
								result = result&&((!premierRayonActionAdv.getCase(3, this.getEmplacement().getLig()).isAtteignable() ||  
										 !premierRayonActionAdv.getCase(2, this.getEmplacement().getLig()).isAtteignable()));
								//si une des cases de déplacement du roi est touché on le met à false.
								}
							}
						}
					return result;
					}
				}
			}
		return false;
		}
	
	public void setPeutGrandRoquer(boolean b) {
		peutPetitRoquer = b;
	}

	/**
	 * Pour le roi, comme pour le cavalier,, une particularité 
	 * est de tester les cases une à une. La méthode ci dessous permet de factoriser le code. 
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
	public Roi(String nomPiece, Couleur couleurPiece, Case emplacement) {
		super("Roi", couleurPiece, emplacement);
		this.peutPetitRoquer = false;
		this.peutGrandRoquer = false;
		this.aBouge = false;
	}
}
