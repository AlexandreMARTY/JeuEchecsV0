package modelisation.tests;

import modelisation.pieces.Fou;
import modelisation.plateau.Case;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class PieceTest {
	
	public static void main(String[] args) {
		// création des cases
		Case A1 = new Case(0,0);
		Case A2 = new Case(0,1);
		Case A3 = new Case(0,2);
	
		//création des pièces (fous pour l'exemple)
		Fou Fou1 = new Fou("Fou1", Couleur.BLANC, A1);
		Fou Fou2 = new Fou("Fou2", Couleur.BLANC, A2);
	
		//liaison des cases à leur pièces
		A1.setOccupeePar(Fou1);
		A2.setOccupeePar(Fou2);
	
		Fou1.setEmplacement(A3); // le fou1 se déplace en A2
		if (Fou1.getEmplacement() != A3) {
			System.out.println("Aïe, après le déplacement de "+Fou1.getNomPiece()+" vers A3, sa case d'emplacement est "+Fou1.getEmplacement()+
					" au lieu de A3");
		}
		else {
			if (A3.OccupeePar() != Fou1) {
				System.out.println("Aïe, après le déplacement de "+Fou1.getNomPiece()+" vers A3, OccupeePar() de A3 renvoie "+A3.OccupeePar()+" au lieu de Fou1");
			}
			else {
				if (A1.OccupeePar() != null) {
					System.out.println("Aïe, après le déplacement de "+Fou1.getNomPiece()+" vers A3, OccupeePar() de A1 renvoie "+A1.OccupeePar()+" au lieu de null");
				}
				else {
					Fou1.setEmplacement(A2);
					if (Fou2.getNomPiece() != "erase") {
						System.out.println("Aïe, après le déplacement de "+Fou1.getNomPiece()+" vers A2, Fou2 semble encore exister");
					}
					else {
						if (A2.OccupeePar() != Fou1) {
							System.out.println("Aïe, après le déplacement de "+Fou1.getNomPiece()+" vers A2, OccupeePar() de A2 renvoie "+A2.OccupeePar()+" au lieu de Fou1");
						}
						else {
							System.out.println("Ok, setEmplacement semble correcte");
						}
					}
				}
			}
		}
	
		//Test de rayon d'action 
		//initialisation d'un echiquier rayon d'action fictif : 
		Echiquier rayonActionfictif = new Echiquier();
		rayonActionfictif .getCase(0, 0).setAtteignable(true);
		Fou1.setRayonAction(rayonActionfictif);
	
		if (!Fou1.CaseInRayonAction(A1)) {
			System.out.println("Aïe, A1 est dans le ryon d'action de Fou1, mais CaseInRayonAction(A1) renvoie false");
		}
			else {
				if (Fou1.CaseInRayonAction(A2)) {
					System.out.println("Aïe, A2 n'est pas dans le ryon d'action de Fou1, mais CaseInRayonAction(A2) renvoie true");
				}
				else {
				System.out.println("Ok, CaseInRayonAction(Case c)) semble correcte");
			}
		}
	}	
}
