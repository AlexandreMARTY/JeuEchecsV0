package modelisation.plateau;

import modelisation.pieces.Piece;

/**
 * Cette classe représente les cases d'un échiquier. 
 * Une case est repéré par ses coordonnées (@int lig et @int col)
 * ainsi qu'une @Couleur (NOIR ou BLANC)
 * 
 *Une case peut aussi être occupée ou vide. la @Piece occupeePar vaut null si la case est vide, une instance de pièce sinon
 *
 * @author Alexandre
 */

public class Case {
	
/////////////////////////////////////////Attributs////////////////////////////////////////////
	private int col; //le numéro de colonne (entre 1 et 8)
	private int lig; //le numéro de ligne (entre 1 et 8)
	
	private Couleur couleurCase; // La couleur (NOIR ou BLANC)
	
	private Piece occupeePar; // La variable qui indique si la case est occupée ou non 

	
/////////////////////////////////////////Getters et Setters////////////////////////////////////////////

/**
 * @param aucun 
 * @return la colonne de la case
 */
	public int getCol() {
		return col;
	}
	
	/**
	 * @param aucun 
	 * @return la ligne de la case
	 */
	public int getLig() {
		return lig;
	}

	/**
	 * @param aucun 
	 * @return la couleur de la case
	 */
	public Couleur getCouleurCase() {
		return couleurCase;
	}
	
	/**
	 * La couleur d'une case ne dépend que de ses coordonnées. ce setter appelé par le constructeur donne une couleur à la case
	 * @return void mais initialise couleurCase à NOIR ou BLANC
	 */
	private void setCouleurCase() {
		int key = (this.getCol()+this.getLig())%2;
		if (key == 0) {
			this.couleurCase = Couleur.NOIR;
		}
		else {
			this.couleurCase = Couleur.BLANC;
		}
	}
	
	/**
	 * @param aucun 
	 * @return la piece qui occupe la case, null si la case est vide
	 */
	public Piece OccupeePar() {
		return occupeePar;
	}

	/**
	 * @param Piece
	 * @return void mais initialise le champ de l'attribut à la pièce
	 */
	public void setOccupeePar(Piece occupeePar) {
		this.occupeePar = occupeePar;
	}
	
/////////////////////////////////////////Constructeur////////////////////////////////////////////
	
	/**
	 * construit une case (toutes les cases crées seront crées sans pièces. Seulement après les pièces seront crées et mises 
	 * sur la case.
	 * @param col
	 * @param lig
	 * @param occupeePar
	 */
	public Case(int col, int lig) {
		this.col = col;
		this.lig = lig;
		this.setCouleurCase();
	}
	
	/**
	 * le constructeur réduit qui crée la case A1 (col = 0; lig = 0)
	 * En aucun cas le programme vérifie si ce sont bien des cases d'échec pour le moment !
	 */
	public Case() {
		this(1,1);
	}
}
