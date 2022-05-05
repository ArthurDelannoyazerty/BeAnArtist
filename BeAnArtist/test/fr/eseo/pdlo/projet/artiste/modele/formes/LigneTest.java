package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class LigneTest {
	
	@Test
	void testConstructeurVide() {
		Ligne ligne = new Ligne();
		
		assertEquals(100.0, ligne.getHauteur(), "hauteur 100 attendu");
		assertEquals(100.0, ligne.getLargeur(), "largeur 100 attendu");
		assertEquals(new Coordonnees(), ligne.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	@Test
	void testConstructeurDoubleDouble() {
		Ligne ligne = new Ligne(1.0,2.0);
		
		assertEquals(2.0, ligne.getHauteur(), "hauteur 1.0 attendu");
		assertEquals(1.0, ligne.getLargeur(), "largeur 2.0 attendu");
		assertEquals(new Coordonnees(0.0,0.0), ligne.getPosition(), "position (0.0,0.0) attendu");	//fonctionne bien
	}
	
	@Test
	void testConstructeurCoordonnees() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0));
		
		assertEquals(100.0, ligne.getHauteur(), "hauteur 100.0 attendu");
		assertEquals(100.0, ligne.getLargeur(), "largeur 100.0 attendu");
		assertEquals(new Coordonnees(1.0,2.0), ligne.getPosition(), "position (1.0,2.0) attendu");	//fonctionne bien
	}
	
	@Test
	void testConstructeurCoordonneesDoubleDouble() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),5.0,3.0);
		
		assertEquals(3.0, ligne.getHauteur(), "hauteur 3.0 attendu");
		assertEquals(5.0, ligne.getLargeur(), "largeur 5.0 attendu");
		assertEquals(new Coordonnees(1.0,2.0), ligne.getPosition(), "position (1.0,2.0) attendu");	//fonctionne bien
	}
	
	@Test
	void testGetC1C2() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),5.0,3.0);
		
		assertEquals(new Coordonnees(1.0,2.0), ligne.getC1(), "(1.0, 2.0) attendu");
		assertEquals(new Coordonnees(1.0+5.0,2.0+3.0), ligne.getC2(), "(6.0, 5.0) attendu");
	}
	
	@Test
	void testSetC1C2() {
		Ligne ligne = new Ligne(new Coordonnees());
		
		ligne.setC1(new Coordonnees(1.0,2.0));
		ligne.setC2(new Coordonnees(3.0,4.0));
		
		assertEquals(new Coordonnees(1.0,2.0), ligne.getC1(), "(1.0, 2.0) attendu");
		assertEquals(new Coordonnees(3.0,4.0), ligne.getC2(), "(3.0, 4.0) attendu");
	}
	
	@Test
	void testSetGetMinMax() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),5.0,3.0);
		
		
		assertEquals(1.0, ligne.getMinX(), "1.0 attendu");
		assertEquals(2.0, ligne.getMinY(), "2.0 attendu");
		assertEquals(6.0, ligne.getMaxX(), "6.0 attendu");
		assertEquals(5.0, ligne.getMaxY(), "5.0 attendu");
	}
	
	@Test
	void testAire() {
		Ligne ligne = new Ligne();
		
		assertEquals(0.0, ligne.aire(), "aire nulle");
	}
	
	@Test
	void testPerimetre() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),0.0,3.0);
		
		assertEquals(3.0, ligne.perimetre(), "perimetre = distance = 3.0");
	}
	
	@Test
	void testContient() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),0.0,3.0);
		
		assertTrue(ligne.contient(new Coordonnees(1.0, 4.0)));
		assertFalse(ligne.contient(new Coordonnees(0,0)));
	}
	
	@Test
	void testToString() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),0.0,3.0);
		
		assertEquals("[Ligne] c1 : (1,0 , 2,0) c2 : (1,0 , 5,0) longueur : 3,0 angle : 90,0° couleur = R51,V51,B51",
					 ligne.toString(),
					 "Bon String attendu");
	}

	
}
