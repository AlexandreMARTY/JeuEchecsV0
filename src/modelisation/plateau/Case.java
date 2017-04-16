package modelisation.plateau;

import modelisation.pieces.Piece;

/**
 * Cette classe représente les cases d'un échiquier. 
 * Une case est repéré par ses coordonnées (@int lig et @int col)
 * ainsi qu'une @Couleur (NOIR ou BLANC)
 * 
 *Une case peut aussi être occupée ou vide. la @Piece occupeePar vaut null si la case est vide, une instance de pièce sinon
 *
 *le champ atteignable n'est utilisée que dans le cas de la modélisation du rayon d'action d'une pièce 
 *et désigne si la pièce en question peut aller sur cette case
 *
 * @author Alexandre
 */

public class Case {
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private int col; //le numéro de colonne (entre 1 et 8)
	private int lig; //le numéro de ligne (entre 1 et 8)
	
	private Couleur couleurCase; // La couleur (NOIR ou BLANC)
	
	private Piece occupeePar; // La variable qui indique si la case est occupée ou non 

	private boolean atteignable; // Indique, dans le cas d'un déplacement, si la pièce peut aller sur cette case
	
/////////////////////////////////////////Getters et Setters////////////////////////////////////////////



/**
 * @param aucun 
 * @return la colonne de la case @tested
 */
	public int getCol() {
		return col;
	}
	
	/**
	 * @param aucun 
	 * @return la ligne de la case @tested
	 */
	public int getLig() {
		return lig;
	}

	/**
	 * @param aucun 
	 * @return la couleur de la case @tested
	 */
	public Couleur getCouleurCase() {
		return couleurCase;
	}
	
	/**
	 * La couleur d'une case ne dépend que de ses coordonnées. ce setter appelé par le constructeur donne une couleur à la case
	 * @return void mais initialise couleurCase à NOIR ou BLANC @tested
	 */
	private void setCouleurCase() {
		int key = (this.getCol()+this.getLig())%2;
		if (key == 0) {
			this.couleurCase = Couleur.NOIR;
			//uniquement pour les tests de la fonction
			//System.out.println("la couleur de la case de coordonnées : Colonne "+(this.getCol()+1)+" Ligne "+(this.getLig()+1)+" est NOIR");
		}
		else {
			this.couleurCase = Couleur.BLANC;
			//uniquement pour les tests de la fonction
			//System.out.println("la couleur de la case de coordonnées : Colonne "+(this.getCol()+1)+" Ligne "+(this.getLig()+1)+" est BLANC");		}
		}
	}
	
	/**
	 * @param aucun 
	 * @return la piece qui occupe la case, null si la case est vide @tested
	 */
	public Piece OccupeePar() {
		return occupeePar;
	}

	/**
	 * @param Piece
	 * @return void mais initialise le champ de l'attribut à la pièce @tested
	 */
	public void setOccupeePar(Piece occupeePar) {
		this.occupeePar = occupeePar;
	}
	
	/**
	 * renvoie true si la case est atteignable par la pièce en question @tested
	 */
	public boolean isAtteignable() {
		return atteignable;
	}

	/**
	 * initialise le champ atteignable de la case (false dans le cas du constructeur) @tested
	 */
	public void setAtteignable(boolean atteignable) {
		this.atteignable = atteignable;
	}
	
	/**
	 * méthode equals, utile pour la copie @tested (generée)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		if (atteignable != other.atteignable)
			return false;
		if (col != other.col)
			return false;
		if (lig != other.lig)
			return false;
		if (occupeePar == null) {
			if (other.occupeePar != null)
				return false;
		} else if (!occupeePar.equals(other.occupeePar))
			return false;
		return true;
	}
	
/////////////////////////////////////////Constructeur////////////////////////////////////////////
	/**
	 * Un constructeur qui permet aussi de construire mais cette fois ci en se placant sur les attributs d'une aute case @tested
	 * @param col
	 * @param lig
	 * @param occupeePar
	 */
	public Case (int col, int lig, Piece occupeePar, boolean atteignable) {
		this.col = col;
		this.lig = lig;
		this.occupeePar = occupeePar;
		this.atteignable = atteignable;
		this.setCouleurCase();
	}

	/**
	 * construit une case (toutes les cases crées seront crées sans pièces. Seulement après les pièces seront crées et mises 
	 * sur la case. @tested
	 * @param col
	 * @param lig
	 * @param occupeePar @tested
	 */
	public Case(int col, int lig) {
		this.col = col;
		this.lig = lig;
		this.setAtteignable(false);
		this.setCouleurCase();
	}
	
	/**
	 * le constructeur réduit qui crée la case A1 (col = 0; lig = 0)
	 * En aucun cas le programme vérifie si ce sont bien des cases d'échec pour le moment ! @tested
	 */
	public Case() {
		this(1,1);
	}
}
