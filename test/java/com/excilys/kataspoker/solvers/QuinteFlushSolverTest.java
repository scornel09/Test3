package main.java.com.excilys.kataspoker.solvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import main.java.com.excilys.kataspoker.model.Carte;
import main.java.com.excilys.kataspoker.model.Combinaison;
import main.java.com.excilys.kataspoker.model.Couleur;
import main.java.com.excilys.kataspoker.model.Main;
import main.java.com.excilys.kataspoker.model.NotEnoughCardsException;
import main.java.com.excilys.kataspoker.model.Valeur;

public class QuinteFlushSolverTest {
	
	@Test
	public void should_find_quinte_flush() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		try {
			assertEquals(Combinaison.QUINTE_FLUSH, QuinteFlushSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void should_not_find_quinte_flush_because_suite() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		try {
			assertNotEquals(Combinaison.QUINTE_FLUSH, QuinteFlushSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void should_find_not_find_quinte_flush_because_couleur() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DIX));
		
		try {
			assertNotEquals(Combinaison.QUINTE_FLUSH, QuinteFlushSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail(e.getMessage());
		}
	}
	
	
	
}
