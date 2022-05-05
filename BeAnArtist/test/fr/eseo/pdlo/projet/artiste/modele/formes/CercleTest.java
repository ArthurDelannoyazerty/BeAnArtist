package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class CercleTest {
	@Test
	void testConstructeurVide() {
		Cercle e = new Cercle();
		
		assertEquals(100.0, e.getHauteur(), "hauteur 100 attendu");
		assertEquals(100.0, e.getLargeur(), "largeur 100 attendu");
		assertEquals(new Coordonnees(), e.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	
	@Test
	void testConstructeurDouble() {
		Cercle e = new Cercle(2.0);
		
		assertEquals(2.0, e.getHauteur(), "hauteur 2 attendu");
		assertEquals(2.0, e.getLargeur(), "largeur 3 attendu");
		assertEquals(new Coordonnees(), e.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	@Test
	void testConstructeurCoordonnees() {
		Cercle e = new Cercle(new Coordonnees());
		
		assertEquals(100.0, e.getLargeur(), "hauteur 2 attendu");
		assertEquals(100.0, e.getHauteur(), "largeur 3 attendu");
		assertEquals(new Coordonnees(), e.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	@Test
	void testConstructeurCoordonneesDoubleDouble() {
		Cercle e = new Cercle(new Coordonnees());
		
		assertEquals(100.0, e.getLargeur(), "hauteur 2 attendu");
		assertEquals(100.0, e.getHauteur(), "largeur 3 attendu");
		assertEquals(new Coordonnees(), e.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	@Test
	void testSetLargeur() {
		Cercle e = new Cercle(new Coordonnees());
		
		e.setLargeur(2.0);
		
		assertEquals(2.0, e.getLargeur(), "largeur 2 attendu");
	}
	
	@Test
	void testSetHauteur() {
		Cercle e = new Cercle(new Coordonnees());
		
		e.setHauteur(2.0);
		
		assertEquals(2.0, e.getHauteur(), "hauteur 2 attendu");
	}
	
	@Test
	void testAire() {
		Cercle e = new Cercle(2.0);
		
		assertEquals(1.0 * Math.PI, e.aire(), "hauteur 2 attendu");
	}
	
	@Test
	void testPerimetre() {
		Cercle e = new Cercle(2.0);
		
		assertFalse( 0.0 == e.perimetre(), "hauteur 2 attendu");
	}
	
	@Test
	void testContient() {
		Cercle e = new Cercle(2.0);
		
		assertTrue( e.contient(new Coordonnees(1.0,1.0)), "hauteur 2 attendu");
	}
	

	@Test
	void testContientFalse() {
		Cercle e = new Cercle(2.0);
		
		assertFalse( e.contient(new Coordonnees(10.0,10.0)), "hauteur 2 attendu");
	}
	
	@Test
	void testToString() {
		Cercle e = new Cercle(2.0);
		
		assertEquals("[Cercle Aucun] : pos (0,0 , 0,0) rayon 1,0 périmètre : 6,28 aire : 3,14 couleur = R51,V51,B51"
				, e.toString()
				, "test toString");
	}
	
	@Test
	void testRemplissage() {
		Cercle e = new Cercle();
		
		e.setRemplissage(Remplissage.AUCUNE);
		assertEquals(Remplissage.AUCUNE, e.getRemplissage(), "test remplissage");
		
	}
	
	@Test
	void testRemplissageUniforme() {
		Cercle e = new Cercle();
		
		e.setRemplissage(Remplissage.UNIFORME);
		assertEquals(Remplissage.UNIFORME, e.getRemplissage(), "test remplissage");
		
	}
}
