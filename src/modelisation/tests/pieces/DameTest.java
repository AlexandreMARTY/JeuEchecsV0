package modelisation.tests.pieces;

import modelisation.pieces.Cavalier;
import modelisation.pieces.Dame;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class DameTest {
	
	public static void main(String[] args) {
		Echiquier plateauJeu = new Echiquier();
		Dame DameA1 = new Dame("DameA1", Couleur.BLANC, plateauJeu.getCase(0, 0));
		plateauJeu.getCase(0, 0).setOccupeePar(DameA1);
		Dame DameD4 = new Dame("DameD4", Couleur.BLANC, plateauJeu.getCase(3, 3));
		plateauJeu.getCase(3,3).setOccupeePar(DameD4);
		Cavalier CG1 = new Cavalier("CavalierG1", Couleur.NOIR, plateauJeu.getCase(6, 0));
		plateauJeu.getCase(6,0).setOccupeePar(CG1);
		Cavalier CF4 = new Cavalier("CavalierF4", Couleur.NOIR, plateauJeu.getCase(5, 3));
		plateauJeu.getCase(5,3).setOccupeePar(CF4);
		
		//Test de premierRayonAction
		System.out.println("");
		Echiquier premierRayonActionD4 = DameD4.premierRayonAction(plateauJeu);
		System.out.println("Le premier rayon d'action de la dame en D4 est : ");
		System.out.println(premierRayonActionD4.toStringPortee());
		
		System.out.println("");
		Echiquier premierRayonActionA1 = DameA1.premierRayonAction(plateauJeu);
		System.out.println("Le premier rayon d'action de la dame en A1 est : ");
		System.out.println(premierRayonActionA1.toStringPortee());
	}

}
