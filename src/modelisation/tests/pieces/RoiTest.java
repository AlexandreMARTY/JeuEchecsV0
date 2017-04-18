package modelisation.tests.pieces;

import modelisation.pieces.Roi;
import modelisation.pieces.Fou;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class RoiTest {
	
	public static void main(String[] args) {
		Echiquier plateauJeu = new Echiquier();
		Roi RoiA1 = new Roi("RoiA1", Couleur.BLANC, plateauJeu.getCase(0, 0));
		plateauJeu.getCase(0, 0).setOccupeePar(RoiA1);
		Roi RoiD4 = new Roi("RoiD4", Couleur.NOIR, plateauJeu.getCase(3, 3));
		plateauJeu.getCase(3,3).setOccupeePar(RoiD4);
		Roi RoiF1 = new Roi("RoiG1", Couleur.NOIR, plateauJeu.getCase(5, 0));
		plateauJeu.getCase(5,0).setOccupeePar(RoiF1);
		
		Fou FouA2 = new Fou("FouA2", Couleur.BLANC, plateauJeu.getCase(0, 1));
		plateauJeu.getCase(0,1).setOccupeePar(FouA2);
		Fou FouG3 = new Fou("FouG3", Couleur.BLANC, plateauJeu.getCase(6, 2));
		plateauJeu.getCase(6,2).setOccupeePar(FouG3);
		
		//test de premierrayonaction (sans le roque)
		Echiquier premierrayonactionRA1 = RoiA1.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionRA1.toStringPortee());
		
		Echiquier premierrayonactionRD4 = RoiD4.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionRD4.toStringPortee());
		
		Echiquier premierrayonactionRF1 = RoiF1.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionRF1.toStringPortee());
	}

}
