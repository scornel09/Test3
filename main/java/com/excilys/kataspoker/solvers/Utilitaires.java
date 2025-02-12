package main.java.com.excilys.kataspoker.solvers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

import main.java.com.excilys.kataspoker.model.CardNotFoundException;
import main.java.com.excilys.kataspoker.model.Carte;
import main.java.com.excilys.kataspoker.model.Couleur;
import main.java.com.excilys.kataspoker.model.Main;
import main.java.com.excilys.kataspoker.model.Valeur;

public class Utilitaires {
	
	public static List<Carte> trierParValeur(Main main) {
		return new ArrayList<Carte>();
	}

	public static boolean contientLeRoiDeCoeur(Main main) {
		for (Carte carte : main.getCartes()) {
			if (carte.getCouleur() == Couleur.COEUR && carte.getValeur() == Valeur.ROI) {
				return true;
			}
		}
		return false;
	}


	public static Carte contientUneCarteSpecifique(Main main, Carte carteATrouver) throws CardNotFoundException {
		for (Carte carte : main.getCartes()) {
			if (carte.getCouleur() == carteATrouver.getCouleur() && carte.getValeur() == carteATrouver.getValeur()) {
				return carte; // Carte trouvée, on la retourne
			}
		}
		throw new CardNotFoundException();
	}


	public static Carte trouveLaMeilleureCarteDansMain(Main main) {
		if (main.getCartes().isEmpty()) {
			return null; // Retourne null si la main est vide
		}

		Carte meilleureCarte = main.getCartes().get(0); // On suppose que la première carte est la meilleure

		for (Carte carte : main.getCartes()) {
			if (carte.getValeur().compareTo(meilleureCarte.getValeur()) > 0) {
				meilleureCarte = carte; // Mise à jour de la meilleure carte
			}
		}

		return meilleureCarte;
	}


	public static int calculeSommeValeurs(Main main) {
		int somme = 0;

		for (Carte carte : main.getCartes()) {
			somme += carte.getValeur().getOrdre(); // Utilisation de getOrdre()
		}

		return somme;
	}



	public static Map<Valeur, List<Carte>> groupeParValeur(Main main) {
		Map<Valeur, List<Carte>> cartesParValeur = new HashMap<>();

		for (Carte carte : main.getCartes()) {
			cartesParValeur
					.computeIfAbsent(carte.getValeur(), k -> new ArrayList<>())
					.add(carte);
		}

		return cartesParValeur;
	}


	public static String groupeLesValeursDansString(Main main) {
		Map<Valeur, List<Carte>> cartesParValeur = groupeParValeur(main);
		StringBuilder result = new StringBuilder();

		for (Map.Entry<Valeur, List<Carte>> entry : cartesParValeur.entrySet()) {
			result.append(entry.getKey().getNom()) // Ajoute le nom de la valeur
					.append(" : ")
					.append(entry.getValue().size()) // Ajoute le nombre de cartes de cette valeur
					.append(" carte(s)\n"); // Formatage pour la lisibilité
		}

		return result.toString();
	}


	public static List<Carte> regrouperCartes(List<Main> mains) {
		List<Carte> toutesLesCartes = new ArrayList<>();

		for (Main main : mains) {
			toutesLesCartes.addAll(main.getCartes()); // Ajoute toutes les cartes de la main
		}

		return toutesLesCartes;
	}


	public static List<Carte> regrouperEtTrierParValeur(List<Main> mains) {
		// Récupérer toutes les cartes de toutes les mains
		List<Carte> toutesLesCartes = regrouperCartes(mains);

		// Trier les cartes par leur valeur (ordre défini dans Valeur)
		Collections.sort(toutesLesCartes, new Comparator<Carte>() {
			@Override
			public int compare(Carte c1, Carte c2) {
				return Integer.compare(c1.getValeur().getOrdre(), c2.getValeur().getOrdre());
			}
		});

		return toutesLesCartes;
	}
}
