package modelisation.tests.plateau;

import modelisation.plateau.*;

public class EchiquierTest {
	
	public static void main(String[] args) {
		
		//Création d'un échiquier test
		Echiquier echiquier = new Echiquier();
		
		//test de getPlateau()
		Case[][] testgetPlateau = echiquier.getPlateau();
		if (testgetPlateau == null) {
			System.out.println("Aïe, getPlateau() renvoie quelque chose de null");
		}
			else {
				if (testgetPlateau.length != 8) {
					System.out.println("Aïe, getPlateau() renvoie quelque chose mais il y a "+testgetPlateau.length+" colonnes au lieu de 8");
				}
				else {
					if (testgetPlateau[0].length != 8) {
						System.out.println("Aïe, getPlateau() renvoie quelque chose mais il y a "+testgetPlateau[0].length+" lignes au lieu de 8 dans la premiere colonne");
					}
					else {
						System.out.println("Ok, getPlateau() renvoie bien une matrice de 8x8 de cases");
					}
				}
			}
		//test de getCase(int col, int lig)
		Case A1 = echiquier.getCase(0, 0);
		Case H8 = echiquier.getCase(7, 7);
		Case B5 = echiquier.getCase(1,4); 
		
		if (A1.getCol() != 0) {
			System.out.println("Aïe, getCase(0, 0) renvoie la case à la colonne "+ A1.getCol() +" au lieu de A1");
		}
			else {
				if (H8.getLig() != 7) {
					System.out.println("Aïe, getCase(7,7) renvoie la case à la colonne "+ H8.getLig() +" au lieu de H8");
				}
				else {
					if (B5.getLig() != 4 && B5.getCol() != 1) {
						System.out.println("Aïe, getCase(1,4) renvoie la case à la ligne "+ (B5.getLig()+1) +"et à la clonne "+(B5.getCol()+1)+" au lieu de B5");
					}
				
			}
		}
		
		//test de setCase(Case c)
		echiquier.getCase(0, 0).setAtteignable(true);
		Case newA1 = new Case(0,0);
		echiquier.setCase(newA1);
		if (echiquier.getCase(0, 0).isAtteignable()) {
			System.out.println("Aïe, setCase(newA1) devrait initialiser A1 comme une autre case non atteignable");
		}
		else {
			System.out.println("OK, setCase(Case c) semble correct");
		}
		
		//test de setCaseAtteignable(Case c)
		echiquier.setCaseAtteignable(echiquier.getCase(7, 1), true); //la case H2 est atteignable
		if (!echiquier.getCase(7, 1).isAtteignable()) {
			System.out.println("Aïe, setCaseAtteignable(echiquier[7][1]) initialise l'attribut correspondant de la case à"+echiquier.getCase(7, 1).isAtteignable()+" au lieu de true");
		}
		else {
			System.out.println("Ok, setCaseAtteignable(Case c) semble correcte");
		}
		
		//test de copyEchiquier
		Echiquier copy = Echiquier.copyEchiquier(echiquier);
		boolean verif = true;
		for (int col = 0; col<8; col++) {
			for (int lig = 0; lig<8; lig++) {
				if (!copy.getCase(col, lig).equals(echiquier.getCase(col, lig))) {
					System.out.println("Aïe, copyEchiquier copie mal la case de colonne "+col+" et de ligne "+lig);
					verif = false;
				}
			}
		}
		if (verif == true) {
			System.out.println("Ok, copyEchiquier(Echiquier e) semble correcte");
		}
	}
}
