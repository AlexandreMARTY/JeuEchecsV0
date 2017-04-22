package modelisation.pieces;

import modelisation.plateau.*;

/**
 * Cette classe abstraite est étendue par tous les types de pièces. Elle est censée dicter l'implémentation d'une fonction
 * MaJRayonAction actualisant le rayon d'action de la pièce en fonction des données de l'échiquier de jeu.
 * Chaque pièce d'échec est représenté par som nom, son rayon d'action (un échiquier renouvelé à chaque mise à jour, 
 * un emplacement de départ (une case) et une couleur (NOIR ou BLANC).
 * 
 * A chaque mise à jour, un nouvel échiquier est créé. ce point sera à améliorer dans une version plus aboutie.
 * 
 * @author Alexandre
 */
public abstract class Piece {
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private String nomPiece; //Le nom de la pièce
	private Couleur couleurPiece;//La couleur de la pièce 
	
	private Case emplacement; //La case de départ de la pièce. Si null ça veut dire que la pièce n'existe plus
	
	private Echiquier rayonAction;
	//L'échiquier repésentant la rayon d'action de la pièce. Pour chaque case atteignable, le boolean atteignable de cette case sur 
	//rayonAction est initialisé à true. false sinon
	
/////////////////////////////////////////Fonctions Concrètes////////////////////////////////////////////
	/**
	 * getter du nom de la pièce 
	 * @return le nom de la pièce @tested 
	 */
	public String getNomPiece() {
		return nomPiece;
	}

	/**
	 * getter de la couleur de la pièce
	 * @return la couleur de la pièce @tested
	 */
	public Couleur getCouleurPiece() {
		return couleurPiece;
	}
	
	/**
	 * retourne la case d'emplacement de la pièce
	 * @return la case d'emplacement de la pièce @tested
	 */
	public Case getEmplacement() {
		return emplacement;
	}

	/**
	 * Initialise la case d'emplacement de la pièce (à la suite d'un déplacement) @tested
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
	 * Cette fonction elimine juste la pièce du jeu. Elle est encore conservée dan la mémoire de l'ordinateur mais elle n'est plus
	 * à considérer @tested
	 */
	public void erase() {
		this.couleurPiece = null;
		this.emplacement = null;
		this.rayonAction = null;
		this.nomPiece = "erase";
	}

	/**
	 * Retourne l'échiquier correspondant au rayon d'action de la pièce.
	 * @return l'échiquier correspondant au rayon d'action de la pièce @tested
	 */
	public Echiquier getRayonAction() {
		return rayonAction;
	}
	
	/**
	 * Cette prochaine fonction est censé dire si, pour une case donnée, elle est ou non dans le rayon d'action de la pièce 
	 * @param Case c à vérifier si elle est dans le rayon d'action de la pièce
	 * @return true si la case est dans le rayon d'action, sinon false @tested
	 */
	public boolean CaseInRayonAction(Case c) {
		return this.getRayonAction().getCase(c.getCol(), c.getLig()).isAtteignable();
	}
	
	/**
	 * Uniquement pour les tests de isInRayonAction, voici une fonction pour initier un rayon d'action à une pièce @tested
	 */
	public void setRayonAction(Echiquier e) {
		this.rayonAction = e;
	}
	
	/**
	 * Cette fonction met à jour l'instance de rayon d'action de la pièce considérée en prenant en compte le statut
	 * de son roi (echec ou pas) qu'entraineraît son déplacement @tobetested !
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
					this.setEmplacement(aEtudierPlateau); // on déplace la pièce concernée
					for (int col1 = 0; col1<8; col1++) {
						for (int lig1 = 0; lig1<8; lig1++) { // Et ensuite pour chaque pièce ennemie du plateau
							if (plateauJeu.getCase(col1, lig1).OccupeePar() != null && 
									plateauJeu.getCase(col1, lig1).OccupeePar().getCouleurPiece() != this.getCouleurPiece()) {
								Echiquier premierRayonActionAdv = plateauJeu.getCase(col1, lig1).
										OccupeePar().premierRayonAction(plateauJeu); //On calcule son rayon d'action
								for (int col2 = 0; col2<8; col2++) {
									for (int lig2 = 0; lig2<8; lig2++) { //Pour chaque case du rayon d'action calculé
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
					this.setEmplacement(memoirecasedepart); //On remet tout à sa place 
				}
			}		
		}
		this.rayonAction = nouveauRayonAction;
	}
	
/////////////////////////////////////////Fonctions Abstraites////////////////////////////////////////////
	/**
	 * 
	 * @param plateauJeu l'échiquier pris en argument est le plateau de jeu. En fonction du plateau de jeu, chaque pièce va appeler 
	 * cette fonction pour déterminer son nouveau premier rayon d'action SI LE ROI POUVAIT ETRE LAISSE EN ECHEC
	 * @return void mais initialise un nouvel @Echiquier en instance de rayonAction
	 */
	protected abstract Echiquier premierRayonAction(Echiquier plateauJeu);
	
/////////////////////////////////////////Constructeurs////////////////////////////////////////////
	/**
	 * Le constructeur d'une pièce @tested
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
