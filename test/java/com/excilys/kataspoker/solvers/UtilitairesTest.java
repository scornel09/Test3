package main.java.com.excilys.kataspoker.solvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.com.excilys.kataspoker.model.CardNotFoundException;
import main.java.com.excilys.kataspoker.model.Carte;
import main.java.com.excilys.kataspoker.model.Couleur;
import main.java.com.excilys.kataspoker.model.Main;
import main.java.com.excilys.kataspoker.model.Valeur;

public class UtilitairesTest {
	
	@Test
	public void trierParValeurShouldWork() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.ROI));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		
		Main mainResultat = new Main();
		mainResultat.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		mainResultat.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		mainResultat.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		mainResultat.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		mainResultat.getCartes().add(new Carte(Couleur.COEUR, Valeur.ROI));
		
		assertEquals(mainResultat.getCartes(), Utilitaires.trierParValeur(main));
	}

	@Test
	public void contientLeRoiDeCoeurShouldReturnTrue() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.ROI));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		assertEquals(true, Utilitaires.contientLeRoiDeCoeur(main));
	}
	
	@Test
	public void contientLeRoiDeCoeurShouldReturnFalse() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		assertEquals(false, Utilitaires.contientLeRoiDeCoeur(main));
	}
	
	@Test
	public void contientUneCarteSpecifiqueShouldFindCard() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		Carte carteATrouver = new Carte(Couleur.CARREAU, Valeur.SIX);
		
		try {
			assertEquals(carteATrouver, Utilitaires.contientUneCarteSpecifique(main, carteATrouver));
		} catch (CardNotFoundException e) {
			fail();
		}
	}
	
	@Test
	public void contientUneCarteSpecifiqueShouldThrowException() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		Carte carteATrouver = new Carte(Couleur.CARREAU, Valeur.SEPT);
		
		assertThrows(CardNotFoundException.class, () -> Utilitaires.contientUneCarteSpecifique(main, carteATrouver));
	}
	
	@Test
	public void trouveLaMeilleureCarteDansMainShouldFindKing() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.ROI));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));

		Carte carteATrouver = new Carte(Couleur.CARREAU, Valeur.ROI);
		
		assertEquals(carteATrouver,  Utilitaires.trouveLaMeilleureCarteDansMain(main));
	}
	
	@Test
	public void calculeSommeValeursShouldReturn25() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.ROI));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));

		
		assertEquals(25,  Utilitaires.calculeSommeValeurs(main));
	}
	
	@Test
	public void calculeSommeValeursShouldReturn50() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DAME));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DAME));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.AS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));

		
		assertEquals(50,  Utilitaires.calculeSommeValeurs(main));
	}
	
	@Test
	public void groupeParValeurShouldWork() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DAME));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DAME));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.AS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.VALET));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.SIX));
		
		Map<Valeur, List<Carte>> result = Utilitaires.groupeParValeur(main);
		assertNotEquals(null, result.get(Valeur.DAME));
		assertEquals(2, result.get(Valeur.DAME).size());
		assertEquals(3, result.get(Valeur.VALET).size());
	}
	
	@Test
	public void groupeLesValeursDansStringShouldWork() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DAME));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DAME));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.AS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.VALET));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.SIX));
		
		assertEquals("Dame,Dame,Valet,As,Valet,Valet,As,6", Utilitaires.groupeLesValeursDansString(main));
	}
	
	@Test
	public void regrouperCartesShouldWork() {
		Main main1 = new Main();
		main1.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DAME));
		main1.getCartes().add(new Carte(Couleur.COEUR, Valeur.DAME));
		main1.getCartes().add(new Carte(Couleur.TREFLE, Valeur.VALET));
		
		Main main2 = new Main();
		main2.getCartes().add(new Carte(Couleur.PIQUE, Valeur.AS));
		main2.getCartes().add(new Carte(Couleur.CARREAU, Valeur.VALET));
		main2.getCartes().add(new Carte(Couleur.TREFLE, Valeur.VALET));
		
		Main main3 = new Main();
		main3.getCartes().add(new Carte(Couleur.TREFLE, Valeur.AS));
		main3.getCartes().add(new Carte(Couleur.TREFLE, Valeur.SIX));
		
		List<Main> toTest = new ArrayList<Main>();
		toTest.add(main1);
		toTest.add(main2);
		toTest.add(main3);
		
		List<Carte> result = Utilitaires.regrouperCartes(toTest);
		
		assertEquals(8, result.size());
	}
	
	@Test
	public void regrouperEtTrierParValeurShouldWork() {
		Main main1 = new Main();
		main1.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DAME));
		main1.getCartes().add(new Carte(Couleur.COEUR, Valeur.ROI));
		main1.getCartes().add(new Carte(Couleur.TREFLE, Valeur.VALET));
		
		Main main2 = new Main();
		main2.getCartes().add(new Carte(Couleur.PIQUE, Valeur.AS));
		main2.getCartes().add(new Carte(Couleur.CARREAU, Valeur.NEUF));
		main2.getCartes().add(new Carte(Couleur.TREFLE, Valeur.DIX));
		
		Main main3 = new Main();
		main3.getCartes().add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main3.getCartes().add(new Carte(Couleur.TREFLE, Valeur.SIX));
		
		List<Main> toTest = new ArrayList<Main>();
		toTest.add(main1);
		toTest.add(main2);
		toTest.add(main3);
		
		List<Carte> result = Utilitaires.regrouperEtTrierParValeur(toTest);
		
		List<Carte> resultExpected = new ArrayList<Carte>();
		resultExpected.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		resultExpected.add(new Carte(Couleur.TREFLE, Valeur.SIX));
		resultExpected.add(new Carte(Couleur.CARREAU, Valeur.NEUF));
		resultExpected.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		resultExpected.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		resultExpected.add(new Carte(Couleur.CARREAU, Valeur.DAME));
		resultExpected.add(new Carte(Couleur.COEUR, Valeur.ROI));
		resultExpected.add(new Carte(Couleur.PIQUE, Valeur.AS));
		
		assertEquals(resultExpected, result);
	}
}
