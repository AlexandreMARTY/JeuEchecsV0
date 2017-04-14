package modelisation.tests;

import modelisation.plateau.*;

public class CaseTest {
	
	public static void main(String[] args) {
		
		//Cr�ation de cases test
		Case A1 = new Case(0,0);
		//Case A8 = new Case(0,7);
		Case H8 = new Case(7,7);
		Case H1 = new Case(7,0);
		Case B6 = new Case(1,5);
		Case C8 = new Case(2,7);
		
		//test de getCol() 
		if (A1.getCol() != 0) {
			System.out.println("A�e, getCol() appliqu�e � A1 renvoie "+A1.getCol()+" au lieu de 0");
		}
		else {
			if (H8.getCol() != 7) {
				System.out.println("A�e, getCol() appliqu�e � H8 renvoie "+H8.getCol()+" au lieu de 7");
			}
			else {
				if (B6.getCol() != 1) {
					System.out.println("A�e, getCol() appliqu�e � B6 renvoie "+B6.getCol()+" au lieu de 1");
				}
				else {
					if (C8.getCol() != 2){
						System.out.println("A�e, getCol() appliqu�e � C8 renvoie "+C8.getCol()+" au lieu de 2");
					}
					else {
						System.out.println("Ok, getCol() semble correcte");
					}
				}
			}
		}
		
		//Test de getLig() 
		if (A1.getLig() != 0) {
			System.out.println("A�e, getLig() appliqu�e � A1 renvoie "+A1.getLig()+" au lieu de 0");
		}
		else {
			if (H8.getLig() != 7) {
				System.out.println("A�e, getLig() appliqu�e � H8 renvoie "+H8.getLig()+" au lieu de 7");
			}
			else {
				if (B6.getLig() != 5) {
					System.out.println("A�e, getLig() appliqu�e � B6 renvoie "+B6.getLig()+" au lieu de 5");
				}
				else {
					if (C8.getLig() != 7){
						System.out.println("A�e, getLig() appliqu�e � C8 renvoie "+C8.getLig()+" au lieu de 7");
					}
					else {
						System.out.println("Ok, getLig() semble correcte");
					}
				}
			}
		}
		
		//Test de getCouleurCase() (setCouleurCase() est test�e dans la calsse Case)
		if (H1.getCouleurCase() != Couleur.BLANC) {
			System.out.println("A�e, getCouleurCase() appliqu�e � H1 renvoie "+H1.getCouleurCase()+" au lieu de BLANC");
		}
		else {
			if (H8.getCouleurCase() != Couleur.NOIR) {
				System.out.println("A�e, getCouleurCase() appliqu�e � H8 renvoie "+H8.getCouleurCase()+" au lieu de NOIR");
			}
			else {
				System.out.println("Ok, getCouleurCase() semble correcte");
			}
		}
		
		//test de isAtteignable() 
		if (H1.isAtteignable() == true) {
			System.out.println("A�e, isAtteignable() appliqu�e � H1 renvoie "+H1.isAtteignable()+" au lieu de false");
		}
		else {
			System.out.println("Ok, isAtteignable() semble correcte");
		}
		
		//setAtteignable() {
		H1.setAtteignable(true);
		if (H1.isAtteignable() != true) {
			System.out.println("A�e, setAtteignable() appliqu� � H1 avec true initialise atteignable � "+ H1.isAtteignable()+" au lieu de true");
		}
		else {
			System.out.println("Ok, setAtteignable() semble correcte");
		}
	}
}
