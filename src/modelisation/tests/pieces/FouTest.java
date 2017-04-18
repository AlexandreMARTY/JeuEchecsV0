package modelisation.tests.pieces;

import java.util.List;

import modelisation.pieces.Cavalier;
import modelisation.pieces.Fou;
import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class FouTest {
	
	public static void main(String[] args) {
		Echiquier plateauJeu = new Echiquier();
		Fou FouA1 = new Fou("FouA1", Couleur.BLANC, plateauJeu.getCase(0, 0));
		plateauJeu.getCase(0, 0).setOccupeePar(FouA1);
		Fou FouD4 = new Fou("FouD4", Couleur.BLANC, plateauJeu.getCase(3, 3));
		plateauJeu.getCase(3,3).setOccupeePar(FouD4);
		Cavalier CG1 = new Cavalier("CavalierG1", Couleur.NOIR, plateauJeu.getCase(6, 0));
		plateauJeu.getCase(6,0).setOccupeePar(CG1);
		
		//Test de diagonales vides 
		List<List<Case>> diagFouD4 = FouD4.diagonalesVides(FouD4.getEmplacement());
		System.out.println("Les cases de portée du fou en D4 sont : ");
		System.out.println(diagFouD4);
		
		List<List<Case>> diagFouA1 = FouA1.diagonalesVides(FouA1.getEmplacement());
		System.out.println("Les cases de portée du fou en A1 sont : ");
		System.out.println(diagFouA1);
		
		//Test de premierRayonAction
		System.out.println("");
		Echiquier premierRayonActionD4 = FouD4.premierRayonAction(plateauJeu);
		System.out.println("Le premier rayon d'action du fou en D4 est : ");
		System.out.println(premierRayonActionD4.toStringPortee());
		
		System.out.println("");
		Echiquier premierRayonActionA1 = FouA1.premierRayonAction(plateauJeu);
		System.out.println("Le premier rayon d'action du fou en A1 est : ");
		System.out.println(premierRayonActionA1.toStringPortee());
	}
}
