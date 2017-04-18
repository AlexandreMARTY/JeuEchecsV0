package modelisation.tests.pieces;

import modelisation.pieces.Cavalier;
import modelisation.pieces.Fou;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class CavalierTest {
	
	public static void main(String[] args) {
		Echiquier plateauJeu = new Echiquier();
		Cavalier CavalierA1 = new Cavalier("CavalierA1", Couleur.BLANC, plateauJeu.getCase(0, 0));
		plateauJeu.getCase(0, 0).setOccupeePar(CavalierA1);
		Cavalier CavalierD4 = new Cavalier("CavalierD4", Couleur.NOIR, plateauJeu.getCase(3, 3));
		plateauJeu.getCase(3,3).setOccupeePar(CavalierD4);
		Cavalier CavalierF1 = new Cavalier("CavalierG1", Couleur.NOIR, plateauJeu.getCase(5, 0));
		plateauJeu.getCase(5,0).setOccupeePar(CavalierF1);
		
		Fou FouH2 = new Fou("FouH2", Couleur.NOIR, plateauJeu.getCase(7, 1));
		plateauJeu.getCase(7,1).setOccupeePar(FouH2);
		Fou FouG3 = new Fou("FouG3", Couleur.BLANC, plateauJeu.getCase(6, 2));
		plateauJeu.getCase(6,2).setOccupeePar(FouG3);
		
		//test de premierrayonaction
		Echiquier premierrayonactionCA1 = CavalierA1.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionCA1.toStringPortee());
		
		Echiquier premierrayonactionCD4 = CavalierD4.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionCD4.toStringPortee());
		
		Echiquier premierrayonactionCF1 = CavalierF1.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionCF1.toStringPortee());
	}

}
