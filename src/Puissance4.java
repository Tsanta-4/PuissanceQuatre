import java.io.*;
import java.util.*;
public class Puissance4 {
	// Methodes
	public Puissance4 (int size) {
		this.size = size;
		grid = new String[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				grid[i][j] = ".";
			}
		}
	}
	
	public void edit(int l, int c) {
		grid[l][c] = ",";
	}
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print("\n\t\t\t\t");
			for (int j = 0; j < size; j++) {
				System.out.print(grid[i][j] + "  ");
			}
		}
	}
	
	public static int[] lireInput() {
		int j,i;
		System.out.print("\nLigne : ");
		i = Clavier.lireInt();
		System.out.print("\nColonne : ");
		j = Clavier.lireInt();
		int[] coordonnees = {i,j};
		return coordonnees;
		
	}
	// Done
	public boolean valideHorizontale(int[] position, String pion) {
		int l = position[0];
		int c = position[1];
		int compter = 1;
		for (int j = c+1; j < size; j++) {
			if (grid[l][j] == pion) {
				compter += 1;
			}
			else {
				break;
			}
		}
		for (int jj = c-1; jj > -1; jj--) {
			if (grid[l][jj] == pion) {
				compter += 1;
			}
			else {
				break;
			}
		}
		if (compter >= 4) {
			return true;
		}
		return false;
	}
	// Done
	public boolean valideVerticale(int[] position, String pion) {
		int l = position[0];
		int c = position[1];
		int compter = 1;
		for (int i = l+1; i < size; i++) {
			if (grid[i][c] != pion || compter == 4) {
				break;
			}
			compter ++;
		}
		if (compter == 4)	return true;
		return false;
	}
	
	// Done
	public boolean valideDiagonalCroissant(int[] position, String pion) {
		int l = position[0];
		int c = position[1];
		int compter = 1;
		for (int i = 1; i < size; i++) {
			if (c+i >= size || l-i < 0 || grid[l-i][c+i] != pion || compter == 4) {
				break;
			}
			compter++;
		}
		if (compter == 4) {
			return true;
		}
		for (int i = 1; i < size; i++) {
			if (l+i >= size || c-i < 0 || grid[l+i][c-i] != pion || compter == 4) {
				break;
			}
			compter++;
		}
		if (compter == 4) {
			return true;
		}
		return false;
	}
	
	public boolean valideDiagonalDecroissant(int[] position, String pion) {
		int l = position[0];
		int c = position[1];
		int compter = 1;
		for (int i = 1; i < size; i++) {
			if (c+i >= size || l+i >= size || grid[l+i][c+i] != pion || compter == 4) {
				break;
			}
			compter++;
		}
		if (compter == 4) {
			return true;
		}
		for (int i = 1; i < size; i++) {
			if (l-i < 0 || c-i < 0 || grid[l-i][c-i] != pion || compter == 4) {
				break;
			}
			compter++;
		}
		if (compter == 4) {
			return true;
		}
		return false;
	}
	
	public boolean gagne(int[] position, Joueur joueur) {
		String pion = joueur.getPion();
		if (
				valideHorizontale(position, pion) ||
				valideVerticale(position, pion) ||
				valideDiagonalCroissant(position, pion) ||
				valideDiagonalDecroissant(position,pion)
			) {
			System.out.print("\n" + joueur.getNom() + " a gagne la partie. Bravo");
			return true;
		}
		return false;
		
	}
	
	public int getSize() {
		return size;
	}
	public String[][] getGrid() {
		return grid;
	}
	// Attributs
	private int size;
	private String[][] grid;
}
