package modelisation.pieces;

import modelisation.plateau.*;

/**
 * Cette classe abstraite est �tendue par tous les types de pi�ces. Elle est cens�e dicter l'impl�mentation d'une fonction
 * MaJRayonAction actualisant le rayon d'action de la pi�ce en fonction des donn�es de l'�chiquier de jeu.
 * Chaque pi�ce d'�chec est repr�sent� par som nom, son rayon d'action (un �chiquier renouvel� � chaque mise � jour, 
 * un emplacement de d�part (une case) et une couleur (NOIR ou BLANC).
 * 
 * A chaque mise � jour, un nouvel �chiquier est cr��. ce point sera � am�liorer dans une version plus aboutie.
 * 
 * @author Alexandre
 */
public abstract class Piece {
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private String nomPiece; //Le nom de la pi�ce
	private Couleur couleurPiece;//La couleur de la pi�ce 
	
	private Case emplacement; //La case de d�part de la pi�ce. Si null �a veut dire que la pi�ce n'existe plus
	
	private Echiquier rayonAction;
	//L'�chiquier rep�sentant la rayon d'action de la pi�ce. Pour chaque case atteignable, le boolean atteignable de cette case sur 
	//rayonAction est initialis� � true. false sinon
	
/////////////////////////////////////////Fonctions Concr�tes////////////////////////////////////////////
	/**
	 * getter du nom de la pi�ce 
	 * @return le nom de la pi�ce @tested 
	 */
	public String getNomPiece() {
		return nomPiece;
	}

	/**
	 * getter de la couleur de la pi�ce
	 * @return la couleur de la pi�ce @tested
	 */
	public Couleur getCouleurPiece() {
		return couleurPiece;
	}
	
	/**
	 * retourne la case d'emplacement de la pi�ce
	 * @return la case d'emplacement de la pi�ce @tested
	 */
	public Case getEmplacement() {
		return emplacement;
	}

	/**
	 * Initialise la case d'emplacement de la pi�ce (� la suite d'un d�placement) @tested
	 * @param emplacement
	 */
	public void setEmplacement(Case arrivee) {
		if (arrivee.OccupeePar() == null) {
			this.emplacement.setOccupeePar(null);
			this.emplacement = arrivee;
			arrivee.setOccupeePar(this);
		}
		else {
			this.emplacement.setOccupeePar(null);
			this.emplacement = arrivee;
			arrivee.OccupeePar().erase();
			arrivee.setOccupeePar(this);
		}	
	}

	/**
	 * Cette fonction elimine juste la pi�ce du jeu. Elle est encore conserv�e dan la m�moire de l'ordinateur mais elle n'est plus
	 * � consid�rer @tested
	 */
	public void erase() {
		this.couleurPiece = null;
		this.emplacement = null;
		this.rayonAction = null;
		this.nomPiece = "erase";
	}

	/**
	 * Retourne l'�chiquier correspondant au rayon d'action de la pi�ce.
	 * @return l'�chiquier correspondant au rayon d'action de la pi�ce @tested
	 */
	public Echiquier getRayonAction() {
		return rayonAction;
	}
	
	/**
	 * Cette prochaine fonction est cens� dire si, pour une case donn�e, elle est ou non dans le rayon d'action de la pi�ce 
	 * @param Case c � v�rifier si elle est dans le rayon d'action de la pi�ce
	 * @return true si la case est dans le rayon d'action, sinon false @tested
	 */
	public boolean CaseInRayonAction(Case c) {
		return this.getRayonAction().getCase(c.getCol(), c.getLig()).isAtteignable();
	}
	
	/**
	 * Uniquement pour les tests de isInRayonAction, voici une fonction pour initier un rayon d'action � une pi�ce @tested
	 */
	public void setRayonAction(Echiquier e) {
		this.rayonAction = e;
	}
	
	/**
	 * Cette fonction met � jour l'instance de rayon d'action de la pi�ce consid�r�e en prenant en compte le statut
	 * de son roi (echec ou pas) qu'entrainera�t son d�placement @tobetested !
	 * @param plateauJeu
	 * @param roi
	 */
	public void nouveauRayonAction(Echiquier plateauJeu, Roi roi) {
		Echiquier premierRayonAction = premierRayonAction(plateauJeu);
		Echiquier nouveauRayonAction = Echiquier.copyEchiquier(premierRayonAction);
		for (int col = 0; col<8; col++) {
			for (int lig = 0; lig<8; lig++) { // On parcours le premier rayon d'action
				Case aEtudier = premierRayonAction.getCase(col, lig);
				Case aEtudierPlateau = plateauJeu.getCase(col, lig);
				if (aEtudier.isAtteignable()) {
					Case memoirecasedepart = this.getEmplacement();
					this.setEmplacement(aEtudierPlateau); // on d�place la pi�ce concern�e
					for (int col1 = 0; col1<8; col1++) {
						for (int lig1 = 0; lig1<8; lig1++) { // Et ensuite pour chaque pi�ce ennemie du plateau
							if (plateauJeu.getCase(col1, lig1).OccupeePar() != null && 
									plateauJeu.getCase(col1, lig1).OccupeePar().getCouleurPiece() != this.getCouleurPiece()) {
								Echiquier premierRayonActionAdv = plateauJeu.getCase(col1, lig1).
										OccupeePar().premierRayonAction(plateauJeu); //On calcule son rayon d'action
								for (int col2 = 0; col2<8; col2++) {
									for (int lig2 = 0; lig2<8; lig2++) { //Pour chaque case du rayon d'action calcul�
										if ((premierRayonActionAdv.getCase(col2, lig2).isAtteignable())
												&& (plateauJeu.getCase(col2, lig2).OccupeePar().equals(roi))) { //Si elle est atteignable
																												//et que notre roi est dedans
											nouveauRayonAction.getCase(col2, lig2).setAtteignable(false); //on elimine a case comme atteignable
										}
									}
								}
							}
						}
					}
					this.setEmplacement(memoirecasedepart); //On remet tout � sa place 
				}
			}		
		}
		this.rayonAction = nouveauRayonAction;
	}
	
/////////////////////////////////////////Fonctions Abstraites////////////////////////////////////////////
	/**
	 * 
	 * @param plateauJeu l'�chiquier pris en argument est le plateau de jeu. En fonction du plateau de jeu, chaque pi�ce va appeler 
	 * cette fonction pour d�terminer son nouveau premier rayon d'action SI LE ROI POUVAIT ETRE LAISSE EN ECHEC
	 * @return void mais initialise un nouvel @Echiquier en instance de rayonAction
	 */
	protected abstract Echiquier premierRayonAction(Echiquier plateauJeu);
	
/////////////////////////////////////////Constructeurs////////////////////////////////////////////
	/**
	 * Le constructeur d'une pi�ce @tested
	 * @param nomPiece
	 * @param couleurPiece
	 * @param emplacement
	 */
	public Piece(String nomPiece, Couleur couleurPiece, Case emplacement) { 
		this.nomPiece = nomPiece;
		this.couleurPiece = couleurPiece;
		this.emplacement = emplacement;
		this.emplacement.setOccupeePar(this);
	}
}
