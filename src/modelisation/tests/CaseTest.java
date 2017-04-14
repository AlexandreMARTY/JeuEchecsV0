package modelisation.tests;

import modelisation.plateau.*;

public class CaseTest {
	
	public static void main(String[] args) {
		
		//Création de cases test
		Case A1 = new Case(0,0);
		//Case A8 = new Case(0,7);
		Case H8 = new Case(7,7);
		Case H1 = new Case(7,0);
		Case B6 = new Case(1,5);
		Case C8 = new Case(2,7);
		
		//test de getCol() 
		if (A1.getCol() != 0) {
			System.out.println("Aïe, getCol() appliquée à A1 renvoie "+A1.getCol()+" au lieu de 0");
		}
		else {
			if (H8.getCol() != 7) {
				System.out.println("Aïe, getCol() appliquée à H8 renvoie "+H8.getCol()+" au lieu de 7");
			}
			else {
				if (B6.getCol() != 1) {
					System.out.println("Aïe, getCol() appliquée à B6 renvoie "+B6.getCol()+" au lieu de 1");
				}
				else {
					if (C8.getCol() != 2){
						System.out.println("Aïe, getCol() appliquée à C8 renvoie "+C8.getCol()+" au lieu de 2");
					}
					else {
						System.out.println("Ok, getCol() semble correcte");
					}
				}
			}
		}
		
		//Test de getLig() 
		if (A1.getLig() != 0) {
			System.out.println("Aïe, getLig() appliquée à A1 renvoie "+A1.getLig()+" au lieu de 0");
		}
		else {
			if (H8.getLig() != 7) {
				System.out.println("Aïe, getLig() appliquée à H8 renvoie "+H8.getLig()+" au lieu de 7");
			}
			else {
				if (B6.getLig() != 5) {
					System.out.println("Aïe, getLig() appliquée à B6 renvoie "+B6.getLig()+" au lieu de 5");
				}
				else {
					if (C8.getLig() != 7){
						System.out.println("Aïe, getLig() appliquée à C8 renvoie "+C8.getLig()+" au lieu de 7");
					}
					else {
						System.out.println("Ok, getLig() semble correcte");
					}
				}
			}
		}
		
		//Test de getCouleurCase() (setCouleurCase() est testée dans la calsse Case)
		if (H1.getCouleurCase() != Couleur.BLANC) {
			System.out.println("Aïe, getCouleurCase() appliquée à H1 renvoie "+H1.getCouleurCase()+" au lieu de BLANC");
		}
		else {
			if (H8.getCouleurCase() != Couleur.NOIR) {
				System.out.println("Aïe, getCouleurCase() appliquée à H8 renvoie "+H8.getCouleurCase()+" au lieu de NOIR");
			}
			else {
				System.out.println("Ok, getCouleurCase() semble correcte");
			}
		}
		
		//test de isAtteignable() 
		if (H1.isAtteignable() == true) {
			System.out.println("Aïe, isAtteignable() appliquée à H1 renvoie "+H1.isAtteignable()+" au lieu de false");
		}
		else {
			System.out.println("Ok, isAtteignable() semble correcte");
		}
		
		//setAtteignable() {
		H1.setAtteignable(true);
		if (H1.isAtteignable() != true) {
			System.out.println("Aïe, setAtteignable() appliqué à H1 avec true initialise atteignable à "+ H1.isAtteignable()+" au lieu de true");
		}
		else {
			System.out.println("Ok, setAtteignable() semble correcte");
		}
	}
}
