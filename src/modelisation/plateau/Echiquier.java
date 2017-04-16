package modelisation.plateau;

/**Cette classe est ici pour représenter un échiquier. Un échiquier sera bien sûr utilisé pour jouer, donc comme
 * terrain d'affontement entre deux @Joueur, mais aussi dans la modélisation, chaque pièce possèdera
 * en attribut un échiquier avec des cases où le champ atteignable sera rempli par @true ou @false.
 * 
 * @author Alexandre
 */
public class Echiquier {

/////////////////////////////////////////Attributs////////////////////////////////////////////
	private Case[][] plateau; //le plateau d'échecs
	
	
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
	 * Cette méthode uniquement utilisée dans la fonction de copie permet de copier une case dans l'emplacement réservé 
	 * @param c
	 */
	private void setCase(Case c) {
		plateau[c.getLig()][c.getCol()] = c;
	}
	
	/**
	 * change l'état de la case en question (passe de non atteignable à atteignable) par une pièce
	 */
	public void setCaseAtteignable(Case c, boolean b) {
		c.setAtteignable(b);
	}
	
/////////////////////////////////////////Constructeurs////////////////////////////////////////////
	/**
	 * Ce constructeur constrit un échiquier en faisant appel 64 fois au constructeur
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
	 * Pour l'implémentation de la méthode nouveau rayon action, on a besoin de déterminer une copie du plateau de jeu, d'où cette 
	 * méthode. Elle effectue la copie de l'échiquier donné en argument.
	 * @param e
	 * @return un échiquier copié 
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
