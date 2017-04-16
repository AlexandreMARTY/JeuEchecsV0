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
	 * Cette m�thode uniquement utilis�e dans la fonction de copie permet de copier une case dans l'emplacement r�serv� 
	 * @param c
	 */
	private void setCase(Case c) {
		plateau[c.getLig()][c.getCol()] = c;
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
	
	/**
	 * Pour l'impl�mentation de la m�thode nouveau rayon action, on a besoin de d�terminer une copie du plateau de jeu, d'o� cette 
	 * m�thode. Elle effectue la copie de l'�chiquier donn� en argument.
	 * @param e
	 * @return un �chiquier copi� 
	 */
	public static Echiquier copyEchiquier(Echiquier e) {
		Echiquier CopyEchiquier = new Echiquier();
		for (int col=0; col<8; col++) {
			for (int lig=0; lig<8; lig++) {
				CopyEchiquier.setCase(e.getCase(col, lig));
			}
		}
		return  CopyEchiquier;
	}
}
