package main.java.com.excilys.kataspoker.solvers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import main.java.com.excilys.kataspoker.model.Carte;
import main.java.com.excilys.kataspoker.model.Combinaison;
import main.java.com.excilys.kataspoker.model.Couleur;
import main.java.com.excilys.kataspoker.model.Main;
import main.java.com.excilys.kataspoker.model.Valeur;

public class FullSolverTest {
	
	@Test
	public void should_find_full() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.TROIS));
		
		assertEquals(Combinaison.FULL, FullSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_full_because_paire() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertNotEquals(Combinaison.FULL, FullSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_full_because_brelan() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertNotEquals(Combinaison.FULL, FullSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_full_because_double_pair() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertNotEquals(Combinaison.FULL, FullSolver.calcul(main).getCombinaison());
	}

	@Test
	public void should_not_find_full_because_carre() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.TROIS));
		
		assertNotEquals(Combinaison.FULL, FullSolver.calcul(main).getCombinaison());
	}

}
