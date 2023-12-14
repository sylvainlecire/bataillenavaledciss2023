package fr.uga.miashs.inff3.bataillenavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {
	private Scanner sc;

	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	public JoueurTexte(GrilleNavale g) {
		super(g);
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		// Réalise l'affichage à la console des étapes de jeu.
		// c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de l'attaque. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.
		if (etat==GAMEOVER)
			System.out.println("Gagné !");
		if (etat==TOUCHE)
			System.out.println(super.getNom()+", vous avez touché un navire, bien ouej");
		if (etat==COULE)
			System.out.println(super.getNom()+", vous avez coulé un navire, #pearl harbor");
		if (etat==A_L_EAU)
			System.out.println(super.getNom()+", vous avez tiré dans l'eau, plouf");
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		//c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de ce tir. etat ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER. 
		if (etat==GAMEOVER)
			System.out.println("Vous avez perdu :(");
		if (etat==TOUCHE)
			System.out.println(super.getNom()+", un navire a été touché, kaboom");
		if (etat==COULE)
			System.out.println(super.getNom()+", un navire a coulé, bloop bloop");
		if (etat==A_L_EAU)
			System.out.println(super.getNom()+", tout va bien yayyy");
	}
	
	public Coordonnee choixAttaque() {
		Scanner sc = new Scanner(System.in);
		// recueille au clavier la saisie de la coordonnée à attaquer
		System.out.println(super.getNom()+", choisissez les coordonnées de l'attaque : ");
		Coordonnee attaque;
		//exception si coordonnee hors des limites de la grille
		try { 
			// recueille au clavier la saisie de la coordonnée à attaquer
			do {
				// enregistrement de l'input dans une nouvelle coordonnee puis retourner la valeur
				attaque = new Coordonnee(sc.next());
			}
			// répéter si coordonnee hors des limites de la grille
			while (attaque.getColonne() >= this.getTailleGrille() || attaque.getLigne() >= this.getTailleGrille());
		
		} catch(IllegalArgumentException e) {
				System.out.println("taille hors limites");
		}
		return attaque;
	}

	public static void main(String[] args) {
		Coordonnee c = new Coordonnee("B3");
		GrilleNavale g = new GrilleNavale(10,2);
		JoueurTexte j = new JoueurTexte(g, "sylvain");
		j.choixAttaque(); j.retourAttaque(c, 2);
	}
}