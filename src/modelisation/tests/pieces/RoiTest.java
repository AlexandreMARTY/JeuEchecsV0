package modelisation.tests.pieces;

import modelisation.pieces.Roi;
import modelisation.pieces.Tour;
import modelisation.pieces.Fou;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class RoiTest {
	
	public static void main(String[] args) {
		Echiquier plateauJeu = new Echiquier();
		Roi RoiA1 = new Roi(Couleur.BLANC, plateauJeu.getCase(0, 0));
		plateauJeu.getCase(0, 0).setOccupeePar(RoiA1);
		Roi RoiD4 = new Roi(Couleur.NOIR, plateauJeu.getCase(3, 3));
		plateauJeu.getCase(3,3).setOccupeePar(RoiD4);
		Roi RoiF1 = new Roi(Couleur.NOIR, plateauJeu.getCase(5, 0));
		plateauJeu.getCase(5,0).setOccupeePar(RoiF1);
		
		Fou FouA2 = new Fou(Couleur.BLANC, plateauJeu.getCase(0, 1));
		plateauJeu.getCase(0,1).setOccupeePar(FouA2);
		Fou FouG3 = new Fou(Couleur.BLANC, plateauJeu.getCase(6, 2));
		plateauJeu.getCase(6,2).setOccupeePar(FouG3);
		
		//test de premierrayonaction (sans le roque)
		Echiquier premierrayonactionRA1 = RoiA1.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionRA1.toStringPortee());
		
		Echiquier premierrayonactionRD4 = RoiD4.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionRD4.toStringPortee());
		
		Echiquier premierrayonactionRF1 = RoiF1.premierRayonAction(plateauJeu);
		System.out.println(premierrayonactionRF1.toStringPortee());
		
		//test de peutpetitroquer et peutgrandroquer
		Echiquier plateauJeu2 = new Echiquier();
		
		Roi RE1 = new Roi(Couleur.BLANC, plateauJeu2.getCase(4, 0));
		plateauJeu2.getCase(4, 0).setOccupeePar(RE1);
		Roi RE8 = new Roi(Couleur.BLANC, plateauJeu2.getCase(4, 7));
		plateauJeu2.getCase(4, 7).setOccupeePar(RE8);
		
		Tour TA8 = new Tour(Couleur.NOIR, plateauJeu2.getCase(0, 7));
		plateauJeu2.getCase(0, 7).setOccupeePar(TA8); 
		Tour TB8 = new Tour(Couleur.NOIR, plateauJeu2.getCase(1, 7));
		plateauJeu2.getCase(1, 7).setOccupeePar(TB8); //Le grand roque noir est impossible, car une tour occupe B8
		Tour TH8 = new Tour(Couleur.NOIR, plateauJeu2.getCase(7, 7));
		plateauJeu2.getCase(7, 7).setOccupeePar(TH8);
		Tour TF7 = new Tour(Couleur.BLANC, plateauJeu2.getCase(5, 6)); //Le petit roque noir est impossible,
		plateauJeu2.getCase(7, 7).setOccupeePar(TF7); // car une tour ennemie contrôle F8
		
		Tour TA1 = new Tour(Couleur.BLANC, plateauJeu2.getCase(0, 0));
		plateauJeu2.getCase(0, 0).setOccupeePar(TA1); //le grand roque blanc est possible
		Tour TH1 = new Tour(Couleur.BLANC, plateauJeu2.getCase(7, 0));
		plateauJeu2.getCase(7, 0).setOccupeePar(TH1);
		TH1.setaBouge(true); //le petit roque blanc est impossible : la tour a bougé
		
		boolean petitRoqueBlanc = RE1.PeutPetitRoquer(plateauJeu2,TH1);
		boolean grandRoqueBlanc = RE1.PeutGrandRoquer(plateauJeu2,TA1);
		boolean petitRoqueNoir  = RE8.PeutPetitRoquer(plateauJeu2, TH8);
		boolean grandRoqueNoir = RE8.PeutGrandRoquer(plateauJeu2,TA8);
		
		if (petitRoqueBlanc) {
			System.out.println("Aïe, la tour en H1 a son boolean aBouge qui vaut "+TH1.aBouge()+" et le petit roque est possible");
		}
		else {
			if (petitRoqueNoir) {
				System.out.println("Aïe, la case F8 est contrôlée par une tour adverse et le roque noir est possible");
			} 
			else {
				if (grandRoqueNoir) {
					System.out.println("Aïe, la case B8 est occupée par une tour et le roque noir est possible");
				}
				else {
					if (!grandRoqueBlanc) {
						System.out.println("Aïe, le grand roque blanc devrait être possible pourtant il ne semble pas l'être");
					}
					else {
						System.out.println("Ok, peutPetitRoquer et peutGrandRoquer semblent correcte");
					}
				}
			}
		}
		
		//test de premierRayonAction avec le roque 
		RE1.setPeutPetitRoquer(petitRoqueBlanc);
		RE1.setPeutGrandRoquer(grandRoqueBlanc);
		Echiquier premierrayonactionRE1 = RE1.premierRayonAction(plateauJeu2);
		System.out.println(premierrayonactionRE1.toStringPortee());
	}
}
