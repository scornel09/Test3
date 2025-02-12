package main.java.com.excilys.kataspoker.solvers;
import java.util.*;

import main.java.com.excilys.kataspoker.model.Main;
import main.java.com.excilys.kataspoker.model.Carte;
import main.java.com.excilys.kataspoker.model.Valeur;


public class BrelanSolver {
	private static Object List;

	public static int calcul(Main main) {
		// Appeler la méthode evaluerMain pour calculer le score de la main
		return evaluerMain(main.getCartes());
	}

	public static int evaluerMain(List<Carte> main) {
		// Créer une carte de comptage pour les valeurs
		Map<Valeur, Integer> carteCounts = new HashMap<>();

		// Comptage des occurrences des valeurs des cartes
		for (Carte carte : main) {
			carteCounts.put(carte.getValeur(), carteCounts.getOrDefault(carte.getValeur(), 0) + 1);
		}

		// Vérifier la présence d'un brelan (3 cartes de même valeur)
		for (Map.Entry<Valeur, Integer> entry : carteCounts.entrySet()) {
			if (entry.getValue() == 3) { // Si il y a 3 cartes de même valeur
				return entry.getKey().getOrdre() * 1000 + 3; // Score basé sur la valeur du brelan (valeur * 1000)
			}
		}

		// Si pas de brelan, retourner un score nul (main invalide ou autre main)
		return 0;
	}
}
