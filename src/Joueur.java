import java.io.*;
import java.util.*;

public class Joueur {
	public Joueur(String nom, String pion) {
		this.nom = nom;
		this.pion = pion;
	}
	public String getNom() {
		return nom;
	}
	public String getPion() {
		return pion;
	}
	public int[] jouer(Puissance4 puissance) {
		String[][] grid = puissance.getGrid();
		int ligne = 0;
		int colonne = 0;
		System.out.print("\nAu tour de " + nom + " de jouer. Entrer votre position : ");
		System.out.print("\ncolonne = ");
		try {
			colonne = Clavier.lireInt();
		}
		catch(NumberFormatException err) {
			System.out.print("\n*** Erreur de donnee ***");
		}
		if (colonne < 1 || colonne > puissance.getSize()) {
			System.out.print("\nEntrer un nombre valide ne depassant pas la taille de la grid");
			jouer(puissance);
		}
		for (int i = puissance.getSize()-1; i > -1 ; i--) {
			if (grid[i][colonne-1] == ".") {
				grid[i][colonne-1] = pion;
				ligne = i;
				break;
			}
		}
		
		int[] position = {ligne, colonne-1};
		return position;
		
		
	}
	// Attributs
	private String nom, pion;
}
