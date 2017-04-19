package modelisation.pieces;

import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class Pion extends Piece {

/////////////////////////////////////////Attributs////////////////////////////////////////////
	private boolean EPg; //indique si la prise en passant à gauche (point de vue des blancs) est possible
	private boolean EPd; //indique si la prise en passant à droite (point de vue des blancs) est possible
	private boolean aJusteBouge; //indique si le pion vient juste de bouger ou non 
	private boolean premierPas; //indique si le pion a déjà bougé ou non (false si a déjà bougé, true sinon)
	

	/**
	 * Cette méthode renvoie le premier rayon d'action du pion, incluant une éventuelle prise en passant
	 * un pion ne peut pas reculer, il y a donc une différence de déplacement entre les pions noirs et blancs
	 * Les pions ne mangent pas de la même manière qu'ils avancent, il faut donc distinguer un certain nmbre de points
	 * Cette méthode renvoie l'échiquier du premier rayon d'action du pion
	 * @tested
	 */
	//protected
	public Echiquier premierRayonAction(Echiquier plateauJeu) {
		Echiquier premierrayonaction = new Echiquier();
		if (this.getCouleurPiece() == Couleur.BLANC) {
			Case emplacementplateaujeu = plateauJeu.getCase(this.getEmplacement().getCol(), this.getEmplacement().getLig());
			Case devant = plateauJeu.getCase(emplacementplateaujeu.getCol(), emplacementplateaujeu.getLig()+1);
			Case deuxdevant = plateauJeu.getCase(emplacementplateaujeu.getCol(), emplacementplateaujeu.getLig()+2);
			if (devant.OccupeePar() == null) {
				premierrayonaction.getCase(devant.getCol(), devant.getLig()).setAtteignable(true);
				if (premierPas && deuxdevant.OccupeePar() == null) {
					premierrayonaction.getCase(deuxdevant.getCol(), deuxdevant.getLig()).setAtteignable(true);
				}
			}
			if (Case.isValid(emplacementplateaujeu.getCol()-1, emplacementplateaujeu.getLig()+1)) {
				Case diaggauche = plateauJeu.getCase(emplacementplateaujeu.getCol()-1, emplacementplateaujeu.getLig()+1);
				if ((diaggauche.OccupeePar() != null && diaggauche.OccupeePar().getCouleurPiece() == Couleur.NOIR) || this.EPg) {
					premierrayonaction.getCase(diaggauche.getCol(), diaggauche.getLig()).setAtteignable(true);
				}
			}
			if (Case.isValid(emplacementplateaujeu.getCol()+1, emplacementplateaujeu.getLig()+1)) {
				Case diagdroit = plateauJeu.getCase(emplacementplateaujeu.getCol()+1, emplacementplateaujeu.getLig()+1);
				if ((diagdroit.OccupeePar() != null && diagdroit.OccupeePar().getCouleurPiece() == Couleur.NOIR) || this.EPd) {
					premierrayonaction.getCase(diagdroit.getCol(), diagdroit.getLig()).setAtteignable(true);
				}
			}
		}
		else {
			Case emplacementplateaujeu = plateauJeu.getCase(this.getEmplacement().getCol(), this.getEmplacement().getLig());
			Case devant = plateauJeu.getCase(emplacementplateaujeu.getCol(), emplacementplateaujeu.getLig()-1);
			Case deuxdevant = plateauJeu.getCase(emplacementplateaujeu.getCol(), emplacementplateaujeu.getLig()-2);
			if (devant.OccupeePar() == null) {
				premierrayonaction.getCase(devant.getCol(), devant.getLig()).setAtteignable(true);
				if (premierPas && deuxdevant.OccupeePar() == null) {
					premierrayonaction.getCase(deuxdevant.getCol(), deuxdevant.getLig()).setAtteignable(true);
				}
			}
			if (Case.isValid(emplacementplateaujeu.getCol()-1, emplacementplateaujeu.getLig()-1)) {
				Case diaggauche = plateauJeu.getCase(emplacementplateaujeu.getCol()-1, emplacementplateaujeu.getLig()-1);
				if ((diaggauche.OccupeePar() != null && diaggauche.OccupeePar().getCouleurPiece() == Couleur.BLANC) || this.EPg) {
					premierrayonaction.getCase(diaggauche.getCol(), diaggauche.getLig()).setAtteignable(true);
				}
			}
			if (Case.isValid(emplacementplateaujeu.getCol()+1, emplacementplateaujeu.getLig()-1)) {
				Case diagdroit = plateauJeu.getCase(emplacementplateaujeu.getCol()+1, emplacementplateaujeu.getLig()-1);
				if ((diagdroit.OccupeePar() != null && diagdroit.OccupeePar().getCouleurPiece() == Couleur.BLANC) || this.EPd) {
					premierrayonaction.getCase(diagdroit.getCol(), diagdroit.getLig()).setAtteignable(true);
				}
			}
		} 
		return premierrayonaction;
	}
	
	/**
	 * renvoie si le pion n'a pas encore bougé ou non
	 * @return
	 * @tested
	 */
	public boolean PremierPas() {
		return premierPas;
	}

	/**
	 * initialise si oui ou non le pion s'est déjà déplacé
	 * @param premierPas
	 * @tested
	 */
	public void setPremierPas(boolean premierPas) {
		this.premierPas = premierPas;
	}

	/**
	 * retorune le boolean EPg
	 * @tested
	 * @return
	 */
	public boolean EPg() {
		return EPg;
	}
	
	/**
	 * initialise le boolean EPg 
	 * @tested
	 * @param ePg
	 */
	public void setEPg(boolean ePg) {
		EPg = ePg;
	}
	
	/**
	 * Détermine si les conditions sont réunies pour exécuter la prisen en passant à gauche
	 * @param plateauJeu
	 * @param aPrendre
	 * @return
	 * @tested
	 */
	public
	//private
	boolean EPg(Echiquier plateauJeu, Pion aPrendre) {
		if (this.getCouleurPiece() == Couleur.BLANC) {
			if (this.getEmplacement().getLig() == 4) {
				if (plateauJeu.getCase(this.getEmplacement().getCol()-1, this.getEmplacement().getLig()).OccupeePar() == aPrendre 
						&& aPrendre.aJusteBouge()) {
					return true;		
				}
			}
		}
		if (this.getCouleurPiece() == Couleur.NOIR) {
			if (this.getEmplacement().getLig() == 3) {
				if (plateauJeu.getCase(this.getEmplacement().getCol()-1, this.getEmplacement().getLig()).OccupeePar() == aPrendre 
						&& aPrendre.aJusteBouge()) {
					return true;		
				}
			}
		}
		return false;
	}

	/**
	 * retorune le boolean EPd
	 * @tested
	 * @return
	 */
	public boolean EPd() {
		return EPd;
	}

	/**
	 * initialise le boolean EPd 
	 * @tested
	 * @param ePd
	 */
	public void setEPd(boolean ePd) {
		EPd = ePd;
	}
	
	/**
	 * Détermine si les conditions sont réunies pour exécuter la prise en passant à droite
	 * @param plateauJeu
	 * @param aPrendre
	 * @return
	 * @tested
	 */
	public
	//private
	boolean EPd(Echiquier plateauJeu, Pion aPrendre) {
		if (this.getCouleurPiece() == Couleur.BLANC) {
			if (this.getEmplacement().getLig() == 4) {
				if (plateauJeu.getCase(this.getEmplacement().getCol()+1, this.getEmplacement().getLig()).OccupeePar() == aPrendre 
						&& aPrendre.aJusteBouge()) {
					return true;		
				}
			}
		}
		if (this.getCouleurPiece() == Couleur.NOIR) {
			if (this.getEmplacement().getLig() == 3) {
				if (plateauJeu.getCase(this.getEmplacement().getCol()+1, this.getEmplacement().getLig()).OccupeePar() == aPrendre 
						&& aPrendre.aJusteBouge()) {
					return true;		
				}
			}
		}
		return false;
	}
	
	/**
	 * indique si le pion vient juste de bouger ou non 
	 * @return
	 * @tested
	 */
	public boolean aJusteBouge() {
		return aJusteBouge;
	}

	/**
	 * initialise l'information du pion s'il vient juste de bouger ou non)
	 * @param aBouge
	 * @tested
	 */
	public void setaJusteBouge(boolean aBouge) {
		this.aJusteBouge = aBouge;
	}



	/////////////////////////////////////////Constructeur////////////////////////////////////////////
	public Pion(Couleur couleurPiece, Case emplacement) {
		super("Pion", couleurPiece, emplacement);
		this.EPg = false;
		this.EPd = false;
		this.aJusteBouge = false;
		this.premierPas = true;
	}
}
