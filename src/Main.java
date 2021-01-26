/*
 * Jeux de puissance4 écrit en Java
 * copyright@ RATSIMBAZAFY Tiantsoa Tsantanirina
 * 
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Puissance4 puissance = new Puissance4(8);
		Joueur j1 = new Joueur("Rouge", "x");
		Joueur j2 = new Joueur("Bleu", "o");
		System.out.print("\nJoueur1 : " + j1.getNom());
		System.out.print("\nJoueur2 : " + j2.getNom());
		System.out.print("\n!!!!!!La parite commence!!!!!!!");
		
		boolean gagnant = false;
		while (!gagnant) {
			int[] mvt1 = j1.jouer(puissance);
			puissance.display();
			gagnant = puissance.gagne(mvt1, j1);
			if (gagnant)	break;
			mvt1 = j2.jouer(puissance);
			puissance.display();
			gagnant = puissance.gagne(mvt1, j2);
		}
	}

}
