package modelisation.tests.pieces;

import modelisation.pieces.Pion;
import modelisation.plateau.Couleur;
import modelisation.plateau.Echiquier;

public class PionTest {
	
	public static void main(String[] args) {
		Echiquier plateauJeu = new Echiquier();
		Pion a2 = new Pion(Couleur.BLANC, plateauJeu.getCase(0, 1));
		plateauJeu.getCase(0, 1).setOccupeePar(a2);
		Pion b3 = new Pion(Couleur.NOIR, plateauJeu.getCase(1, 2));
		b3.setPremierPas(false);
		plateauJeu.getCase(1, 2).setOccupeePar(b3);
		
		Pion a5 = new Pion(Couleur.BLANC, plateauJeu.getCase(0, 4));
		a5.setPremierPas(false);
		plateauJeu.getCase(0, 4).setOccupeePar(a5);
		Pion b5 = new Pion(Couleur.NOIR, plateauJeu.getCase(1, 4));
		b5.setPremierPas(false);
		plateauJeu.getCase(1, 4).setOccupeePar(b5);
		b5.setaJusteBouge(true);
		boolean EPdroita5 = a5.EPd(plateauJeu, b5);
		a5.setEPd(EPdroita5);
		
		
		Pion e4 = new Pion(Couleur.NOIR, plateauJeu.getCase(4, 3));
		e4.setPremierPas(false);
		plateauJeu.getCase(4, 3).setOccupeePar(e4);
		Pion d4 = new Pion(Couleur.BLANC, plateauJeu.getCase(3, 3));
		d4.setPremierPas(false);
		plateauJeu.getCase(3, 3).setOccupeePar(d4);
		d4.setaJusteBouge(true);
		boolean EPgauche4 = e4.EPg(plateauJeu, d4);
		e4.setEPg(EPgauche4);
		
		//Test de Epg et Epd
		System.out.println("Vous devriez voir true");
		System.out.println(EPdroita5);
		System.out.println("Vous devriez voir true");
		System.out.println(EPgauche4);
		System.out.println("Si vous voyez true et true c'est que l méthode semble fonctionner");
		System.out.println("Attention toutefois car les tests sont tès incomplets");
		
		//Test de premierrayonaction
		System.out.println("Le rayon d'action du pion blanc a5 est : ");
		System.out.println(a5.premierRayonAction(plateauJeu).toStringPortee());
		System.out.println("");
		
		System.out.println("Le rayon d'action du pion noir b3 est : ");
		System.out.println(b3.premierRayonAction(plateauJeu).toStringPortee());
		System.out.println("");
		
		System.out.println("Le rayon d'action du pion noir e4 est : ");
		System.out.println(e4.premierRayonAction(plateauJeu).toStringPortee());
		System.out.println("");
		
		System.out.println("Le rayon d'action du pion blanc a2 est : ");
		System.out.println(a2.premierRayonAction(plateauJeu).toStringPortee());
		System.out.println("");
	}

}
