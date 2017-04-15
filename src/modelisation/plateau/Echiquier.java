package modelisation.plateau;

/**Cette classe est ici pour repr�senter un �chiquier. Un �chiquier sera bien s�r utilis� pour jouer, donc comme
 * terrain d'affontement entre deux @Joueur, mais aussi dans la mod�lisation, chaque pi�ce poss�dera
 * en attribut un �chiquier avec des cases o� le champ atteignable sera rempli par @true ou @false.
 * 
 * @author Alexandre
 */
public class Echiquier {

/////////////////////////////////////////Attributs////////////////////////////////////////////
	private Case[][] plateau; //le plateau d'�checs
	
	
/////////////////////////////////////////Getters et Setters////////////////////////////////////////////
	/**
	 * retourne le plateau d'echec en entier
	 */
	public Case[][] getPlateau() {
		return plateau;
	}
	
	/**
	 * retourne une case en particulier
	 */
	public Case getCase(int col, int lig) {
		return plateau[col][lig];
	}
	
	/**
	 * change l'�tat de la case en question (passe de non atteignable � atteignable) par une pi�ce
	 */
	public void setCaseAtteignable(Case c, boolean b) {
		c.setAtteignable(b);
	}
	
/////////////////////////////////////////Constructeurs////////////////////////////////////////////
	/**
	 * Ce constructeur constrit un �chiquier en faisant appel 64 fois au constructeur
	 */
	public Echiquier() {
		this.plateau = new Case[8][8];
		for (int col=0; col<8; col++) {
			for (int lig=0; lig<8; lig++) {
				plateau[col][lig] = new Case(col, lig);
			}
		}
	}
}
