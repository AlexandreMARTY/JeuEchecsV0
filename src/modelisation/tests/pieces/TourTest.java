package modelisation.tests.pieces;

import java.util.List;

import modelisation.pieces.Cavalier;
import modelisation.pieces.Tour;
import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class TourTest {
	public static void main(String[] args) {
		Echiquier plateauJeu = new Echiquier();
		Tour TourA1 = new Tour(Couleur.BLANC, plateauJeu.getCase(0, 0));
		plateauJeu.getCase(0, 0).setOccupeePar(TourA1);
		Tour TourD4 = new Tour(Couleur.BLANC, plateauJeu.getCase(3, 3));
		plateauJeu.getCase(3,3).setOccupeePar(TourD4);
		Cavalier CG1 = new Cavalier(Couleur.NOIR, plateauJeu.getCase(6, 0));
		plateauJeu.getCase(6,0).setOccupeePar(CG1);
		
		//Test de rangees vides 
		List<List<Case>> diagTourD4 = TourD4.rangeesVides(TourD4.getEmplacement());
		System.out.println("Les cases de portée de la tour en D4 sont : ");
		System.out.println(diagTourD4);
		
		List<List<Case>> diagTourA1 = TourA1.rangeesVides(TourA1.getEmplacement());
		System.out.println("Les cases de portée de la tour en A1 sont : ");
		System.out.println(diagTourA1);
		
		//Test de premierRayonAction
		System.out.println("");
		Echiquier premierRayonActionD4 = TourD4.premierRayonAction(plateauJeu);
		System.out.println("Le premier rayon d'action de la tour en D4 est : ");
		System.out.println(premierRayonActionD4.toStringPortee());
		
		System.out.println("");
		Echiquier premierRayonActionA1 = TourA1.premierRayonAction(plateauJeu);
		System.out.println("Le premier rayon d'action de la tour en A1 est : ");
		System.out.println(premierRayonActionA1.toStringPortee());
	}

}
