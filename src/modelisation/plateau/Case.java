package modelisation.plateau;

import modelisation.pieces.Piece;

/**
 * Cette classe repr�sente les cases d'un �chiquier. 
 * Une case est rep�r� par ses coordonn�es (@int lig et @int col)
 * ainsi qu'une @Couleur (NOIR ou BLANC)
 * 
 *Une case peut aussi �tre occup�e ou vide. la @Piece occupeePar vaut null si la case est vide, une instance de pi�ce sinon
 *
 *le champ atteignable n'est utilis�e que dans le cas de la mod�lisation du rayon d'action d'une pi�ce 
 *et d�signe si la pi�ce en question peut aller sur cette case
 *
 * @author Alexandre
 */

public class Case {
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private int col; //le num�ro de colonne (entre 1 et 8)
	private int lig; //le num�ro de ligne (entre 1 et 8)
	
	private Couleur couleurCase; // La couleur (NOIR ou BLANC)
	
	private Piece occupeePar; // La variable qui indique si la case est occup�e ou non 

	private boolean atteignable; // Indique, dans le cas d'un d�placement, si la pi�ce peut aller sur cette case
	
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
	 * La couleur d'une case ne d�pend que de ses coordonn�es. ce setter appel� par le constructeur donne une couleur � la case
	 * @return void mais initialise couleurCase � NOIR ou BLANC @tested
	 */
	private void setCouleurCase() {
		int key = (this.getCol()+this.getLig())%2;
		if (key == 0) {
			this.couleurCase = Couleur.NOIR;
			//uniquement pour les tests de la fonction
			//System.out.println("la couleur de la case de coordonn�es : Colonne "+(this.getCol()+1)+" Ligne "+(this.getLig()+1)+" est NOIR");
		}
		else {
			this.couleurCase = Couleur.BLANC;
			//uniquement pour les tests de la fonction
			//System.out.println("la couleur de la case de coordonn�es : Colonne "+(this.getCol()+1)+" Ligne "+(this.getLig()+1)+" est BLANC");		}
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
	 * @return void mais initialise le champ de l'attribut � la pi�ce @tested
	 */
	public void setOccupeePar(Piece occupeePar) {
		this.occupeePar = occupeePar;
	}
	
	/**
	 * renvoie true si la case est atteignable par la pi�ce en question @tested
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
	 * m�thode equals, utile pour la copie @tested (gener�e)
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
	 * construit une case (toutes les cases cr�es seront cr�es sans pi�ces. Seulement apr�s les pi�ces seront cr�es et mises 
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
	 * le constructeur r�duit qui cr�e la case A1 (col = 0; lig = 0)
	 * En aucun cas le programme v�rifie si ce sont bien des cases d'�chec pour le moment ! @tested
	 */
	public Case() {
		this(1,1);
	}
}
